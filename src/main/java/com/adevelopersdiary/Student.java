package com.adevelopersdiary;

import java.util.Date;

public class Student {
  private long id;
  private long date;
  private String name;
  private String subject;

  public Student(long id, String name, String subject) {
    this.id = id;
    this.date = (new Date()).getTime();
    this.name = name;
    this.subject = subject;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  @Override
  public String toString() {
    return "Student{" +
           "id=" + id +
           ", date='" + date + '\'' +
           ", name='" + name + '\'' +
           ", subject='" + subject + '\'' +
           '}';
  }
}
