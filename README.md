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
