package com.followjs.service;

import com.followjs.entity.LuoGuData;
import org.springframework.stereotype.Service;

public interface LuoGuService {

    public LuoGuData getLuoGuInfo(String username) throws Exception;
}
