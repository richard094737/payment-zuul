package com.loopsports.service;

import com.loopsports.dao.WhiteListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WhiteListService {

    @Autowired
    private WhiteListDao  whiteListDao;

    public void saveWhiteList(){
        whiteListDao.saveWhiteList();
    }
}
