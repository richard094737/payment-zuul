package com.loopsports.dao;


import com.loopsports.domain.WhiteList;

import java.util.List;

public interface WhiteListDao {

    Long  checkeDaifuOnOff(String merNo, Integer gateway);
    List<WhiteList> getDaifuWhiteList(String merNo, Integer gateway);

}
