package com.genspark.OAuth2.Data;

import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class ClientData {

    private Map<String,Integer> clientData = Stream.of(new Object[][]{
        {"John Turner", 1000}
    }).collect(Collectors.toMap(data -> (String)data[0],data -> (Integer) data[1]));

    public Integer getProject(String clientName){
        return clientData.get(clientName);
    }
}
