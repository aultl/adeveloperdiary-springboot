package com.adevelopersdiary;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
  public static HashMap<Long,Student> hmStudent;
  private final AtomicLong counter = new AtomicLong();

	public static void main(String[] args) {
    hmStudent=new HashMap<Long,Student>();

		Student one = new Student("John", "Math");
		hmStudent.put(counter.incrementAndGet(), one);

		Student two = new Student("Jane","History");
		hmStudent.put(counter.incrementAndGet(), two);

		SpringApplication.run(DemoApplication.class, args);
	}
}
