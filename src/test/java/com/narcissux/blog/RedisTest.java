package com.narcissux.blog;

import com.narcissux.blog.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    RedisTemplate<Object,Object> redis;

    @Test
    public void set() {
        redis.opsForValue().set("xia","流行");
    }

    @Test
    public void setObjecy() {
        redis.opsForValue().set("user",new User().setAvatar("xiaye").setName("narcissux"));
        System.out.println(redis.opsForValue().get("user"));
    }

    @Test
    public void get(){
        System.out.println(redis.opsForValue().get("xia"));
    }


}
