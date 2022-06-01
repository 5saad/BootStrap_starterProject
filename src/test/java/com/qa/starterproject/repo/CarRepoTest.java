package com.qa.starterproject.repo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest
@ActiveProfiles("dev")
@Sql(scripts = {"classpath:init.sql", "classpath:schema.sql"},executionPhase = ExecutionPhase.BEFORE_TEST_METHOD )
public class CarRepoTest {
	
	@Test
	public void method() {
		
	}

}
