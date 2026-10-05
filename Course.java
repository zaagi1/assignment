public class Course {
    // Data fields
    private String courseName;
    private String[] students;
    private int numberOfStudents;

    // Constructor
    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new String[10]; // Initial capacity of 10
        this.numberOfStudents = 0;
    }

    // Getter for courseName
    public String getCourseName() {
        return courseName;
    }

    // Add a student to the course (Dynamic array expansion if full)
    public void addStudent(String student) {
        if (numberOfStudents >= students.length) {
            String[] temp = new String[students.length * 2];
            System.arraycopy(students, 0, temp, 0, students.length);
            students = temp;
        }
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    // Drop a student from the course
    public void dropStudent(String student) {
        int index = -1;
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].equals(student)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < numberOfStudents - 1; i++) {
                students[i] = students[i + 1];
            }
            students[numberOfStudents - 1] = null;
            numberOfStudents--;
        }
    }

    // Returns an array containing only the currently enrolled students
    public String[] getStudents() {
        String[] currentStudents = new String[numberOfStudents];
        System.arraycopy(students, 0, currentStudents, 0, numberOfStudents);
        return currentStudents;
    }

    // Getter for numberOfStudents
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
}