package com.example.fiegn.springbootsoapclient.service;

import com.example.fiegn.springbootsoapclient.client.SoapClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.jaxb.JAXBContextFactory;
import feign.soap.SOAPDecoder;
import feign.soap.SOAPEncoder;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.oorsprong.websamples.FullCountryInfo;
import org.oorsprong.websamples.FullCountryInfoResponse;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FiegnService {

   public FullCountryInfoResponse soapServiceCall(){
       JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder()
               .withMarshallerJAXBEncoding("UTF-8").build();
       SoapClient client = Feign.builder()
               .encoder(new SOAPEncoder(jaxbFactory))
               .decoder(new SOAPDecoder(jaxbFactory))
               .target(SoapClient.class, "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso");

       FullCountryInfo fullCountryInfo = new FullCountryInfo();
       fullCountryInfo.setSCountryISOCode("IN");
       FullCountryInfoResponse fullCountryInfoResponse = client.fullCountryInfoWithPlainText(fullCountryInfo);
       log.info("Full Country Response {}", fullCountryInfoResponse);
       return fullCountryInfoResponse;
   }
}
