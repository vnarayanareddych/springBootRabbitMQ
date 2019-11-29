package com.springboot.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Student;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMqController {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@GetMapping("/student/{name}")
	public String publishStudent(@PathVariable("name") String name) {
		Student s = new Student("Narayana", 13204001, "Chinna Venkaiah");
		//rabbitTemplate.convertAndSend("Mobile", s);
		//rabbitTemplate.convertAndSend("Direct-Exchange", "ac", s);
		//rabbitTemplate.convertAndSend("Fanout-Exchange", "", s);
		rabbitTemplate.convertAndSend("Topic-Exchange", "tv.mobile.ac", s);
		return "Success";
	}
}
