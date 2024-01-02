package com.example.fiegn.springbootsoapclient.service;

import com.example.fiegn.springbootsoapclient.client.SoapClient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.oorsprong.websamples.FullCountryInfo;
import org.oorsprong.websamples.FullCountryInfoResponse;
import org.oorsprong.websamples.TCountryInfo;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FiegnServiceTest {

    @InjectMocks
    private FiegnService fiegnService;

    @Mock
    private SoapClient soapClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @AfterEach
    void tearDown() {
        fiegnService = null;
        soapClient = null;
    }

    @Test
    void soapServiceCall() {
        FullCountryInfo fullCountryInfo = new FullCountryInfo();
        fullCountryInfo.setSCountryISOCode("IN");
        FullCountryInfoResponse fullCountryInfoResponse = new FullCountryInfoResponse();
        TCountryInfo tCountryInfo = new TCountryInfo();
        tCountryInfo.setSName("KUWAIT");
        fullCountryInfoResponse.setFullCountryInfoResult(tCountryInfo);
        when(soapClient.fullCountryInfoWithPlainText(fullCountryInfo)).thenReturn(fullCountryInfoResponse);
        fiegnService.soapServiceCall();
        assertEquals("KUWAIT", fullCountryInfoResponse.getFullCountryInfoResult().getSName());
    }
}