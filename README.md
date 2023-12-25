# Academic Courses Management System
## Description

A collaborated project that was presented as our final task in advanced Java course. It is supposed to summarize what we studied in our courses - classes, abstracted classess, inheritance, GUI, read and write files, dealing with user inputs (including exceptions handling) and many more..

The project we created is a course management system that allows the user to do the following things using the IDE's terminal with a minimalistic GUI:
* Add student - first name, last name, ID, age, email.
* Add teacher - first name, last name, ID, age, email.
* Add course - course name, course code, course's academic point.

After creating each of the above, we can assign a teacher to the course and add students to study in that course.
The academic points will add up into the specific student's profile until it reached the maximum academic point available for students (pre-defined by us) and wont allow to assign more courses to the specific student.

We also added read, save and remove functions:
* Read text file - automatically add one (or more) of the above instead of entering it manually.
* Save to text file(s).
* Remove student / teacher / course.
* Sort each of those lists by each parameter they have.

The system also include an option to view a specific student / teacher / course information that will describe all of the written above (including the teachers and student's courses, and student's academic points).

The system is smart and recognizes when a teacher is removed, it will automatically remove it from the courses it supposed to teach - same for removing students.
For course removal - it will be removed from the teacher's courses running list and also from the student's courses hes registered to.
## Getting Started

### Executing program
There are several ways to run this system:

* Clone git project into your IDE.
* Manually download included files and open it as a new project in your IDE.

## Help

Project is finished and no longer supported.

Feel free to use it as a base for your project, but make sure to give us credits :)

## Authors

Contributors:

[@Aviv Eliyahu](https://github.com/aviveliyahu)
[@Ariel Goldwaser](https://github.com/ArielGold1)
[@Matan Asraf](https://github.com/matanasaraf)

