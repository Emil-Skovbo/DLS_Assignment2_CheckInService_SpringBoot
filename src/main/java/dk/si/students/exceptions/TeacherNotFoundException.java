package dk.si.students.exceptions;

public class TeacherNotFoundException extends RuntimeException{
    public TeacherNotFoundException(String exception) {
        super(exception);
    }
}
