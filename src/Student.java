import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Student extends Person implements Comparable <Person> {
    /**
     * Class's features
     */
    private String job = "Student";
    private int maxPoint = 10;
    private int points;
    private Vector<Course> courses;
    private static Vector<Student> students = new Vector<>(0);

    /**
     * constructor
     */
    public Student(String firstName, String lastName, int id, int age, String email) {
        super(firstName, lastName, id, age, email);
        this.courses = new Vector<Course>(0);
        this.points = 0;
        students.add(this);
    }

    /**
     * methods
     */
    public void addCourse(Course c) {
        this.courses.add(c);
        this.points = this.points + c.getPoints();
    }

    public void removeCourse(Course c) {
        this.courses.remove(c);
        this.points = this.points - c.getPoints();
    }

    public Vector<String> getCoursesName() {
        Vector<String> names = new Vector<>(0);
        for (int i = 0; i < courses.size(); i++) {
            names.add(courses.get(i).getCourseName());
        }
        return names;
    }

    public static void add(int indx, Student c){
        Student.students.set(indx,c);
    }

    public static void contains(Student c){
        boolean check = false;
        for(int i=0;i<Student.students.size();i++){
            if(Student.students.get(i).equals(c)){
                System.out.println("Object exist");
                check = true;
            }
        }
        if(check == false){
            System.out.println("Object doesnt exist");
        }
    }

    public static int size(){
        return Student.students.size();
    }

    public static void isEmpty(){
        if(Student.students.size()==0){
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
            Student.setStudents(new Vector<Student>(0));
            System.out.println("Vector cleared.");
        }

    }


    /**
     * Getter & setter for class's features
     */

    public Vector<Course> getCoursesList() {
        return courses;
    }

    public void setCourseList(Vector<Course> course) {
        this.courses = course;
    }


    public static Vector<Student> getStudents() {
        return students;
    }

    public static void setStudents(Vector<Student> students) {
        Student.students = students;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMaxpoint() {
        return maxPoint;
    }

    public void setMaxpoint(int maxpoint) {
        this.maxPoint = maxpoint;
    }

    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return "job= " + job +
                ", firstName= " + super.getFirstName() +
                ", lastName= " + super.getLastName() +
                ", id= " + super.getId() +
                ", email= " + super.getEmail() +
                ", courses= " + getCoursesName() +
                ", studying points= " + getPoints();
    }

    /**
     * Comparators
     */

    static class sortPoints implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getPoints() - o2.getPoints();
        }
    }

    static class sortId implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getId() - o2.getId();
        }
    }
}
