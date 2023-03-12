package com.example.smartvote.service;

import java.util.List;

import com.example.smartvote.model.Voters;

public interface VoterService {
	public Voters createVoter(Voters voter);//post
	public List<Voters> getAllVoters();//get all
	public Voters getVoterById(String id);
	public Voters updateById(String id,Voters voter);
	public Voters deleteById(String id);

}
