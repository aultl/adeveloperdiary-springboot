package com.adevelopersdiary;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
  public static HashMap<Long,Student> hmStudent;
  public static final AtomicLong counter = new AtomicLong();

	public static void main(String[] args) {
    hmStudent=new HashMap<Long,Student>();

		Student one = new Student(counter.incrementAndGet(), "John", "Math");
		hmStudent.put(one.getId(), one);

		Student two = new Student(counter.incrementAndGet(), "Jane","History");
		hmStudent.put(two.getId(), two);

		SpringApplication.run(DemoApplication.class, args);
	}
}
