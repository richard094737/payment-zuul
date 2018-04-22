package com.loopsports.service;

import javax.servlet.http.HttpServletRequest;

public interface WhiteListService {

    boolean checkDaifuWhiteList(HttpServletRequest request) throws Exception;
}
