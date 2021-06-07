package com.example.jedis.SpringBootJedisDemo1.service;

public interface ProgrammerService {
	
	void setProgrammerAsString(String idKey, String programmer);
	String getProgrammerAsString(String idKey);
	
}
