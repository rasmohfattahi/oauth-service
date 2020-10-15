package com.mft.oauth.config;

import javax.servlet.http.HttpServletRequest;

import com.mft.oauth.dao.ResourceRepository;
import com.mft.oauth.entities.Resource;
import com.mft.oauth.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityMessageSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mft.oauth.service.IUserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OauthUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ResourceRepository resourceRepository;

    protected MessageSourceAccessor messages = SpringSecurityMessageSource.getAccessor();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        User userEntity = userService.findByUsername(username).orElseThrow(() -> new BadCredentialsException(
                messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "Bad credentials")));
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        List<Resource> resources = resourceRepository.findRolesByUserId(userEntity.getId());
        resources.forEach(resource -> {
            authorities.add(new SimpleGrantedAuthority(resource.getResourceName()));
        });
        userEntity.setAuthorities(authorities);
        return userEntity;
    }
}
