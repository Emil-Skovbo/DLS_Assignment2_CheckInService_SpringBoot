package dk.si.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentsApplication.class, args);
    }
//password for mysql = 1234
    // docker run -d --name worldchampions -e MYSQL_ROOT_PASSWORD=1234 -p 3307:3306 mysql
}
