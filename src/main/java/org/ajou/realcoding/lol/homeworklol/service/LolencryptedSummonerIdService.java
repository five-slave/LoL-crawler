package org.ajou.realcoding.lol.homeworklol.service;

import org.ajou.realcoding.lol.homeworklol.api.SummonerIdApiClient;
import org.ajou.realcoding.lol.homeworklol.domain.SummonerDTO;
import org.ajou.realcoding.lol.homeworklol.repository.SummonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LolencryptedSummonerIdService {
    @Autowired
    private SummonerRepository summonerRepository;
    @Autowired
    private SummonerIdApiClient summonerIdApiClient;


    public SummonerDTO insertSummonerDTOBySummonerBySummonerName(String name){

        SummonerDTO summonerDTO = summonerIdApiClient.requestSummonerDTO(name);

        return summonerRepository.insertOrUpdatedSummonerDTO(summonerDTO);
    }
}
