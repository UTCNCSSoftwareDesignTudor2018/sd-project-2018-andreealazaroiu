package com.cookingrecipes.project.presentation.controllers;

import com.cookingrecipes.project.business.AdminService;
import com.cookingrecipes.project.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    private ModelAndView modelAndView;

    @GetMapping("/")
    public String loginPage()
    {
        return "LoginPage";
    }

    @GetMapping("CreateAccountPage")
    public String createAccount()
    { return "CreateAccountPage"; }

    @PostMapping("CreateAccountPage")
    public String insertAccount(@RequestParam("putfullname")String name,
                                @RequestParam("putusername")String usname,
                                @RequestParam("putpassword")String passw,
                                @RequestParam("putemail") String email)
    {

        userService.createAccount(name,usname,passw,email);
        return "LoginPage";
    }

}
