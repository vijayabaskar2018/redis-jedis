package com.example.jedis.SpringBootJedisDemo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jedis.SpringBootJedisDemo1.model.Programmer;
import com.example.jedis.SpringBootJedisDemo1.service.ProgrammerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ProgrammerController {

	@Autowired
	private ProgrammerService programmerService;
	
	@PostMapping("/programmer-string")
	public void addProgrammer(@RequestBody Programmer programmer) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		programmerService.setProgrammerAsString(String.valueOf(programmer.getId()), objectMapper.writeValueAsString(programmer));
	}
	
	@GetMapping("/programmer-string/{id}")
	public String getProgrammer( @PathVariable("id") String idKey) {
		return programmerService.getProgrammerAsString(idKey);
	}
	
	
}
