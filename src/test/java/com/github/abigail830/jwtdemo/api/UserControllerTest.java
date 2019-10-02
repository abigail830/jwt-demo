package com.github.abigail830.jwtdemo.api;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Ignore
public class UserControllerTest {

    TestRestTemplate testRestTemplate;

    @Test
    public void test_hello_should_goto_login_page_when_not_login() {
        testRestTemplate = new TestRestTemplate();
        final ResponseEntity<String> result = testRestTemplate
                .exchange("http://localhost:8080/hello", HttpMethod.GET, null, String.class);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertFalse(result.getBody().contains("Hello World"));
        assertTrue(result.getBody().contains("Please sign in"));
    }

    @Test
    public void test_hello_should_get_hello_world_when_login() {
        testRestTemplate = new TestRestTemplate("admin", "admin");
        final ResponseEntity<String> result = testRestTemplate
                .exchange("http://localhost:8080/hello", HttpMethod.GET, null, String.class);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(result.getBody().contains("Hello World"));
        assertFalse(result.getBody().contains("Please sign in"));
    }
}