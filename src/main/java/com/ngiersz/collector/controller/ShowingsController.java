package com.ngiersz.collector.controller;

import com.ngiersz.collector.domain.Show;
import com.ngiersz.collector.domain.ShowWrapper;
import com.ngiersz.collector.service.ShowingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/show")
@ComponentScan("com.ngiersz.collector.persistance")
public class ShowingsController {

    @Autowired
    protected ShowingsService showingsService;

    public ShowingsController(ShowingsService showingsService) {
        this.showingsService = showingsService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public Long addShowing(@RequestBody ShowWrapper showWrapper) {
        showingsService.save(showWrapper.getShow(), showWrapper.getMovie());
        return 2L;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Show> getAll() {
        return showingsService.findAll();
    }
}
