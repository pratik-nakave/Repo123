package edu.neu.csye6225;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import edu.neu.csye6225.Health;

@SpringBootTest
class Assignment1ApplicationTests {
	
	@Autowired
	Health health;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void validateHealthStatus() {
		assertEquals(HttpStatus.OK, health.getStatus().getStatusCode());
	}

}
