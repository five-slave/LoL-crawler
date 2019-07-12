package org.ajou.realcoding.lol.homeworklol.repository;


import lombok.extern.slf4j.Slf4j;
import org.ajou.realcoding.lol.homeworklol.domain.InformationUser;
import org.ajou.realcoding.lol.homeworklol.domain.LeagueDTO;
import org.ajou.realcoding.lol.homeworklol.domain.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import sun.management.snmp.util.MibLogger;

import javax.sound.sampled.Line;

@Slf4j
@Repository
public class SummonerRepository {

    @Autowired
    private MongoTemplate mongoTemplate;


    public InformationUser findLeagueDTOBySummonerName(String summonerName){

        Query query = new Query();
        query.addCriteria(Criteria.where("summonerName").is(summonerName));

        InformationUser informationUser = mongoTemplate.findOne(query,InformationUser.class);

        if(informationUser!=null) return informationUser;
        else return null;

    }

    public InformationUser insertOrUpdatedLeagueDTO(InformationUser informationUser){

        String summonerName = informationUser.getSummonerName();

        if(findLeagueDTOBySummonerName(summonerName)==null){
            return mongoTemplate.save(informationUser);
        }

        Query query = new Query();
        query.addCriteria(Criteria.where("summonerName").is(summonerName));

        Update update = new Update();
        update.set("leagueInfo",informationUser.getLeagueInfo());

        log.info("update result : {}",mongoTemplate.updateFirst(query,update, InformationUser.class));

        return informationUser;
    }
}
