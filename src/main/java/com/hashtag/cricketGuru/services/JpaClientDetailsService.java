package com.hashtag.cricketGuru.services;

import com.hashtag.cricketGuru.model.OAuthClientDetails;
import com.hashtag.cricketGuru.repo.OAuthClientDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class JpaClientDetailsService implements ClientDetailsService {

    private final OAuthClientDetailsRepository clientDetailsRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public JpaClientDetailsService(OAuthClientDetailsRepository clientDetailsRepository) {
        this.clientDetailsRepository = clientDetailsRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        OAuthClientDetails clientDetails = clientDetailsRepository.findByClientId(clientId);

        if (clientDetails == null) {
            System.out.println("Client not found with id: " + clientId);
            throw new ClientRegistrationException("Client not found with id: " + clientId);
        }
        BaseClientDetails details = new BaseClientDetails();
        details.setClientId(clientDetails.getClientId());
        details.setClientSecret(clientDetails.getClientSecret());
        details.setScope(Arrays.asList(clientDetails.getScope().split(",")));
        details.setAuthorizedGrantTypes(Arrays.asList(clientDetails.getAuthorizedGrantTypes().split(",")));
        details.setAccessTokenValiditySeconds(clientDetails.getAccessTokenValiditySeconds());
        details.setRefreshTokenValiditySeconds(clientDetails.getRefreshTokenValiditySeconds());// Grant types

        // Convert OAuthClientDetails to Spring Security ClientDetails implementation
        return details;// Implement CustomClientDetails as needed
    }

    public void addClientDetails(
            String clientId,
            String clientSecret,
            List<String> scopes,
            List<String> grantTypes,
            Integer accessTokenValiditySeconds,
            Integer refreshTokenValiditySeconds
    ) {
        // Create and save new client details in the repository or perform desired actions
        OAuthClientDetails newClientDetails = new OAuthClientDetails();
        newClientDetails.setClientId(clientId);
        newClientDetails.setClientSecret(passwordEncoder.encode(clientSecret));
        newClientDetails.setScope(String.join(",", scopes));
        newClientDetails.setAuthorizedGrantTypes(String.join(",", grantTypes));
        newClientDetails.setAccessTokenValiditySeconds(accessTokenValiditySeconds);
        newClientDetails.setRefreshTokenValiditySeconds(refreshTokenValiditySeconds);

        // Save the new client details in the repository
        clientDetailsRepository.save(newClientDetails);
    }
}
