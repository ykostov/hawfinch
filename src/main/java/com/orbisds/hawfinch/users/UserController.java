package com.orbisds.hawfinch.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @RequestMapping("/hawfinch")
    public String callme()
    {
        return "hello hawfinch";
    }

}
