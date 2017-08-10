package com.kassandra.restapi.resource;

import com.kassandra.restapi.controller.ExchangeRateController;
import com.kassandra.restapi.controller.NewsController;
import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
/**
 * @author Onur Karaduman
 * @since 15.07.17
 */
public class RootResource extends ResourceSupport {
    private String message;

    public RootResource() {
        this.message = "Welcome to connect4 api version 1.0.0";
        add(
                linkTo(NewsController.class).withRel("news")
        );

    }
}
