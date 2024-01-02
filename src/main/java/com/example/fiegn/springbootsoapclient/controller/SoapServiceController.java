package com.example.fiegn.springbootsoapclient.controller;

import com.example.fiegn.springbootsoapclient.service.FiegnService;
import org.oorsprong.websamples.FullCountryInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoapServiceController {

    @Autowired
    private FiegnService fiegnService;

    @GetMapping(path = "/getFullCountry")
    public FullCountryInfoResponse getFullCountryInfo(){
        return fiegnService.soapServiceCall();
    }
}
