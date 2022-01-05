import java.util.ArrayList;

public class Course {
    // The private members of the Course class
    private String uniqueName;
    private ArrayList<Section> sections;
    private ArrayList<Course> requirement;

    // Constructor that will initialize the class
    Course(String uniqueName) {
        // Initializes the members of the class and creates the ArrayLists
        this.uniqueName = uniqueName;
        sections = new ArrayList<>();
        this.requirement = new ArrayList<>();
    }

    // addSection function that checks if the section previously exists and adds it if it
    // doesn't and returns true. If it previously exists then it returns false
    boolean addSection(Section section) {
        // If statement to check if section exists
        if (sections.contains(section))
            return false;
        // Adds section as another section of the course
        sections.add(section);
        return true;
    }

    // enrollStudent function that checks if the student is able to enroll in a given section
    // of a course
    boolean enrollStudent(Student student, String sectionName) {
        int sectionIndex = getSectionIndex(sectionName);
        // Checks if there is enough space for enrollment
        if (sectionIndex == -1) {
            return false;
        } else {
            // For loop to go through all the courses that are requirements
            for (Course course : this.requirement ) {
                // If student is not enrolled in the requirement course then it returns false
                if (!student.studentCourse().contains(course)) {
                    return false;
                }
            }
            // If student doesn't contain the course then it adds it to the student's courses
            if (!student.studentCourse().contains(this)) {
                student.studentCourse().add(this);
            }
            return sections.get(sectionIndex).enrollStudent(student);
        }
    }

    // unenrollStudent function that checks if the student is able to unenroll in a given section
    // of a course
    boolean unenrollStudent(Student student, String sectionName) {
        int sectionIndex = getSectionIndex(sectionName);
        // Checks if user is able to unenroll given the enrollment capacity
        if (sectionIndex == -1) {
            return false;
        } else {
            // For loop to go through all the courses the student is enrolled in
            for (Course course: student.studentCourse()) {
                // For loop to go through all the requirements of the course
                for (Course newCourse : course.requirement) {
                    // If student unenrolls from a course that is a requirement then
                    // it returns false
                    if (newCourse.getUniqueName().equals(this.getUniqueName())) {
                        return false;
                    }
                }
            }
            // If user is enrolled then it removes the course from their courses
            if (student.studentCourse().contains(this)) {
                student.studentCourse().remove(this);
            }
            return sections.get(sectionIndex).unenrollStudent(student);
        }
    }

    // getUniqueName function that returns the name of the course
    public String getUniqueName() {
        return uniqueName;
    }

    // getSectionIndex function that checks if the section for a course exists
    private int getSectionIndex(String sectionName) {
        // For loop to go through all the sections for the course
        for (int i = 0; i < sections.size(); i++) {
            // If statement that returns counter if section is found
            if (sections.get(i).getSectionName().equals(sectionName)) {
                return i;
            }
        }
        return -1;
    }

    // addRequirement function that adds the given course as a requirement
    boolean addRequirement(Course course) {
        // Checks if the course is already a requirement
        if (this.requirement.contains(course)) {
            return false;
        }
        // Adds course as a requirement
        this.requirement.add(course);
        return true;
    }
}
