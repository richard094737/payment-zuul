package com.loopsports.mapper;

import com.loopsports.domain.WhiteList;

import java.util.List;

public interface WhiteListMapper {

    List<WhiteList>  checkeDaifuWhiteList(String merNo, Integer gateway);

   Long  checkeDaifuOnOff(String merNo, Integer gateway);
}
