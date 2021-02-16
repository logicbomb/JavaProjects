package com.rukon.Steams;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class GreetingController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String greeting4(@RequestParam(name="name", required=false, defaultValue="Rukon") String name,
//                            @RequestParam(name="age", required=false, defaultValue="0") String age,
//                            Model model) {
//        model.addAttribute("name", name);
//        model.addAttribute("age", age);

        public String greeting4(){
        return " greeting4";
    }

        @RequestMapping(value = "/greeting", method = RequestMethod.POST)
        public String greeting(
//        @RequestParam(name="name", required=false, defaultValue="Rukon") String name,
//                               @RequestParam(name="age", required=false, defaultValue="0") String age,
//                               Model model
                               )
        {
//            model.addAttribute("name", name);
//            model.addAttribute("age", age);
            return "greeting";
        }





    }

