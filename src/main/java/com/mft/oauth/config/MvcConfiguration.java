package com.mft.oauth.config;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mft.oauth.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@RestController
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private CustomDefaultTokenServices customDefaultTokenServices;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/oauth/confirm_access").setViewName("authorize");
    }

    @RequestMapping(value = "/login1", method = RequestMethod.GET)
    public String getlogin(Model model, HttpServletResponse response, HttpServletRequest request) {
        return "hello world";
    }

    @RequestMapping(value = "/currentuser", method = RequestMethod.GET)
    public Principal getCurrentUser(Principal user) {
        return user;
    }

    @RequestMapping(value = "/customcurrentuser", method = RequestMethod.GET)
    public User getCustomCurrentUser(Principal user) {
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) user;
        User retUser = (User) oAuth2Authentication.getPrincipal();
        return retUser;
    }

}
