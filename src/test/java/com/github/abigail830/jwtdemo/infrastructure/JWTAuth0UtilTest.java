package com.github.abigail830.jwtdemo.infrastructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class JWTAuth0UtilTest {

    @Test
    public void sign() {
        final JWTAuth0Util jwtAuth0Util = new JWTAuth0Util();
        final String result = jwtAuth0Util.sign();
        System.out.println(result);

        final String verify = jwtAuth0Util.verify(result);
        assertEquals("jwt-demo", verify);
    }
}