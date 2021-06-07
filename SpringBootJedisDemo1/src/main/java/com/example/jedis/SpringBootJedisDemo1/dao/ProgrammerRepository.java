package com.example.jedis.SpringBootJedisDemo1.dao;

public interface ProgrammerRepository {

	void setProgrammerAsString(String idKey, String programmer);
	String getProgrammerAsString(String idKey);
	
}
