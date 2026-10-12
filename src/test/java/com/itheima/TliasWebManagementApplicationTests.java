package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@SpringBootTest
class TliasWebManagementApplicationTests {

    //@Autowired
    //private EmpMapper empMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 10);
        claims.put("username", "itheima");

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aXRjYXN0")
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000))
                .compact();

        System.out.println(jwt);
    }

    @Test
    public void testParseJwt() {
        Claims claims = Jwts.parser().setSigningKey("aXRjYXN0")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MTAsInVzZXJuYW1lIjoiaXRoZWltYSIsImV4cCI6MTcwMTkwOTAxNX0.N-MD6DmoeIIY5lB5z73UFLN9u7veppx1K5_N_jS9Yko")
                .getBody();
        System.out.println(claims);
    }

}
