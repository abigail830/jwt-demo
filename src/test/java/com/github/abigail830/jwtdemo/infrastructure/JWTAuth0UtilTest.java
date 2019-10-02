package com.github.abigail830.jwtdemo.infrastructure;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.abigail830.jwtdemo.domain.ApplicationUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class JWTAuth0UtilTest {

    @Test
    public void sign_and_verify() {
        final JWTAuth0Util jwtAuth0Util = new JWTAuth0Util();
        ApplicationUser user = new ApplicationUser("sara", "password");
        final String result = jwtAuth0Util.sign(user.getUsername());
        System.out.println(result);

        final DecodedJWT decodedJWT = jwtAuth0Util.verify(result);
        assertEquals("jwt-demo", decodedJWT.getIssuer());
        assertEquals("sara", decodedJWT.getSubject());
    }

    @Test
    public void sign_and_decode() {
        final JWTAuth0Util jwtAuth0Util = new JWTAuth0Util();
        ApplicationUser user = new ApplicationUser("sara", "password");
        final String result = jwtAuth0Util.sign(user.getUsername());
        System.out.println(result);

        final DecodedJWT decodedJWT = jwtAuth0Util.decode(result);
        assertEquals("jwt-demo", decodedJWT.getIssuer());
        assertEquals("sara", decodedJWT.getSubject());
    }
}