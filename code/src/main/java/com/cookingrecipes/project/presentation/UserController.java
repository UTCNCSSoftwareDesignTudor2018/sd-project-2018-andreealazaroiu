package com.cookingrecipes.project.presentation;

import com.cookingrecipes.project.business.UserService;
import com.cookingrecipes.project.dataAccess.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private ModelAndView mv;
    private ModelAndView m;

    @Autowired
    UserService userService;

    @GetMapping("UserPage")
    public String userLogin(@RequestParam("lu") String username, @RequestParam("lp") String password)
    {
        mv=new ModelAndView("UserPage");
        User theuser=userService.getUser(username,password);
        mv.addObject("tu",theuser);
        if(userService.verifyIfUser(username, password))
            return "UserPage";
        else
            return "LoginPage";
    }

    @RequestMapping(value="LoginPage/UserPage/EditAccountPage",method= RequestMethod.GET)
    public ModelAndView editAccount()
    {
        m=new ModelAndView("EditAccountPage");
        m.addObject("tu",mv.getModel().get("tu"));

        return m;
    }

    @PostMapping("LoginPage/UserPage/EditAccountPage")
    public ModelAndView editAccountOk(@RequestParam("putname")String name,
                                @RequestParam("putusername")String username,
                                @RequestParam("putpassw")String passw,
                                @RequestParam("putemail")String email)
    {
        userService.updateAccount((User)mv.getModel().get("tu"),name,username,passw,email);
        m=new ModelAndView("EditAccountPage");
        m.addObject("tu",mv.getModel().get("tu"));
        return m;
    }
}
