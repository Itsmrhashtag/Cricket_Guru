package com.hashtag.cricketGuru.repo;

import com.hashtag.cricketGuru.model.OAuthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuthClientDetailsRepository extends JpaRepository<OAuthClientDetails, String> {
    OAuthClientDetails findByClientId(String clientId);
}
