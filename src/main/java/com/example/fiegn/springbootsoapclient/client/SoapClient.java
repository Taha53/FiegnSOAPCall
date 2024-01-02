package com.example.fiegn.springbootsoapclient.client;

import feign.Headers;
import feign.RequestLine;
import org.oorsprong.websamples.FullCountryInfo;
import org.oorsprong.websamples.FullCountryInfoResponse;

public interface SoapClient {
    @RequestLine("POST")
    @Headers({"SOAPAction: FullCountryInfo", "Content-Type: text/xml;charset=UTF-8",
            "Accept: text/xml"})
    FullCountryInfoResponse fullCountryInfoWithPlainText(FullCountryInfo soapBody);
}