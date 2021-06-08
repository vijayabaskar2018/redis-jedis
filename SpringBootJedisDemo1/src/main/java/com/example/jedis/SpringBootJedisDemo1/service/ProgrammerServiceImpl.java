package com.example.jedis.SpringBootJedisDemo1.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jedis.SpringBootJedisDemo1.dao.ProgrammerRepository;
import com.example.jedis.SpringBootJedisDemo1.model.Programmer;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {

	@Autowired
	private ProgrammerRepository programmerRepository;
	
	@Override
	public void setProgrammerAsString(String idKey, String programmer) {
		 programmerRepository.setProgrammerAsString(idKey, programmer);
		
	}

	@Override
	public String getProgrammerAsString(String idKey) {
		return programmerRepository.getProgrammerAsString(idKey);
	}

	@Override
	public void addToProgrammerList(Programmer programmer) {
		programmerRepository.addToProgrammerList(programmer);
		
	}

	@Override
	public List<Programmer> getProgrammerListMembers() {
		return programmerRepository.getProgrammerListMembers();
	}

	@Override
	public Long getProgrammersListCount() {
		return programmerRepository.getProgrammersListCount();
	}
	
	@Override
	public void AddProgrammerToSet(Programmer... programmer) {
		programmerRepository.AddProgrammerToSet(programmer);
	}

	@Override
	public Set<Programmer> getProgrammersSet() {
		return programmerRepository.getProgrammersSet();
	}

	@Override
	public boolean isSetMember(Programmer programmer) {
		return programmerRepository.isSetMember(programmer);
	}

	@Override
	public void saveHash(Programmer programmer) {
		programmerRepository.saveHash(programmer);
	}

	@Override
	public void updateHash(Programmer programmer) {
		programmerRepository.updateHash(programmer);
	}

	@Override
	public Map<Integer, Programmer> findAllHash() {
		return programmerRepository.findAllHash();
	}

	@Override
	public Programmer findInHash(int id) {
		return programmerRepository.findInHash(id);
	}

	@Override
	public void deleteHash(int id) {
		programmerRepository.deleteHash(id);
	}

	
	
	
}
