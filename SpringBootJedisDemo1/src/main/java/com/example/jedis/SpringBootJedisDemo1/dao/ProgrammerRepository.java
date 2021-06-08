package com.example.jedis.SpringBootJedisDemo1.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.jedis.SpringBootJedisDemo1.model.Programmer;

public interface ProgrammerRepository {

	// String => Key - Value pair
	void setProgrammerAsString(String idKey, String programmer);
	String getProgrammerAsString(String idKey);
	
	// List
	void addToProgrammerList(Programmer programmer);
	List<Programmer> getProgrammerListMembers();
	Long getProgrammersListCount();
	
	// Set
	void AddProgrammerToSet(Programmer ...programmer);
	Set<Programmer> getProgrammersSet();
	boolean isSetMember(Programmer programmer);
	
	// Hash
	void saveHash(Programmer programmer);
	void updateHash(Programmer programmer);
	Map<Integer, Programmer> findAllHash();
	Programmer findInHash(int id);
	void deleteHash(int id);
	
}
