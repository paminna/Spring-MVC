package ru.firstspringapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController
{
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value= "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model)
    {
        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam(value= "one", required = false) Integer first,
                             @RequestParam(value = "two", required = false) Integer second,
                             @RequestParam(value= "act", required = false) String action,
                             Model model)
    {
//        String answer = "Start calculating";
        if (first == null)
            first = 0;
        if (second == null)
            second = 0;
        if (action == null)
            action = "error";
        System.out.println(action);
        System.out.println("first: " + first);
        System.out.println(second);
        System.out.println("keki:" + first+second);
        Integer ans = 0;
        switch (action) {
            case "addition":
                ans = first+second;
                System.out.println("add");
                break;
//                answer = ans.toString();
            case "multiplication":
                ans = first*second;
                System.out.println("mult");
                break;
//                answer = ans.toString();
            case "subtraction":
                ans = first-second;
                System.out.println("sub");
                break;
//                answer = ans.toString();
            case "division":
                ans = first/second;
                System.out.println("div");
                break;
//                answer = ans.toString();
        }
        System.out.println(ans);
        model.addAttribute("message", "Result " + ans);
        return "first/calculator";
    }
    @GetMapping("/goodbye")
    public String goodbyePage()
    {
        return "first/goodbye";
    }
}
