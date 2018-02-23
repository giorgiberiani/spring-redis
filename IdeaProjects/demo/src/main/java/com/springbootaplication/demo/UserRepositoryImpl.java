package com.springbootaplication.demo;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class UserRepositoryImpl implements UserRepository {



    private RedisTemplate<String,User> redisTemplate;
    private HashOperations hashOperations;
    Map< String,User> users = new HashMap<>();

    public UserRepositoryImpl(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }


    @Override
    public User findUser(User user) {

        return (User) hashOperations.get("User",user.getName());


    }

    @Override
    public void save(User user) {
        hashOperations.put("User", user.getName(),user);
    }
}
