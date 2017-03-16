package org.bjc.epic.fhirworks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class CdsRestController
{

    @RequestMapping("/hello")
    public String helloWorld(@RequestParam Map<String,String> params, Model model)
    {

        model.addAttribute("message", "Hello!");
        model.addAttribute("params", params);
        return "hello";
    }

}