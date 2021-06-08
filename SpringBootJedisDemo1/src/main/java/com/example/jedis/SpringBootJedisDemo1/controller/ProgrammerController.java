package com.example.jedis.SpringBootJedisDemo1.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		programmerService.setProgrammerAsString(String.valueOf(programmer.getId()),
				objectMapper.writeValueAsString(programmer));
	}

	@GetMapping("/programmer-string/{id}")
	public String getProgrammer(@PathVariable("id") String idKey) {
		return programmerService.getProgrammerAsString(idKey);
	}

	@PostMapping("/programmer-list")
	public void addProgrammerToList(@RequestBody Programmer programmer) {
		programmerService.addToProgrammerList(programmer);
	}

	@GetMapping("/programmer-list")
	public List<Programmer> getProgrammerFromList() {
		return programmerService.getProgrammerListMembers();
	}

	@GetMapping("/programmer-list/count")
	public Long getProgrammerFromListCount() {
		return programmerService.getProgrammersListCount();
	}

	@PostMapping("/programmer-set")
	public void addProgrammersToSet(@RequestBody Programmer... programmer) {
		programmerService.AddProgrammerToSet(programmer);
	}

	@GetMapping("/programmer-set")
	public void getProgrammersFromSet() {
		programmerService.getProgrammersSet();
	}

	@PostMapping("/programmer-set")
	public boolean checkProgrammerInSet(@RequestBody Programmer programmer) {
		return programmerService.isSetMember(programmer);
	}

	@PostMapping("/programmer-hash")
	public void addProgrammerToHash(@RequestBody Programmer programmer) {
		programmerService.saveHash(programmer);
	}

	@PutMapping("/programmer-hash")
	public void updateProgrammerToHash(@RequestBody Programmer programmer) {
		programmerService.updateHash(programmer);
	}

	@GetMapping("/programmer-hash")
	public Map<Integer, Programmer> getAllProgrammerFromHash() {
		return programmerService.findAllHash();
	}

	@GetMapping("/programmer-list/{id}")
	public Programmer getProgrammerFromHash(@PathVariable("id") int id) {
		return programmerService.findInHash(id);
	}

	@DeleteMapping("/programmer-list/{id}")
	public void deleteProgrammerFromHash(@PathVariable("id") int id) {
		programmerService.deleteHash(id);
	}

}
