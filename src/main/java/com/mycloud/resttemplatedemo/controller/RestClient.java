package com.mycloud.resttemplatedemo.controller;/*
 *
 * @author Lawshiga
 *
 */

import com.mycloud.resttemplatedemo.model.UserData;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RestClient {

    // we are going to consume all these REST endpoints
    // and create separate methods to consume each REST endpoints
    private static final String GET_ALL_USER_API = "http://localhost:8181/api/users";
    private static final String GET_USER_BY_ID_API = "http://localhost:8181/api/users/{id}";
    private static final String CREATE_USER_API = "http://localhost:8181/api/users";
    private static final String UPDATE_USER_API = "http://localhost:8181/api/users/{id}";
    private static final String DELETE_USER_API = "http://localhost:8181/api/users/{id}";

    static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        callGetAllUserAPI();
        callGetUserByIdAPI();
        callCreateUserAPI();
        callUpdateUserAPI();
        callDeleteUserAPI();

    }

    private static void callGetAllUserAPI(){
        // need to create HTTP header
        HttpHeaders headers = new HttpHeaders();
        // and client is Accepting a JSON response from REST API
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        // restTemplate.exchange("url", "method", "requestEntity", "responseType")
        // here we need to get json as the string in responsetype
        ResponseEntity<String> result = restTemplate.exchange(GET_ALL_USER_API, HttpMethod.GET, entity, String.class);
        System.out.println(result);

    }

    private static void callGetUserByIdAPI(){
        Map<String, Integer> param = new HashMap<>();
        param.put("id", 3);
        UserData userData = restTemplate.getForObject(GET_USER_BY_ID_API, UserData.class, param);
        System.out.println(userData.getFirstName());
        System.out.println(userData.getLastName());
        System.out.println(userData.getEmail());

    }

    private static void callCreateUserAPI(){
        UserData userData = new UserData("Bruce", "Banner", "hulk@gmail.com");
        ResponseEntity<UserData> user = restTemplate.postForEntity(CREATE_USER_API, userData, UserData.class);
        System.out.println(user.getBody());
    }

    private static void callUpdateUserAPI(){
        Map<String, Integer> param = new HashMap<>();
        param.put("id", 5);
        UserData updatedUser = new UserData("Mitchel", "Obama", "om@gmail.com");
        restTemplate.put(UPDATE_USER_API, updatedUser,param); // put method returns void
    }

    private static void callDeleteUserAPI(){
        Map<String, Integer> param = new HashMap<>();
        param.put("id", 5);
        restTemplate.delete(DELETE_USER_API, param); // delete method returns void
    }
}
