package de.asideas.texx.controller;

import de.asideas.texx.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
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

