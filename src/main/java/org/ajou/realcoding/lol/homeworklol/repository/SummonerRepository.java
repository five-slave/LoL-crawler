package org.ajou.realcoding.lol.homeworklol.repository;


import org.ajou.realcoding.lol.homeworklol.domain.SummonerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SummonerRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public SummonerDTO insertOrUpdatedSummonerDTO(SummonerDTO summonerDTO) {
        return mongoTemplate.save(summonerDTO);
    }

    public SummonerDTO findSummonerDTOBySummonerName(String summonerName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(summonerName));

        return mongoTemplate.findOne(query, SummonerDTO.class);
    }
}
