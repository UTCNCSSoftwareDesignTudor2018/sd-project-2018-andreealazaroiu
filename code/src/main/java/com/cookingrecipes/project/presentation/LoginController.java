package com.cookingrecipes.project.presentation;

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

    @GetMapping("UserPage")
    public String userLogin(@RequestParam("lu") String username,@RequestParam("lp") String password)
    {
        if( userService.verifyIfUser(username,password)==true)
             return "UserPage";
        else
           return "LoginPage";
    }

    @GetMapping("CreateAccountPage")
    public String createAccount()
    { return "CreateAccountPage"; }

    @PostMapping("CreateAccountPage")
    public String insertAccount(@RequestParam("putfullname")String name,
                                @RequestParam("putusername")String usname,
                                @RequestParam("putpassword")String passw)
    {
        userService.createAccount(name,usname,passw);
        return "CreateAccountPage";
    }

}
