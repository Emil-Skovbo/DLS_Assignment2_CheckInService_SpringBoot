package dk.si.students.repository;

import dk.si.students.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // There are no methods here, but we can still use all those, which we inherit from JpaRepository
}
