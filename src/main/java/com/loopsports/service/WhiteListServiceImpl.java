package com.loopsports.service;

import com.loopsports.constants.Gateway;
import com.loopsports.dao.WhiteListDaoImpl;
import com.loopsports.domain.WhiteList;
import com.loopsports.utils.NetworkUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service
@Transactional
public class WhiteListServiceImpl implements WhiteListService {

    @Autowired
    private WhiteListDaoImpl whiteListDao;


    public boolean checkDaifuWhiteList(HttpServletRequest request) throws Exception {
        String ip = NetworkUtils.getIpAddress(request);
        String gatewayParam = request.getParameter("gateway");
        String merNo = request.getParameter("merNo");

        boolean isDaifu  = isDaifu(gatewayParam);

        if(isDaifu) {
            Long ipCheckeNum = checkDaifu(merNo);
            if (ipCheckeNum == 0 ){
                //无代付需要提供代付IP地址
                return true;
            }else{
                boolean isDaifuIp = isDaifuWhiteListIP(merNo,ip);
                if( isDaifuIp){
                    return true;
                }
                return false;
            }
        }
        return true;
    }


    private boolean isDaifu(String gatewayParam) {
        if (Gateway.DAIFU.getMsg().equalsIgnoreCase(gatewayParam)) {
            return true;
        }else{
            return false;
        }
    }


    private Long checkDaifu(String merNo){
        Integer gateway = Gateway.DAIFU.getCode();
        Long  ipCheckNum = whiteListDao.checkeDaifuOnOff(merNo, gateway);
        return ipCheckNum;
    }

    private boolean isDaifuWhiteListIP(String merNo, String ip){
        Integer gateway = Gateway.DAIFU.getCode();
        List<WhiteList> whiteLists = whiteListDao.getDaifuWhiteList(merNo, gateway);
        for (WhiteList whiteList :
                whiteLists) {
           String ipAddress =  whiteList.getListValue();
           if(ipAddress.equalsIgnoreCase(ip)){
               return true;
           }
        }
        return false;

    }
}
