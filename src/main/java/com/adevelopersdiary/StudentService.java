package com.adevelopersdiary;

import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class StudentService {

   @RequestMapping(value="/api/v1/student", method = RequestMethod.GET)
   public HashMap<Long,Student> getAllStudents(){
      return DemoApplication.hmStudent;
   }

   @RequestMapping(value="/api/v1/student/add", method = RequestMethod.POST)
   public Student addStudent(@RequestParam(value="name") String name,
       @RequestParam(value="subject",defaultValue = "unknown") String subject){

     Student student=new Student(name,subject);
     DemoApplication.hmStudent.put(DemoApplication.counter.incrementAndGet(),student);
     return student;
  }
}
