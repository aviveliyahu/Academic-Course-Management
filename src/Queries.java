import java.util.Collections;
import java.util.Objects;
import java.util.Vector;

public class Queries {
    public static void isUnder25() {
        System.out.println("_____________________________________________");
        System.out.println("1.Query printing registered people under 25:");
        System.out.println("");
        for (int i = 0; i < Person.getRegistered().size(); i++) {
            if (Person.getRegistered().get(i).getAge() < 25) {
                System.out.println(Person.getRegistered().get(i));
            }
        }
        System.out.println("_____________________________________________");
    }

    public static void zeroPoints() {
        System.out.println("_____________________________________________");
        System.out.println("2.Query printing registered students with no courses:");
        System.out.println("");
        for (int i = 0; i < Student.getStudents().size(); i++) {
            if (Student.getStudents().get(i).getCoursesList().isEmpty()) {
                System.out.println(Student.getStudents().get(i));
            }
        }
        System.out.println("_____________________________________________");
    }

    public static void howManyDoc() {
        System.out.println("_____________________________________________");
        System.out.println("3.Query printing how many teachers are doctors:");
        System.out.println("");
        int tempCount = 0;
        for (int i = 0; i < Teacher.getTeachers().size(); i++) {
            if (Objects.equals(Teacher.getTeachers().get(i).getTitle(), "doc")) {
                tempCount += 1;
            }
        }
        System.out.println(tempCount);
        System.out.println("_____________________________________________");
    }

    public static void howManyNamedShireen() {
        System.out.println("_____________________________________________");
        System.out.println("4.Query printing how many registered personals first named Shireen:");
        System.out.println("");
        int tempCount = 0;
        for (int i = 0; i < Person.getRegistered().size(); i++) {
            if (Person.getRegistered().get(i).getFirstName().equals("Shireen")) {
                tempCount += 1;
            }
        }
        System.out.println(tempCount);
        System.out.println("_____________________________________________");
    }

    public static void removeAllProf() {
        System.out.println("_____________________________________________");
        System.out.println("5.Query removing all the registered personals who is prof:");
        System.out.println("");
        for (int i = 0; i < Teacher.getTeachers().size(); i++) {
            if (Objects.equals(Teacher.getTeachers().get(i).getTitle(), "prof")) {
                Teacher.getTeachers().remove(i);
            }
        }
        for (Person c : Teacher.getTeachers())
            System.out.println(c);
        System.out.println("_____________________________________________");
    }

    public static void removeAllUnder20() {
        System.out.println("_____________________________________________");
        System.out.println("6.Query removing all the registered personals who is under 20:");
        System.out.println("");
        for (int i = 0; i < Person.getRegistered().size(); i++) {
            if (Person.getRegistered().get(i).getAge() <= 20) {
                Person.getRegistered().remove(i);
            }
        }
        for (Person c : Person.getRegistered())
            System.out.println(c);
        System.out.println("_____________________________________________");
    }

    public static void studentsIsEmpty() {
        System.out.println("_____________________________________________");
        System.out.println("7.Query checking is students empty:");
        System.out.println("");
        System.out.println(Student.getStudents().isEmpty());
        System.out.println("_____________________________________________");
    }

    public static void teachersIsEmpty() {
        System.out.println("_____________________________________________");
        System.out.println("8.Query checking is teachers empty:");
        System.out.println("");
        System.out.println(Teacher.getTeachers().isEmpty());
        System.out.println("_____________________________________________");
    }

    public static void coursesIsEmpty() {
        System.out.println("_____________________________________________");
        System.out.println("9.Query checking is courses empty:");
        System.out.println("");
        System.out.println(Course.getCoursesList().isEmpty());
        System.out.println("_____________________________________________");
    }

    public static void firstFiveStudentsAlphabet() {
        System.out.println("_____________________________________________");
        System.out.println("10.Query prints the top 5 students in alphabetical order:");
        System.out.println("");
        Vector<Student> tempStudent = new Vector<>();
        tempStudent = Student.getStudents();
        Collections.sort(tempStudent);
        Student.setStudents(tempStudent);
        for (int i = 0; i < 5; i++) {
            System.out.println(Student.getStudents().get(i));
        }
        System.out.println("_____________________________________________");
    }

    public static void lastFiveTeachersAlphabet() {
        System.out.println("_____________________________________________");
        System.out.println("11.Query prints the last 5 teachers in alphabetical order:");
        System.out.println("");
        Vector<Teacher> tempTeacher = new Vector<>();
        tempTeacher = Teacher.getTeachers();
        Collections.sort(tempTeacher);
        Teacher.setTeachers(tempTeacher);
        System.out.println(Teacher.getTeachers().get(Teacher.getTeachers().size()-1));
        System.out.println(Teacher.getTeachers().get(Teacher.getTeachers().size() - 2));
        System.out.println(Teacher.getTeachers().get(Teacher.getTeachers().size() - 3));
        System.out.println(Teacher.getTeachers().get(Teacher.getTeachers().size() - 4));
        System.out.println(Teacher.getTeachers().get(Teacher.getTeachers().size() - 5));
        System.out.println("_____________________________________________");
    }
}
