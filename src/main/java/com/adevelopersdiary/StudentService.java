package com.adevelopersdiary;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentService {

  @RequestMapping(value="/api/v1/student", method=RequestMethod.GET)
  public HashMap<Long,Student> getAllStudents(){
    return DemoApplication.hmStudent;
  }

  @RequestMapping(value="/api/v1/student", method=RequestMethod.POST)
  public Student addStudent(@RequestParam(value="name") String name,
       @RequestParam(value="subject", defaultValue="unknown") String subject){

    Student student=new Student(name,subject);
    DemoApplication.hmStudent.put(student.getId(),student);
    return student;
  }

  @RequestMapping(value="/api/v1/student", method=RequestMethod.PUT)
  public Student updateStudent(@RequestParam(value="id") String id,
      @RequestParam(value="name", defaultValue="unknown") String name,
      @RequestParam(value="subject", defaultValue="unknown") String subject,
      @RequestParam(value="grade", defaultValue="unknown") String grade){

      Student student = DemoApplication.hmStudent.get(Long.parseLong(id));

      if (student == null) throw new StudentNotFoundException();

      if (!"unknown".equals(subject)) {
        student.setSubject(subject);
        DemoApplication.hmStudent.put(Long.parseLong(id),student);
      }

      if (!"unknown".equals(name)) {
        student.setName(name);
        DemoApplication.hmStudent.put(Long.parseLong(id),student);
      }

      if (!"unknown".equals(grade)) {
        student.setGrade(Long.parseLong(grade));
        DemoApplication.hmStudent.put(Long.parseLong(id),student);
      }

      return student;
  }

  @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Student does not exist!")  // 400
  class StudentNotFoundException extends RuntimeException {
    // do nothing;
  }
}
