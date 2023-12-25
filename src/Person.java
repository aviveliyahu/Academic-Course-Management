import java.util.Scanner;
import java.util.Vector;

public class Person extends AbstractPerson implements Comparable<Person> {
    /**
     * Class's features
     */
    private String firstName;
    private String lastName;
    private int id;
    private int age;
    private String email;
    private static Vector<Person> registered = new Vector<>(0);

    /**
     * constructor
     */
    public Person(String firstName, String lastName, int id, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.email = email;
        this.age = age;
        new Vector<>(0);
        registered.add(this);
    }
    /**
     * Methods
     */
    public static void add(int indx, Person c){
        Person.registered.set(indx,c);
    }

    public static void contains(Person c){
        boolean check = false;
        for(int i=0;i<Person.registered.size();i++){
            if(Person.registered.get(i).equals(c)){
                System.out.println("Object exist");
                check = true;
            }
        }
        if(check == false){
            System.out.println("Object doesn't exist");
        }
    }
    public static int size(){
        return Person.registered.size();
    }

    public static void isEmpty(){
        if(Person.registered.size()==0){
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
            Person.setRegistered(new Vector<Person>(0));
            Teacher.setTeachers(new Vector<Teacher>(0));
            Student.setStudents(new Vector<Student>(0));
            System.out.println("Vector cleared.");
        }

    }


    /**
     * Getter & setter for class's features
     */
    public static Vector<Person> getRegistered() {
        return registered;
    }

    public static void setRegistered(Vector<Person> registered) {
        Person.registered = registered;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Person searchById(int id) {
        for (int i = 0; i < getRegistered().size(); i++) {
            if (getRegistered().get(i).getId() == id) {
                return getRegistered().get(i);
            }
        }
        return null;
    }


    /**
     * toString
     */
    @Override
    public String toString() {
        return "Person: " +
                "firstName= " + firstName +
                ", lastName= " + lastName +
                ", age= " + age +
                ", id= " + id +
                ", email= " + email;
    }

    /**
     * Comparators
     */

    @Override
    public int compareTo(Person o) {
        return this.getFirstName().compareTo(o.getFirstName());
    }
}
