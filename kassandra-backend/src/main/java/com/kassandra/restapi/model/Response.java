package com.kassandra.restapi.model;

import com.kassandra.restapi.dto.BaseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Onur Karaduman
 * @since 15.07.17
 */
public class Response<T> extends ResponseEntity<T> {

    public Response() {
        super(HttpStatus.OK);
    }

    public Response(T body, HttpStatus status) {
        super(body, status);
    }

    public Response(T body) {
        super(body, HttpStatus.OK);
    }
}
