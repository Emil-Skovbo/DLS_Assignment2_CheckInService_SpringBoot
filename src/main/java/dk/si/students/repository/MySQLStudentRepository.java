package dk.si.students.repository;

 import dk.si.students.entities.Student;
 import dk.si.students.entities.User;
 import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface MySQLStudentRepository extends CrudRepository<Student, Integer> {
}