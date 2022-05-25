package br.com.victorcaselli.frameworkchallenge.config;

import br.com.victorcaselli.frameworkchallenge.entities.User;
import br.com.victorcaselli.frameworkchallenge.repositories.UserRepository;
import br.com.victorcaselli.frameworkchallenge.services.exceptions.UserNotFoundException;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {

	private final UserRepository userRepository;
	
	public JwtTokenEnhancer(UserRepository userRepository) {
		this.userRepository = userRepository; 
		
	}
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		var foundUser = userRepository.findByEmail(authentication.getName());

		if(foundUser.isEmpty()){
			throw new UserNotFoundException("User not found");
		}

		User user = foundUser.get();
		
		Map<String, Object> map = new HashMap<>();
		map.put("userEmail", user.getEmail());
		map.put("userId", user.getId());
		map.put("role", user.getAuthorities());

		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		token.setAdditionalInformation(map);
		
		return accessToken;
	}
}