package com.springboot.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Student;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMqHeaderController {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@GetMapping("/student/headerExchange/{name}")
	public String publishStudentWithHeaderExchange(@PathVariable("name") String name) throws IOException {
		Student s = new Student("Narayana", 13204001, "Chinna Venkaiah");
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		ObjectOutput out = new ObjectOutputStream(bos);
		
		out.writeObject(s);
		out.flush();
		out.close();
		
		byte[] byteMessage = bos.toByteArray();
		
		Message message = MessageBuilder.withBody(byteMessage)
						.setHeader("item1", "mobile")
						.setHeader("item2", "television").build();
		
		rabbitTemplate.sendAndReceive("Headers-Exchange", "", message);
		
		return "success";
	}
}
