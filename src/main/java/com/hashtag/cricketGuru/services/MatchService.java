package com.hashtag.cricketGuru.services;


import com.hashtag.cricketGuru.model.Match;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {

    List<Match> getAllMatch();

    List<Match> getAllLiveMatch();

    List<List<String>> getPointTable();
}
