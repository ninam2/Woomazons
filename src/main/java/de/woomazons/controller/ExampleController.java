package de.woomazons.controller;


import de.woomazons.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class ExampleController {

    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping("/")
    public String getLabels(Map<String, Object> model) {
        model.put("labelList", repositoryService.getAllLabelNames());
        return "start";
    }

}

