package edu.neu.csye6225.controller;

import org.springframework.http.HttpHeaders;

public class AbstractController {

    public HttpHeaders getHeaders() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("content-type", "application/json; charset=utf-8");
        responseHeaders.set("access-control-allow-credentials", "true");
        responseHeaders.set("cache-control", "no-cache");
        responseHeaders.set("content-encoding", "gzip");
        responseHeaders.set("access-control-allow-headers", "X-Requested-With,Content-Type,Accept,Origin");
        return responseHeaders;
    }
}
