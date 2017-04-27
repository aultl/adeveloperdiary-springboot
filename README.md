# adeveloperdiary-springboot
Code for Springboot tutorial from adevelopersdiary.com

A rest based api service to track students.

## Student Object
A student consists of the following fields:
* name - name of student in the format last,first
* grade - overall GPA of student as a float
* subject - subject the student is enrolled in

There are two other unmodifiable fields:
* id - generated id to track student
* update - last update to student record as a unix epoch

Currently all fields store a single value. There are plans to change this in future revisions.

## Build Requirements

* maven 3.3.9
* oracle jdk 8
* Docker >=1.10

## Building

To build execute the following:

'''
$ /path/to/maven/bin/mvn clean package
$ docker build -t username/demo:0.4.5 .
'''

## Running

'''
$ /path/to/bin/java -j target/demo-0.4.5.jar

 - or -

$ docker run -d -p 8080:8080 username/demo:0.4.5
'''
