package com.hashtag.cricketGuru.controller;


import com.hashtag.cricketGuru.model.Match;
import com.hashtag.cricketGuru.services.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/match")
public class MatchController {

    private MatchService matchService;

    public MatchController(MatchService matchService){
        this.matchService=matchService;
    }


    @GetMapping("/live")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NORMAL')")
    public ResponseEntity<List<Match>> getAllLiveMatch(){
        return new ResponseEntity<>(this.matchService.getAllLiveMatch(), HttpStatus.OK);
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NORMAL')")
    public ResponseEntity<List<Match>> getAllMatch(){
        return new ResponseEntity<>(this.matchService.getAllMatch(), HttpStatus.OK);
    }

    @GetMapping("/point-table")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NORMAL')")
    public ResponseEntity<?> getCWC2023PointTable() {
        return new ResponseEntity<>(this.matchService.getPointTable(), HttpStatus.OK);
    }
}
