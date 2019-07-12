package org.ajou.realcoding.lol.homeworklol.controller;


import org.ajou.realcoding.lol.homeworklol.api.SummonerIdApiClient;
import org.ajou.realcoding.lol.homeworklol.api.SummonerLeaguePosiApiClient;
import org.ajou.realcoding.lol.homeworklol.domain.InformationUser;
import org.ajou.realcoding.lol.homeworklol.domain.LeagueDTO;
import org.ajou.realcoding.lol.homeworklol.domain.SummonerDTO;
import org.ajou.realcoding.lol.homeworklol.repository.SummonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.ajou.realcoding.lol.homeworklol.service.LolencryptedSummonerIdService;

import java.io.IOException;
import java.util.List;

@RestController
public class SummonerNameController {

    @Autowired
    private LolencryptedSummonerIdService lolencryptedSummonerIdService;
    @Autowired
    private SummonerIdApiClient summonerIdApiClient;
    @Autowired
    private SummonerRepository summonerRepository;

    @Autowired
    private SummonerLeaguePosiApiClient summonerLeaguePosiApiClient;



    @GetMapping("/lol/summoner/v4/summoners/by-name/{summonerName}")
    public InformationUser getSummonerId(@PathVariable String summonerName) throws IOException, InterruptedException {


        return lolencryptedSummonerIdService.insertLegueDTOBySummonerName(summonerName);

        //소환사 이름을 통해서 league전적 정보를 얻는 함수
    }



}