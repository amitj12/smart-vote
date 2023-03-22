package com.example.smartvote.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import org.apache.catalina.*;



import com.example.smartvote.model.Voters;
import com.example.smartvote.repository.VoterRepository;


@Service
public class VoterServiceimpl implements VoterService {

	VoterRepository repository;
	public VoterServiceimpl(VoterRepository repository) {
		this.repository = repository;
	}

	@Override
	public Voters createVoter(Voters voters) {
		Voters voter=repository.findById(voters.getId()).orElse(null);
		if(voter!=null)
		{
			return null;
		}
		return repository.insert(voters);
		
	}

	@Override
	public List<Voters> getAllVoters() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Voters getVoterById(String id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public Voters updateById(String id, Voters voter) {
		Voters existingvoter=repository.findById(id).orElse(null);
		if(existingvoter==null)
			return null;
		existingvoter.setFirstName(voter.getFirstName());
		existingvoter.setLastName(voter.getLastName());
		existingvoter.setEmail(voter.getEmail());
		existingvoter.setPhoneNumber(voter.getPhoneNumber());
		repository.save(existingvoter);
		return existingvoter;
	}

	@Override
	public Voters deleteById(String id) {
		Voters deletedVoter=repository.findById(id).orElse(null);
		
		if(deletedVoter==null)
			return null;
		repository.deleteById(id);
		return deletedVoter;
		
	}
	

}
