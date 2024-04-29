package com.followjs.controller;
import com.followjs.service.LuoGuService;
import com.followjs.entity.LuoGuData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class LuoGuController {

    @Autowired
    private LuoGuService luoGuoService;

    @GetMapping("/luogu/info/{username}")
    public LuoGuData getLuoGuInfo(@PathVariable("username") String username) throws Exception {
        System.out.println(username);
        LuoGuData luoGuData = luoGuoService.getLuoGuInfo(username);
        return luoGuData;
    }
}