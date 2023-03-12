package com.example.smartvote.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartvote.model.Voters;
import com.example.smartvote.service.VoterService;

@RestController
@RequestMapping("/voter")
public class VotersController {
	
	@Autowired
	VoterService voterService;

	public VotersController(VoterService voterService) {
		this.voterService = voterService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Voters> createUser(@RequestBody Voters voter)
	{
		return new ResponseEntity<Voters>(voterService.createVoter(voter),HttpStatus.CREATED );
	}
	
	@GetMapping("/voters")
	public List<Voters> getAllUsers()
	{
		return voterService.getAllVoters();
	}
	@GetMapping("/voter/{id}")
	public ResponseEntity<Voters> getUserByid(@PathVariable("id") String userId)
	{
		return new ResponseEntity<Voters>(voterService.getVoterById(userId), HttpStatus.OK);
	}
	@PutMapping("/voter/update/{id}")
	 public ResponseEntity<Voters> updateUser( @PathVariable String id,@RequestBody Voters user)
	 {
		 return new ResponseEntity<Voters>(voterService.updateById(id.toString(), user),HttpStatus.OK);
		 
	 }
	@DeleteMapping("/voter/delete/{id}")
	public ResponseEntity<Voters> deleteById(@PathVariable String id)
	{
		return new ResponseEntity<Voters>(voterService.deleteById(id),HttpStatus.OK);
		
	}

}
