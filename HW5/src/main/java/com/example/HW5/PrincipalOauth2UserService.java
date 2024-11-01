package com.example.HW5;

import com.example.HW5.user.entity.User;
import com.example.HW5.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    public PrincipalOauth2UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        log.info("Google에서 받아온 UserRequest : " + oAuth2UserRequest);
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        log.info("oauth에서 받아온 정보: " + oAuth2User.getAttributes());

        // 받아온 사용자 정보
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        String givenName = oAuth2User.getAttribute("given_name");
        String familyName = oAuth2User.getAttribute("family_name");
        String picture = oAuth2User.getAttribute("picture");

        // 이메일로 기존 사용자 조회
        User user = userRepository.findByEmail(email);
        if (user == null) {
            user = new User(); // 새로운 사용자 생성
        }
        user.setEmail(email);
        user.setName(name);
        user.setGivenName(givenName);
        user.setFamilyName(familyName);
        user.setPictureUrl(picture);
        userRepository.save(user);

        return oAuth2User;
    }
}