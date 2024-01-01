package com.hashtag.cricketGuru.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "oauth_client_details")
public class OAuthClientDetails {
    @Id
    private String clientId;
    private String clientSecret;
    private String scope;
    private String authorizedGrantTypes;
    private Integer accessTokenValiditySeconds;
    private Integer refreshTokenValiditySeconds;

    // getters and setters
}
