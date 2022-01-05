import java.util.ArrayList;

public class Section {
    // Private members of the Section class
    private String sectionName;
    private int maxEnrolment;
    private ArrayList<Student> enrolledStudents;

    // Constructor that will initialize the class
    Section(String sectionName, int maxEnrolment) {
        // Initializes the members of the class and creates the ArrayLists
        enrolledStudents = new ArrayList<>();
        this.maxEnrolment = maxEnrolment;
        this.sectionName = sectionName;
    }

    // enrollStudent function that checks if student is able to enroll
    // in a section of a class
    boolean enrollStudent(Student student) {
        // If statement to check if the enrolled students is greater than
        // the maxEnrolment of section
        if (enrolledStudents.size() >= maxEnrolment)
            return false;
        // Adds student to the section if there is space
        enrolledStudents.add(student);
        return true;
    }

    // unenrollStudent function that removes the student from the section
    public boolean unenrollStudent(Student student) {
        return enrolledStudents.remove(student);
    }

    // getSectionName functioon that returns the name of the section
    public String getSectionName() {
        return sectionName;
    }
}
