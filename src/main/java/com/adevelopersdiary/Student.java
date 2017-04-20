package com.adevelopersdiary;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Student {
  private long id;
  private long update;
  private float grade;
  private String fname;
  private String lname;
  private String subject;
  public static final AtomicLong counter = new AtomicLong();

  public Student(String name, String subject) {
    this.id = counter.incrementAndGet();
    this.update = (new Date()).getTime();
    this.subject = subject;
    setName(name);
  }

  public long getId() {
    return id;
  }

  public long getUpdate() {
    return update;
  }

  public String getName() {
    return lname + "," + fname;
  }

  public void setName(String name) {
    String[] parts = name.split(",");
    this.lname = parts[1];
    this.fname = parts[0];
    this.update = (new Date()).getTime();
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
    this.update = (new Date()).getTime();
  }

  public float getGrade() {
    return grade;
  }

  public void setGrade(float grade) {
    this.grade = grade;
    this.update = (new Date()).getTime();
  }
}
