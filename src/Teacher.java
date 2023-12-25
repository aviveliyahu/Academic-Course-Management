import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Teacher extends Person implements Comparable <Person> {
    /**
     * Class's features
     */
    private String title;

    public int compareTo(Teacher a) {
        return this.title.compareTo(a.title);
    }

    private String job = "Teacher";
    private Vector<Course> courses;
    private static Vector<Teacher> teachers = new Vector<>(0);

    /**
     * constructor
     */
    public Teacher(String firstName, String lastName, int id, int age, String email, String title) {
        super(firstName, lastName, id, age, email);
        this.title = title;
        courses = new Vector<>(0);
        teachers.add(this);
    }

    /**
     * methods
     */

    public Vector<String> getCoursesName() {
        Vector<String> names = new Vector<>(0);
        for (int i = 0; i < courses.size(); i++) {
            names.add(courses.get(i).getCourseName());
        }
        return names;
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void removeCourse(Course c) {
        courses.remove(c);
    }

    public static void add(int indx, Teacher c){
        Teacher.teachers.set(indx,c);
    }

    public static void contains(Teacher c){
        boolean check = false;
        for(int i=0;i<Teacher.teachers.size();i++){
            if(Teacher.teachers.get(i).equals(c)){
                System.out.println("Object exist");
                check = true;
            }
        }
        if(check == false){
            System.out.println("Object doesnt exist");
        }
    }

    public static int size(){
        return Teacher.teachers.size();
    }

    public static void isEmpty(){
        if(Teacher.teachers.size()==0){
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
            Teacher.setTeachers(new Vector<Teacher>(0));
            System.out.println("Vector cleared.");

        }

    }

    /**
     * Getter & setter for class's features
     */
    public static Vector<Teacher> getTeachers() {
        return teachers;
    }

    public static void setTeachers(Vector<Teacher> teachers) {
        Teacher.teachers = teachers;
    }


    public Vector<Course> getCourses() {
        return courses;
    }


    public void setCourses(Vector<Course> courses) {
        this.courses = courses;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    /**
     * toString
     */
    @Override
    public String toString() {
        return "job= " + job +
                ", title=" + getTitle() +
                ", firstName= " + super.getFirstName() +
                ", lastName= " + super.getLastName() +
                ", id= " + super.getId() +
                ", email= " + super.getEmail() +
                ", courses= " + getCoursesName();
    }

    /**
     * Comparators
     */

    static class sortId implements Comparator<Teacher> {

        @Override
        public int compare(Teacher o1, Teacher o2) {
            return o1.getId() - o2.getId();
        }
    }

    static class sortTitle implements Comparator<Teacher> {

        @Override
        public int compare(Teacher o1, Teacher o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
}
