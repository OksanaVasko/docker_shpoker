package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SchoolService {

    @Autowired
    RestTemplate restTemplate;


    public void getTimeFromStudentService() {
        String response = restTemplate.exchange("http://student-service/getDateTime", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        }).getBody();
        System.out.println(" Current time is :" + response);

    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
