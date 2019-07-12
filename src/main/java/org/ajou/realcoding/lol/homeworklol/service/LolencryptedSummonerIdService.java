package org.ajou.realcoding.lol.homeworklol.service;

import org.ajou.realcoding.lol.homeworklol.api.SummonerIdApiClient;
import org.ajou.realcoding.lol.homeworklol.api.SummonerLeaguePosiApiClient;
import org.ajou.realcoding.lol.homeworklol.domain.InformationUser;
import org.ajou.realcoding.lol.homeworklol.domain.LeagueDTO;
import org.ajou.realcoding.lol.homeworklol.domain.SummonerDTO;
import org.ajou.realcoding.lol.homeworklol.repository.SummonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LolencryptedSummonerIdService {
    @Autowired
    private SummonerRepository summonerRepository;
    @Autowired
    private SummonerIdApiClient summonerIdApiClient;
    @Autowired
    private SummonerLeaguePosiApiClient summonerLeaguePosiApiClient;

    public InformationUser insertLegueDTOBySummonerName(String summonerName){

        InformationUser informationUser = new InformationUser();
        SummonerDTO summonerDTO = summonerIdApiClient.requestSummonerDTO(summonerName);

        informationUser.setSummonerName(summonerName);
        String id = summonerDTO.getId();

        List<LeagueDTO> leagues = summonerLeaguePosiApiClient.requestLeagueDTO(id);
        informationUser.setLeagueInfo(leagues);

        return summonerRepository.insertOrUpdatedLeagueDTO(informationUser);
    }
}
