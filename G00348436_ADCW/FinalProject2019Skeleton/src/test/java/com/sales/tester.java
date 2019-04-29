package com.sales;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Template;
import org.springframework.boot.context.embedded.LocalServerPort;

import static org.junit.Assert.assertThat;

import com.sales.controllers.MainController;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class tester {
	
	@Autowired
    private MainController controller;
	
	@LocalServerPort
    private int port;

    @Autowired
    private Template restTemplate;

	@Test
	public void contextLoads() throws Exception {
		//assertThat(controller).isNotNull();
	}

	@Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
//        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
//                String.class)).contains("Hello World");
    }

}
