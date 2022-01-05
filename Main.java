import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Registrar registrar = new Registrar();
        // registrar.runExampleCommands();

        // Initialize scanner for user input
        Scanner keyboard = new Scanner(System.in);

        // Initialize ArrayList that will hold user input
        ArrayList<String> input = new ArrayList<>();
        // Initialize ArrayList that will hold all courses
        ArrayList<Course> courses = new ArrayList<>();
        // Initialize ArrayList that will hold all students
        ArrayList<Student> students = new ArrayList<>();

        // Initialize variables
        boolean enrollmentResult;
        String name;
        String courseCode;
        String courseCode2;
        String sec;
        int id;
        int enrollment;

        // While loop that will run until the user enters FINISH as an input
        while (keyboard.hasNext()) {
            // Adds the user's input to the input ArrayList
            input.add(keyboard.nextLine());
            // Checks if user has entered the FINISH that will terminate the while loop
            if (input.contains("FINISH")) {
                break;
            }
        }

        // For loop that will go through all the elements in the input ArrayList
        for (int i = 0 ; i < input.size() ; i++) {
            // Places the line of input into a variable that will later get split
            String line = input.get(i);
            // Splits the line of input
            String[] splitLine = line.split(" ");
            // Takes the first token and puts it in a String that will be used to determine
            // what feature the user is trying to use
            String token = splitLine[0];

            // If user enters COURSE as the token then it executes this if statement that
            // creates a new course
            if (token.equals("COURSE")) {
                courseCode = splitLine[1];
                // Creates a new instance of the Course object using the given course code
                Course course = new Course(courseCode);
                // Adds the course to the ArrayList of courses
                courses.add(course);
            }
            // If user enters STUDENT as the token then it executes this if statement that
            // creates a new student
            else if (token.equals("STUDENT")) {
                name = splitLine[1];
                id = Integer.parseInt(splitLine[2]);
                // Creates a new instance of the Student object using the student name and id
                Student student = new Student(name, id);
                // Adds the student to the ArrayList of students
                students.add(student);
            }
            // If user enters SECTION as the token then it executes this if statement that
            // creates a new section for a given course
            else if (token.equals("SECTION")) {
                courseCode = splitLine[1];
                sec = splitLine[2];
                enrollment = Integer.parseInt(splitLine[3]);
                // Checks to see if the information for the course given exists
                Course course = courseSearch(courses, courseCode);
                // Adds a new section for a course given its section name and max enrollment
                course.addSection(new Section(sec, enrollment));
            }
            // If user enters ENROLL as the token then it executes this if statement that
            // enrolls a student in a course given that the course exists, student exists,
            // section exists, and has enough space for enrollment
            else if (token.equals("ENROLL")) {
                id = Integer.parseInt(splitLine[1]);
                courseCode = splitLine[2];
                sec = splitLine[3];
                // Checks to see if the information for the course given exists
                Course course = courseSearch(courses, courseCode);
                // Checks to see if the information for the student given exists
                Student student = studentSearch(students, id);
                // Checks if student is able to enroll in a given section
                enrollmentResult = course.enrollStudent(student, sec);
                // Prints to terminal if user was able to enroll or not
                TerminalPrinter.printEnrollmentResult(enrollmentResult, student.getName(),
                        course.getUniqueName(), sec);
            }
            // If user enters UNENROLL as the token then it executes this if statement that
            // unenrolls a student in a course given that the course exists, student exists,
            // section exists, and they were previously enrolled
            else if (token.equals("UNENROLL")) {
                id = Integer.parseInt(splitLine[1]);
                courseCode = splitLine[2];
                sec = splitLine[3];
                // Checks to see if the information for the course given exists
                Course course = courseSearch(courses, courseCode);
                // Checks to see if the information for the student given exists
                Student student = studentSearch(students, id);
                // Checks if student is able to unenroll in a given section
                enrollmentResult = course.unenrollStudent(student, sec);
                // Prints to terminal if user was able to unenroll or not
                TerminalPrinter.printUnenrollmentResult(enrollmentResult, student.getName(),
                        course.getUniqueName(), sec);
            }
            // If user enters FINISH as the token then it executes this if statement that
            // breaks the loop since FINISH indicates the last line of user input
            else if (token.equals("FINISH")) {
                break;
            }
            // If user enters REQUIREMENT as the token then it executes this if statement that
            // checks that the two courses already exists and then adds the second course as a
            // requirement of the first course
            else if (token.equals("REQUIREMENT")) {
                courseCode = splitLine[1];
                courseCode2 = splitLine[2];
                // Checks to see if the information for the courses given exists
                Course course = courseSearch(courses, courseCode);
                Course course2 = courseSearch(courses, courseCode2);
                // Adds course2 as a requirement of course
                course.addRequirement(course2);
            }
        }
    }

    /*
    courseSearch
    This method takes the ArrayList of courses and the name of the course and searches
    through the ArrayList for the course. If found then it returns the course otherwise
    it returns null.
    @param courses: The ArrayList that contains all the courses
    @param name: Name of the course that needs to be searched
    @return course: Returns course if it exists in the ArrayList
    Returns the array that contains the user's input
    */
    private static Course courseSearch(ArrayList<Course> courses, String name) {
        // For loop to iterate through all the courses
        for (int i = 0 ; i < courses.size() ; i++) {

            // If statement to check if courses is in the ArrayList
            if (name.equals(courses.get(i).getUniqueName())) {
                // Returns the course
                return courses.get(i);
            }
        }
        return null;
    }

    /*
    studentSearch
    This method takes the ArrayList of students and the id of the student and searches
    through the ArrayList for the student. If found then it returns the student otherwise
    it returns null.
    @param students: The ArrayList that contains all the students
    @param id: ID of the student that needs to be searched
    @return student: Returns student if it exists in the ArrayList
    Returns the array that contains the user's input
    */
    private static Student studentSearch(ArrayList<Student> students, int id) {
        // For loop to iterate through all the students
        for (int i = 0 ; i < students.size() ; i++) {

            // If statement to check if students is in the ArrayList
            if (id == students.get(i).getStudentID()) {
                return students.get(i);
            }
        }
        return null;
    }
}
