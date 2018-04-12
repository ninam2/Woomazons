package de.woomazons.controller;


import de.woomazons.Constants;
import de.woomazons.model.Input;
import de.woomazons.model.Result;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartController {

    @RequestMapping("/")
    public String getLabels() {
        return "start";
    }
}

