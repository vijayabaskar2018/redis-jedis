package com.example.jedis.SpringBootJedisDemo1.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.jedis.SpringBootJedisDemo1.model.Programmer;


@Repository
public class ProgramerRepositoryImpl implements ProgrammerRepository {
	
	public static final String REDIS_LIST_KEY = "ProgrammerList";
	public static final String REDIS_SET_KEY = "ProgrammerSet";
	public static final String REDIS_HASH_KEY = "ProgrammerHash";

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	
	@Override
	public void setProgrammerAsString(String idKey, String programmer) {
		 redisTemplate.opsForValue().set(idKey, programmer);
		 redisTemplate.expire(idKey, 10, TimeUnit.SECONDS);
		
	}

	@Override
	public String getProgrammerAsString(String idKey) {
		return (String) redisTemplate.opsForValue().get(idKey);
	}

	@Override
	public void addToProgrammerList(Programmer programmer) {
		redisTemplate.opsForList().leftPush(REDIS_LIST_KEY, programmer);
		
	}

	@Override
	public List<Programmer> getProgrammerListMembers() {
		return (List<Programmer>) (List<?>) redisTemplate.opsForList().range(REDIS_LIST_KEY, 0, -1);
	}

	@Override
	public Long getProgrammersListCount() {
		return redisTemplate.opsForList().size(REDIS_LIST_KEY);
	}

	@Override
	public void AddProgrammerToSet(Programmer... programmer) {
		redisTemplate.opsForSet().add(REDIS_SET_KEY, programmer);
	}

	@Override
	public Set<Programmer> getProgrammersSet() {
		return (Set<Programmer>) (Set<?>) redisTemplate.opsForSet().members(REDIS_SET_KEY);
	}

	@Override
	public boolean isSetMember(Programmer programmer) {
		return redisTemplate.opsForSet().isMember(REDIS_SET_KEY, programmer);
	}

	@Override
	public void saveHash(Programmer programmer) {
		redisTemplate.opsForHash().put(REDIS_HASH_KEY, programmer.getId(), programmer);
		
	}

	@Override
	public void updateHash(Programmer programmer) {
		redisTemplate.opsForHash().put(REDIS_HASH_KEY, programmer.getId(), programmer);		
	}

	@Override
	public Map<Integer, Programmer> findAllHash() {
		return (Map<Integer, Programmer>) (Map<?, ?>) redisTemplate.opsForHash().entries(REDIS_HASH_KEY);
	}

	@Override
	public Programmer findInHash(int id) {
		return (Programmer) redisTemplate.opsForHash().get(REDIS_HASH_KEY, id);
	}

	@Override
	public void deleteHash(int id) {
		redisTemplate.opsForHash().delete(REDIS_HASH_KEY, id);
	}
	
	
	
}
