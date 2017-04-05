package com.adevelopersdiary;

import java.util.HashMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
  public static HashMap<Long, Student> hmStudent;

	public static void main(String[] args) {
    hmStudent = new HashMap<Long, Student>();

		Student one = new Student("John", "Math");
		hmStudent.put(new Long(one.getId()), one);

		Student two = new Student("Jane","History");
		hmStudent.put(new Long(two.getId()), two);
	}
}
