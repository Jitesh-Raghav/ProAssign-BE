package com.jira.proassign.controller;

import com.jira.proassign.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://proassign-jitesh-raghavs-projects.vercel.app")
public class HomeController {

    @GetMapping("")
    public ResponseEntity<ApiResponse> homeController(){
        ApiResponse res=new ApiResponse("welcome to user service",true);
        return new ResponseEntity<ApiResponse>(res, HttpStatus.ACCEPTED);
    }

}
