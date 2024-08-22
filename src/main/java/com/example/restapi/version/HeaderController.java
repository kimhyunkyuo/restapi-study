package com.example.restapi.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class HeaderController {

    @GetMapping(value = "header", params = "v1=1")
    public String paramV1(){
        return "headersV1";
    }

    @GetMapping(value = "header", params = "v1=2")
    public String paramV2(){
        return "headersV2";
    }
}
