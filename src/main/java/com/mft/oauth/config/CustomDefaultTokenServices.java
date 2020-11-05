package com.mft.oauth.config;

import com.mft.general.service.Mapper;
import com.mft.oauth.dto.UserDto;
import com.mft.oauth.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;

public class CustomDefaultTokenServices extends DefaultTokenServices {

    @Autowired
    private Mapper mapper;

   @Value("${spring.mohsen}")
    private String emad;

    @Override
    public OAuth2AccessToken createAccessToken(OAuth2Authentication authentication) throws AuthenticationException {
        OAuth2AccessToken oAuth2AccessToken = super.createAccessToken(authentication);
        User user = (User) authentication.getPrincipal();
        oAuth2AccessToken.getAdditionalInformation().put("user", mapper.map(user, UserDto.class));
        oAuth2AccessToken.getAdditionalInformation().put("emad", emad);
        return oAuth2AccessToken;
    }

}
