package com.adevelopersdiary;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Student {
  private long id;
  private long update;
  private long grade;
  private String name;
  private String subject;
  public static final AtomicLong counter = new AtomicLong();

  public Student(String name, String subject) {
    this.id = counter.incrementAndGet();
    this.update = (new Date()).getTime();
    this.name = name;
    this.subject = subject;
  }

  public long getId() {
    return id;
  }

  public long getUpdate() {
    return update;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    this.update = (new Date()).getTime();
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
    this.update = (new Date()).getTime();
  }

  public long getGrade() {
    return grade;
  }

  public void setGrade(long grade) {
    this.grade = grade;
    this.update = (new Date()).getTime();
  }
}
