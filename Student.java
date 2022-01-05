import java.util.ArrayList;

public class Student {
    // Private members of the Section class
    private int studentID;
    private String name;
    private ArrayList<Course> studentCourse;

    // Constructor that will initialize the class
    Student(String name, int studentID) {
        // Initializes the members of the class and creates the ArrayLists
        this.studentID = studentID;
        this.name = name;
        this.studentCourse = new ArrayList<>();
    }

    // addCourse function that adds the course to the ArrayList of the student's courses
    // if it isn't already in the student's courses
    void addCourse(Course course) {
        if (!this.studentCourse.contains(course)) {
            this.studentCourse.add(course);
        }
    }

    // removeCourse function that removes the course to the ArrayList of the student's courses
    // if it isn't already in the student's courses
    void removeCourse(Course course) {
        if (!this.studentCourse.contains(course)) {
            this.studentCourse.remove(course);
        }
    }

    // studentCourse function that returns the ArrayList of the student's courses
    public ArrayList<Course> studentCourse() {
        return studentCourse;
    }

    // getStudentID function that returns the student's ID
    public int getStudentID() {
        return studentID;
    }

    // getName function that returns the student's name
    public String getName() {
        return name;
    }
}
