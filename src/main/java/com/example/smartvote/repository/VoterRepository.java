package com.example.smartvote.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.smartvote.model.Voters;

@Repository
public interface VoterRepository extends MongoRepository<Voters, String> {

}
