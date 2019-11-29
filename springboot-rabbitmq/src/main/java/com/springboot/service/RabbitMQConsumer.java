package com.springboot.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.springboot.model.Student;

@Service
public class RabbitMQConsumer {

	
	@RabbitListener(queues = "Mobile")
	public void getMessage(Student s) {
		System.out.println("Student Details: "+ s.toString());
	}
	
	@RabbitListener(queues = "TV")
	public void HeaderMessage(byte[] message) throws IOException, ClassNotFoundException {
		
		ByteArrayInputStream bis = new ByteArrayInputStream(message);
		ObjectInput in = new ObjectInputStream(bis);
		Student s = (Student) in.readObject();
		in.close();
		bis.close();
		System.out.println("Object "+s.toString());
	}
}
