package org.bjc.epic.fhirworks;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CdsRestController
{

    @RequestMapping("/hello")
    public String helloWorld(Model model)
    {
        model.addAttribute("message", "Hello!");
        return "hello";
    }

}