package com.example.fiegn.springbootsoapclient.controller;

import com.example.fiegn.springbootsoapclient.service.FiegnService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.oorsprong.websamples.FullCountryInfoResponse;
import org.oorsprong.websamples.TCountryInfo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SoapServiceControllerTest {

    @InjectMocks
    private SoapServiceController soapServiceController;

    @Mock
    private FiegnService fiegnService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
        fiegnService = null;
        soapServiceController = null;
    }

    @Test
    public void testGetFullCountryInfo(){
        FullCountryInfoResponse fullCountryInfoResponse = new FullCountryInfoResponse();
        TCountryInfo tCountryInfo = new TCountryInfo();
        tCountryInfo.setSName("INDIA");
        fullCountryInfoResponse.setFullCountryInfoResult(tCountryInfo);
        when(fiegnService.soapServiceCall()).thenReturn(fullCountryInfoResponse);
        soapServiceController.getFullCountryInfo();
        assertEquals("INDIA", fullCountryInfoResponse.getFullCountryInfoResult().getSName());
    }
}