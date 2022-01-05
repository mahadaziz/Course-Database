public class TerminalPrinter {
    // printEnrollmentResult function that prints whether the student is enrolled or
    // not based on whether their enrollment was successful
    static void printEnrollmentResult(boolean wasSuccessful,
                                      String studentName,
                                      String courseName,
                                      String sectionName) {
        // Prints statement if user's enrollment was successful or not
        if (wasSuccessful) {
            System.out.println(studentName + " WAS ENROLLED IN " + courseName + " SECTION " + sectionName);
        } else {
            System.out.println(studentName + " WAS NOT ENROLLED IN " + courseName + " SECTION " + sectionName);
        }
    }

    // printUnenrollmentResult function that prints whether the student is unenrolled or
    // not based on whether their unenrollment was successful
    static void printUnenrollmentResult(boolean wasSuccessful,
                                      String studentName,
                                      String courseName,
                                      String sectionName) {
        // Prints statement if user's unenrollment was successful or not
        if (wasSuccessful) {
            System.out.println(studentName + " WAS UNENROLLED FROM " + courseName + " SECTION " + sectionName);
        } else {
            System.out.println(studentName + " WAS NOT UNENROLLED FROM " + courseName + " SECTION " + sectionName);
        }
    }

}
