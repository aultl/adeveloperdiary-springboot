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
  public Student updateStudent(@RequestParam(value="id") long id,
      @RequestParam(value="name", defaultValue="unknown") String name,
      @RequestParam(value="subject", defaultValue="unknown") String subject,
      @RequestParam(value="grade", defaultValue="0.0") float grade){

      Student student = DemoApplication.hmStudent.get(id);

      if (student == null) throw new StudentNotFoundException();

      if (!"unknown".equals(subject)) {
        student.setSubject(subject);
        DemoApplication.hmStudent.put(id,student);
      }

      if (!"unknown".equals(name)) {
        student.setName(name);
        DemoApplication.hmStudent.put(id,student);
      }

      if ( grade != 0.0 ) {
        if ( grade < 0.1 || grade > 4.0) throw new GradeOutsideRange();

        student.setGrade(grade);
        DemoApplication.hmStudent.put(id,student);
      }

      return student;
  }

  @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Student does not exist!")  // 400
  class StudentNotFoundException extends RuntimeException {
    // do nothing;
  }

  @ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Grade must be between 0.1 and 5.0")  // 400
  class GradeOutsideRange extends RuntimeException {
    // do nothing;
  }
}
