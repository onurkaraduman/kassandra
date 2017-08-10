package com.kassandra.restapi.controller;

import com.kassandra.repository.domain.News;
import com.kassandra.restapi.dto.NewsDto;
import com.kassandra.restapi.model.Response;
import com.kassandra.restapi.resource.RootResource;
import com.kassandra.restapi.util.MapperUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author Onur Karaduman
 * @since 15.07.17
 */
@RestController
@RequestMapping("/")
public class RootController implements Controller {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public RootResource getRoot() {
        return new RootResource();
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public Response getError() {

        return null;
    }
}
