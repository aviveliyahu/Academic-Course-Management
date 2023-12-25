import java.util.Comparator;
import java.util.Vector;
import java.util.Scanner;

public class Course implements CourseInterface {
    /**
     * Class's features
     */
    private String courseName;
    private int code;
    private int points;
    private Teacher teacher;
    private Vector<Student> courseStudents;

    private static Vector<Course> coursesList = new Vector<>(0);

    public static Vector<Course> getCoursesList() {
        return coursesList;
    }

    public static void setCoursesList(Vector<Course> courses) {
        Course.coursesList = courses;
    }

    /**
     * constructor
     */
    public Course(Teacher teacher, String courseName, int code, int points) {
        this.courseName = courseName;
        this.code = code;
        this.teacher = teacher;
        this.points = points;
        this.courseStudents = new Vector<>(0);
        teacher.addCourse(getCourse());
        coursesList.add(this);
    }

    /**
     * methods
     */

    public static Course searchByCode(int code) {
        for (int i = 0; i < coursesList.size(); i++) {
            if (coursesList.get(i).getCode() == code) {
                return coursesList.get(i);
            }
        }
        return null;
    }

    public Course getCourse() {
        return this;
    }

    public void addStudent(Student s) {
        boolean isThere = false;
        for (int i = 0; i < courseStudents.size(); i++) {
            if (courseStudents.get(i).equals(s) == true) {
                System.out.println("Student already in this course.");
                isThere = true;
            }
        }
        if (isThere == false) {
            if (s.getPoints() + this.getPoints() <= s.getMaxpoint()) {
                s.addCourse(this);
                courseStudents.add(s);
                System.out.println("Student added successfully.");
            } else
                System.out.println("Unable to add course,reached student's max points.");
        }
    }

    public void removeStudent(Student s) {
        boolean isThere = true;
        for (int i = 0; i < courseStudents.size(); i++) {
            if (courseStudents.get(i).equals(s) == false) {
                System.out.println("Student not in this course.");
                isThere = false;
            }
        }
        if (isThere == true) {
            s.removeCourse(this);
            courseStudents.remove(s);
            System.out.println("Student removed successfully.");
        }
    }

    public Vector<String> getStudentName() {
        Vector<String> names = new Vector<>(0);
        for (int i = 0; i < courseStudents.size(); i++) {
            names.add(courseStudents.get(i).getFirstName());
        }
        return names;
    }

    public static void removeCourse(Course c) {
        coursesList.remove(c);
        for (int i = 0; i < Teacher.getTeachers().size(); i++) {
            Teacher temp = (Teacher) Teacher.getTeachers().get(i);
            for (int j = 0; j < temp.getCourses().size(); j++) {
                if (temp.getCourses().get(j).getCode() == c.getCode()) {
                    temp.removeCourse(c);
                }
            }
        }
        for (int i = 0; i < Student.getStudents().size(); i++) {
            Student temp = (Student) Student.getStudents().get(i);
            for (int j = 0; j < temp.getCoursesList().size(); j++) {
                if (temp.getCoursesList().get(j).getCode() == c.getCode()) {
                    temp.removeCourse(c);
                }
            }
        }
    }

    public static void updateCourseTeacher(Teacher t, int code) {
        for (int i = 0; i <= coursesList.size(); i++) {
            if (coursesList.get(i).getCode() == code) {
                coursesList.get(i).setTeacher(t);
                System.out.println("Course " + coursesList.get(i).getCourseName() + " has updated the teacher " +
                        "this is the new course details: " + coursesList.get(i));
                break;
            }
            else System.out.println("Wrong course code.");
        }
    }

    public static void add(int indx, Course c){
        Course.coursesList.set(indx,c);
    }

    public static void contains(Course c){
        boolean check = false;
        for(int i=0;i<Course.coursesList.size();i++){
            if(Course.coursesList.get(i).equals(c)){
                System.out.println("Object exist");
                check = true;
            }
        }
        if(check == false){
            System.out.println("Object doesnt exist");
        }
    }

    public static int size(){
        return Course.coursesList.size();
    }

    public static void isEmpty(){
        if(Course.coursesList.size()==0){
            System.out.println("Object vector is empty");
        }
        else {
            System.out.println("Object vector isnt empty");
        }
    }
    public static void clear(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure you want to delete everything? Y/N");
        String answer = scanner.nextLine();
        if(answer.equals("Y")){
            Course.setCoursesList(new Vector<Course>(0));
            System.out.println("Vector cleared.");
        }

    }

    /**
     * Getter & setter for class's features
     */
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Vector<Student> getCourseStudentsList() {
        return courseStudents;
    }

    public void setCourseStudentsList(Vector<Student> courseStudents) {
        this.courseStudents = courseStudents;
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return "Course{" +
                "courseName= " + courseName +
                ", code= " + code +
                ", teacher= " + teacher.getFirstName() +
                ", courseStudents= " + getStudentName() +
                ", course points= " + getPoints() +
                '}';
    }


    /**
     * Comparators
     */
    static class sortPoints implements Comparator<Course> {

        @Override
        public int compare(Course o1, Course o2) {
            return o1.getPoints() - o2.getPoints();
        }
    }

    static class sortName implements Comparator<Course> {

        @Override
        public int compare(Course o1, Course o2) {
            return o1.getCourseName().compareTo(o2.getCourseName());
        }
    }
}