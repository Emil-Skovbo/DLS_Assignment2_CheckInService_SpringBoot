package dk.si.students.repository;
import dk.si.students.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface MySQLUser extends CrudRepository<User, Integer> {
}
