package com.tms.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        //System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message","Hello " + name + " " + surname);
        return "first/hello";
    }
//    public String helloPage(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//    System.out.println("Hello " + name + " " + surname);
//        return "first/hello";
//    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a, @RequestParam("b") int b,
                             @RequestParam("action") String action, Model model) {

        double result = switch (action) {
            case "multiplication" -> a * b;
            case "division" -> a / (double) b;
            case "subtraction" -> a - b;
            case "addition" -> a + b;
            default -> 0;
        };

        model.addAttribute("result", result);

        return "first/calculator";
    }
}
