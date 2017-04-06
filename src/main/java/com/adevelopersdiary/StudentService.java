package com.adevelopersdiary;

import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/rest/student")
class StudentService {

   @RequestMapping(value="/rest/student",method = RequestMethod.GET)
   public HashMap<Long,Student> getAllStudents(){
      return DemoApplication.hmStudent;
   }
}
