package com.mft.general.controller;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author m.fatahi
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    @GetMapping(value = "/currentUser")
    public Principal getCurrentUser(Principal user) {
        return user;
    }

}
