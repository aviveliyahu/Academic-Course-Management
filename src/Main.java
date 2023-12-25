import java.rmi.StubNotFoundException;
import java.util.Collections;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Code written by -
 * Aviv Eliyahu
 * Ariel Goldwaser
 * Matan Asraf
 *
 * Zefat college, advanced Java course.
 */
public class Main {
    public static void readStudentsFile(String file) throws FileNotFoundException, IOException {
        // Read students files
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            String[] arr;
            while (line != null) {
                arr = line.split(",");
                String firstName = arr[0];
                String lastName = arr[1];
                int id = Integer.parseInt(arr[2]);
                int age = Integer.parseInt(arr[3]);
                String email = arr[4];
                new Student(firstName, lastName, id, age, email);
                line = br.readLine();
            }
            br.close();
            System.out.println("File was added successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File name not found in main project folder.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readTeachersFile(String file) throws FileNotFoundException, IOException {
        // Read teacher files
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            String[] arr;
            while (line != null) {
                arr = line.split(",");
                String firstName = arr[0];
                String lastName = arr[1];
                int id = Integer.parseInt(arr[2]);
                int age = Integer.parseInt(arr[3]);
                String email = arr[4];
                String title = arr[5];
                new Teacher(firstName, lastName, id, age, email, title);
                line = br.readLine();
            }
            br.close();
            System.out.println("File was added successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File name not found in main project folder.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readCoursesFile(String file) throws FileNotFoundException, IOException {
        // Read course files
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            String[] arr;
            while (line != null) {
                arr = line.split(",");
                int teacherId = Integer.parseInt(arr[0]);
                Teacher temp_t = (Teacher) Teacher.searchById(teacherId);
                if (temp_t == null) {
                    System.out.println("No teacher related to that ID.");
                    break;
                }
                String courseName = arr[1];
                int code = Integer.parseInt(arr[2]);
                int points = Integer.parseInt(arr[3]);
                new Course(temp_t, courseName, code, points);
                line = br.readLine();
            }
            br.close();
            System.out.println("File was added successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File name not found in main project folder.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writeStudentsToFile() throws FileNotFoundException, IOException {
        try {
            String file_name = "students.txt";
            FileWriter fw = new FileWriter(file_name);
            BufferedWriter bw = new BufferedWriter(fw);

            FileReader fr = new FileReader(file_name);
            BufferedReader br = new BufferedReader(fr);
            String br_line = br.readLine();
            if (br_line != null) {
                bw.newLine();
            }
            for (int i = 0; i < Student.getStudents().size(); i++) {
                String firstName = Student.getStudents().get(i).getFirstName();
                String lastName = Student.getStudents().get(i).getLastName();
                int id = Student.getStudents().get(i).getId();
                int age = Student.getStudents().get(i).getAge();
                String email = Student.getStudents().get(i).getEmail();

                String line = firstName + "," + lastName + "," + id + "," + age + "," + email;
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file named students.txt found im main project's folder.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeTeachersToFile() throws FileNotFoundException, IOException {
        try {
            String file_name = "teachers.txt";
            FileWriter fw = new FileWriter(file_name);
            BufferedWriter bw = new BufferedWriter(fw);

            FileReader fr = new FileReader(file_name);
            BufferedReader br = new BufferedReader(fr);
            String br_line = br.readLine();
            if (br_line != null) {
                bw.newLine();
            }
            for (int i = 0; i < Teacher.getTeachers().size(); i++) {
                String firstName = Teacher.getTeachers().get(i).getFirstName();
                String lastName = Teacher.getTeachers().get(i).getLastName();
                int id = Teacher.getTeachers().get(i).getId();
                int age = Teacher.getTeachers().get(i).getAge();
                String email = Teacher.getTeachers().get(i).getEmail();
                String title = Teacher.getTeachers().get(i).getTitle();

                String line = firstName + "," + lastName + "," + id + "," + age + "," + email + "," + title;
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file named teachers.txt found im main project's folder.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCoursesToFile() throws FileNotFoundException, IOException {
        try {
            String file_name = "courses.txt";
            FileWriter fw = new FileWriter(file_name);
            BufferedWriter bw = new BufferedWriter(fw);

            FileReader fr = new FileReader(file_name);
            BufferedReader br = new BufferedReader(fr);
            String br_line = br.readLine();
            if (br_line != null) {
                bw.newLine();
            }
            for (int i = 0; i < Course.getCoursesList().size(); i++) {
                int teacherID = Course.getCoursesList().get(i).getTeacher().getId();
                String courseName = Course.getCoursesList().get(i).getCourseName();
                int code = Course.getCoursesList().get(i).getCode();
                int points = Course.getCoursesList().get(i).getPoints();

                String line = teacherID + "," + courseName + "," + code + "," + points;
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file named courses.txt found im main project's folder.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException {
        boolean stay = true;
        readTeachersFile("teachers.txt");
        readStudentsFile("students.txt");
        readCoursesFile("courses.txt");
        /* REMOVE THE COMMENT TO SHOW THE QUERY
        Queries.isUnder25();
        Queries.zeroPoints();
        Queries.howManyDoc();
        Queries.howManyNamedShireen();
        Queries.removeAllProf();
        Queries.removeAllUnder20();
        Queries.studentsIsEmpty();
        Queries.teachersIsEmpty();
        Queries.coursesIsEmpty();
        Queries.firstFiveStudentsAlphabet();
        Queries.lastFiveTeachersAlphabet();
        */
        while (stay) {
            try {
                System.out.println("Main menu");
                System.out.println("What action do you want to perform?");
                System.out.println("1. Update (add or remove) personal information");
                System.out.println("2. Show data");
                System.out.println("3. Add - Student/Teacher/Course/File");
                System.out.println("4. Remove - Student/Teacher/Course");
                System.out.println("5. Sort - Student/Teacher/Course");
                System.out.println("6. Quit program");
                int action = input.nextInt();

                Person picked = null;
                switch (action) {
                    case 1 -> {
                        System.out.println("Enter person ID: ");
                        int personID = input.nextInt();
                        for (Person p : Person.getRegistered()) {
                            if (p.getId() == personID) {
                                picked = p;
                                Person.setRegistered(Person.getRegistered());
                                System.out.println(picked);
                            }
                        }

                        if (picked == null) {
                            System.out.println("Person not found.");
                            break;
                        }
                        System.out.println("Main menu -> Update");
                        System.out.println("1. Change first name");
                        System.out.println("2. Change last name");
                        System.out.println("3. Add student to course");
                        System.out.println("4. Remove student from course");
                        System.out.println("5. Update course teacher");
                        System.out.println("6. Back to main menu");
                        System.out.println("Enter action number: ");
                        int subAction = input.nextInt();

                        switch (subAction) {
                            case 1 -> {
                                System.out.println("Enter new first name: ");
                                picked.setFirstName(input.next());
                                System.out.println("The first name was changed...");
                                System.out.println(picked);
                            }
                            case 2 -> {
                                System.out.println("Enter new last name: ");
                                picked.setLastName(input.next());
                                System.out.println("The last name was changed...");
                                System.out.println(picked);
                            }
                            case 3 -> {
                                System.out.println("Enter course code: ");
                                int courseCode = input.nextInt();
                                Course.searchByCode(courseCode).addStudent((Student) picked);
                                System.out.println(picked);
                                //System.out.println("The student was added to the course...");
                                System.out.println(Course.searchByCode(courseCode));
                            }
                            case 4 -> {
                                System.out.println("Enter course code: ");
                                int courseCode = input.nextInt();
                                Course.searchByCode(courseCode).removeStudent((Student) picked);
                                System.out.println("The student was removed from the course...");
                                System.out.println(Course.searchByCode(courseCode));
                            }
                            case 5 -> {
                                System.out.println("Enter course code: ");
                                int courseCode = input.nextInt();
                                Course.updateCourseTeacher((Teacher) picked, courseCode);
                                System.out.println("The course teacher has been updated :" + picked);
                            }
                            case 6 -> {
                                System.out.println("Going back to main menu :");
                            }
                            default -> System.out.println("Invalid action.");
                        }
                    }
                    case 2 -> {
                        System.out.println("Main menu -> Show data");
                        System.out.println("1. Show students data : ");
                        System.out.println("2. Show teachers data : ");
                        System.out.println("3. Show courses data : ");
                        System.out.println("4. Show all registered : ");
                        System.out.println("5. Go back to main menu ");
                        int subAction = input.nextInt();
                        switch (subAction) {
                            case 1 -> {
                                System.out.println("This is the students: ");
                                for (Person c : Student.getStudents())
                                    System.out.println(c);
                            }
                            case 2 -> {
                                System.out.println("This is the teachers: ");
                                for (Person c : Teacher.getTeachers())
                                    System.out.println(c);
                            }
                            case 3 -> {
                                System.out.println("This is the courses...");
                                for (Course c : Course.getCoursesList())
                                    System.out.println(c);
                            }
                            case 4 -> {
                                System.out.println("4. This is all of the registered... ");
                                for (Person c : Person.getRegistered())
                                    System.out.println(c);
                            }
                            case 5 -> {
                                System.out.println("5. Going back to main menu.. ");
                            }
                            default -> System.out.println("Invalid action.");
                        }
                    }
                    case 3 -> {
                        System.out.println("Main menu -> Add");
                        System.out.println("1. Add new student : ");
                        System.out.println("2. Add new teacher : ");
                        System.out.println("3. Add new course : ");
                        System.out.println("4. Add new file : ");
                        System.out.println("5. Go back a menu ");
                        int subAction = input.nextInt();
                        switch (subAction) {
                            case 1 -> {
                                input.nextLine();
                                System.out.println("Enter student's first name: ");
                                String userFirstName = input.nextLine();

                                System.out.println("Enter student's last name: ");
                                String userLastName = input.nextLine();

                                System.out.println("Enter student's ID: ");
                                int userId = input.nextInt();

                                System.out.println("Enter student's age: ");
                                int userAge = input.nextInt();

                                input.nextLine();

                                System.out.println("Enter student's email: ");
                                String userMail = input.nextLine();


                                Student newStudent = new Student(userFirstName, userLastName, userId, userAge, userMail);
                                System.out.println("New student added successfully : " + newStudent);
                            }
                            case 2 -> {
                                input.nextLine();
                                System.out.println("Enter teacher's first name: ");
                                String userFirstName = input.nextLine();

                                System.out.println("Enter teacher's last name: ");
                                String userLastName = input.nextLine();

                                System.out.println("Enter teacher's title: ");
                                String userTitle = input.nextLine();

                                System.out.println("Enter teacher's ID: ");
                                int userId = input.nextInt();

                                System.out.println("Enter teacher's age: ");
                                int userAge = input.nextInt();

                                input.nextLine(); //

                                System.out.println("Enter teacher's email: ");
                                String userMail = input.nextLine();

                                Teacher newTeacher = new Teacher(userFirstName, userLastName, userId, userAge, userMail, userTitle);
                                System.out.println("New teacher added successfully : " + newTeacher);
                            }
                            case 3 -> {
                                input.nextLine();
                                System.out.println("Enter course teacher id: ");
                                int courseTeacherId = input.nextInt();
                                Person courseTeacher = Person.searchById(courseTeacherId);

                                input.nextLine();

                                System.out.println("Enter course name: ");
                                String courseName = input.nextLine();

                                System.out.println("Enter course code: ");
                                int courseId = (Course.getCoursesList().size() + 1);

                                System.out.println("Enter course's points: ");
                                int coursePoints = input.nextInt();

                                input.nextLine();


                                Course newCourse = new Course((Teacher) courseTeacher, courseName, courseId, coursePoints);
                                System.out.println("New course added successfully : " + newCourse);
                            }
                            case 4 -> {
                                System.out.println("Main menu -> Add -> File");
                                System.out.println("1. Add new student file ");
                                System.out.println("2. Add new teacher file ");
                                System.out.println("3. Add new course file ");
                                System.out.println("4. Go back a menu ");
                                int subActionLoad = input.nextInt();
                                switch (subActionLoad) {
                                    case 1 -> {
                                        System.out.println("New student file added successfully : ");
                                        input.nextLine();
                                        System.out.println("Enter students file name \n(include .txt in the end): ");
                                        String userFile = input.nextLine();
                                        readStudentsFile(userFile);
                                    }

                                    case 2 -> {
                                        System.out.println("Enter teachers file name \n(include .txt in the end): ");
                                        String userFile = input.nextLine();
                                        readTeachersFile(userFile);
                                        System.out.println("New teacher file added successfully : ");
                                    }
                                    case 3 -> {
                                        System.out.println("Enter courses file name \n(include .txt in the end): ");
                                        String userFile = input.nextLine();
                                        readCoursesFile(userFile);
                                        System.out.println("New course file added successfully : ");
                                    }
                                    default -> System.out.println("Invalid action.");
                                }
                            }
                            default -> System.out.println("Invalid action.");
                        }
                    }
                    case 4 -> {
                        System.out.println("Main menu -> Remove");
                        System.out.println("1. Remove student : ");
                        System.out.println("2. Remove teacher : ");
                        System.out.println("3. Remove course : ");
                        System.out.println("4. Go back to main menu ");
                        int subAction = input.nextInt();

                        switch (subAction) {
                            case 1 -> {
                                input.nextLine();
                                System.out.println("Please enter student's id : ");
                                int studentId = input.nextInt();
                                Student pickedStudent = (Student) Person.searchById(studentId);
                                Person.getRegistered().remove(pickedStudent);
                                Student.getStudents().remove(pickedStudent);
                                System.out.println("The student was removed successfully : ");
                            }
                            case 2 -> {
                                input.nextLine();
                                System.out.println("Please enter teacher's id : ");
                                int teacherId = input.nextInt();
                                Teacher pickedTeacher = (Teacher) Person.searchById(teacherId);
                                Person.getRegistered().remove(pickedTeacher);
                                Teacher.getTeachers().remove(pickedTeacher);
                                System.out.println("The teacher was removed successfully... ");
                            }
                            case 3 -> {
                                input.nextLine();
                                System.out.println("Enter course id: ");
                                int courseId = input.nextInt();
                                Course.removeCourse(Course.searchByCode(courseId));
                                System.out.println("The course was removed successfully : " + Course.searchByCode(courseId));
                            }
                        }
                    }
                    case 5 -> {
                        System.out.println("Main menu -> Sort");
                        System.out.println("1. Sort student : ");
                        System.out.println("2. Sort teacher : ");
                        System.out.println("3. Sort course : ");
                        System.out.println("4. Go back to main menu ");
                        int subAction = input.nextInt();

                        switch (subAction) {
                            case 1 -> {
                                System.out.println("Main menu -> Sort -> Students");
                                System.out.println("1. Sort first name : ");
                                System.out.println("2. Sort points : ");
                                System.out.println("3. Sort id : ");
                                System.out.println("4. Go back to main menu ");
                                int subActionSort = input.nextInt();

                                switch (subActionSort) {
                                    case 1 -> {
                                        System.out.println("code to sort by first name");
                                        Vector<Student> tempStudent = new Vector<>();
                                        tempStudent = Student.getStudents();
                                        Collections.sort(tempStudent);
                                        Student.setStudents(tempStudent);
                                        for (int i = 0; i < Student.getStudents().size(); i++) {
                                            System.out.println(Student.getStudents().get(i));
                                        }
                                    }
                                    case 2 -> {
                                        System.out.println("code to sort by points");
                                        Vector<Student> tempStudent = new Vector<>();
                                        tempStudent = Student.getStudents();
                                        Collections.sort(tempStudent, new Student.sortPoints());
                                        Student.setStudents(tempStudent);
                                        for (int i = 0; i < Student.getStudents().size(); i++) {
                                            System.out.println(Student.getStudents().get(i));
                                        }
                                    }
                                    case 3 -> {
                                        System.out.println("code to sort by id");
                                        Vector<Student> tempStudens = new Vector<>();
                                        tempStudens = Student.getStudents();
                                        Collections.sort(tempStudens, new Student.sortId());
                                        Student.setStudents(tempStudens);
                                        for (int i = 0; i < Student.getStudents().size(); i++) {
                                            System.out.println(Student.getStudents().get(i));
                                        }
                                    }
                                    case 4 -> {
                                    }
                                    default -> System.out.println("Invalid option selected.");
                                }
                            }
                            case 2 -> {
                                System.out.println("Main menu -> Sort -> Teachers");
                                System.out.println("1. Sort first name : ");
                                System.out.println("2. Sort title : ");
                                System.out.println("3. Sort id : ");
                                System.out.println("4. Go back to main menu ");
                                int subActionSort = input.nextInt();

                                switch (subActionSort) {
                                    case 1 -> {
                                        System.out.println("code to sort by first name");
                                        Vector<Teacher> tempTeachers = new Vector<>();
                                        tempTeachers = Teacher.getTeachers();
                                        Collections.sort(tempTeachers);
                                        Teacher.setTeachers(tempTeachers);
                                        for (int i = 0; i < Teacher.getTeachers().size(); i++) {
                                            System.out.println(Teacher.getTeachers().get(i));
                                        }
                                    }
                                    case 2 -> {
                                        System.out.println("code to sort by title");
                                        Vector<Teacher> tempTeachers = new Vector<>();
                                        tempTeachers = Teacher.getTeachers();
                                        Collections.sort(tempTeachers, new Teacher.sortTitle());
                                        Teacher.setTeachers(tempTeachers);
                                        for (int i = 0; i < Teacher.getTeachers().size(); i++) {
                                            System.out.println(Teacher.getTeachers().get(i));
                                        }
                                    }
                                    case 3 -> {
                                        System.out.println("code to sort by id");
                                        Vector<Teacher> tempTeachers = new Vector<>();
                                        tempTeachers = Teacher.getTeachers();
                                        Collections.sort(tempTeachers, new Teacher.sortId());
                                        Teacher.setTeachers(tempTeachers);
                                        for (int i = 0; i < Teacher.getTeachers().size(); i++) {
                                            System.out.println(Teacher.getTeachers().get(i));
                                        }
                                    }
                                    case 4 -> {
                                    }
                                    default -> System.out.println("Invalid option selected.");
                                }
                            }
                            case 3 -> {
                                System.out.println("Main menu -> Sort -> Courses");
                                System.out.println("1. Sort course name : ");
                                System.out.println("2. Sort points : ");
                                System.out.println("3. Go back to main menu ");
                                int subActionSort = input.nextInt();

                                switch (subActionSort) {
                                    case 1 -> {
                                        System.out.println("Sorted by course name..");
                                        Vector<Course> tempCourses = new Vector<>();
                                        tempCourses = Course.getCoursesList();
                                        Collections.sort(tempCourses, new Course.sortName());
                                        Course.setCoursesList(tempCourses);
                                        for (int i = 0; i < Course.getCoursesList().size(); i++) {
                                            System.out.println(Course.getCoursesList().get(i));
                                        }
                                    }
                                    case 2 -> {
                                        System.out.println("Sorted by course points");
                                        Vector<Course> tempCourse = new Vector<>();
                                        tempCourse = Course.getCoursesList();
                                        Collections.sort(tempCourse, new Course.sortPoints());
                                        Course.setCoursesList(tempCourse);
                                        for (int i = 0; i < Course.getCoursesList().size(); i++) {
                                            System.out.println(Course.getCoursesList().get(i));
                                        }
                                    }
                                    case 3 -> {
                                    }
                                    default -> System.out.println("Invalid option selected.");
                                }
                            }
                            case 4 -> {
                            }
                            default -> System.out.println("Invalid option selected.");
                        }
                    }
                    case 6 -> {
                        System.out.println("Main menu -> Quit");
                        System.out.println("1. Quit ");
                        System.out.println("2. Save and quit ");
                        System.out.println("3. Go back a menu ");
                        int subAction = input.nextInt();
                        switch (subAction) {
                            case 1 -> {
                                System.out.println("Exiting...");
                                stay = false;
                                return;
                            }

                            case 2 -> {
                                System.out.println("Main menu -> Quit -> Sure");
                                System.out.println("Saving your update will override existing data, \nAre you sure you want to override?");
                                System.out.println("1. Yes ");
                                System.out.println("2. Go back ");
                                int inSubAction = input.nextInt();
                                switch (inSubAction) {
                                    case 1 -> {
                                        System.out.println("Saving and exiting...");
                                        writeStudentsToFile();
                                        writeTeachersToFile();
                                        writeCoursesToFile();
                                        stay = false;
                                        return;
                                    }
                                    case 2 -> {
                                        System.out.println("Going back to main menu");
                                    }
                                    default -> System.out.println("Invalid action.");
                                }
                            }
                            case 3 -> {
                                System.out.println("Going back to main menu");
                            }
                            default -> System.out.println("Invalid action.");
                        }
                    }
                    default -> System.out.println("Invalid option selected.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input was entered...");
                stay = false;
            } catch (IOException general) {
                System.out.println("Something went wrong...");
                stay = false;
            }
        }
    }

}
