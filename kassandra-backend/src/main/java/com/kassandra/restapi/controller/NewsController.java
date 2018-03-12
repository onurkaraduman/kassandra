package com.kassandra.restapi.controller;

import com.kassandra.repository.domain.News;
import com.kassandra.restapi.dto.NewsDto;
import com.kassandra.restapi.model.Response;
import com.kassandra.restapi.util.MapperUtil;
import com.kassandra.service.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Onur Karaduman
 * @since 15.07.17
 */
@RestController
@RequestMapping("/news")
public class NewsController implements Controller {

    @Autowired
    @Qualifier("NewsRealTimeService")
    private NewsService newsDbService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET)
    public Response getExchangeRates(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        List<News> newsByDate = newsDbService.getNewsByDate(date);
        List<NewsDto> dtos = MapperUtil.mapList(newsByDate, NewsDto.class);
        return new Response(dtos);
    }
}
