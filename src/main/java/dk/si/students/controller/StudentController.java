package dk.si.students.controller;

import dk.si.students.exceptions.StudentNotFoundException;
import dk.si.students.entities.Student;
import dk.si.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentRepository repo;

    @GetMapping("/")
    public List<Student> retrieveAllStudents()
    {
        return repo.findAll();
    }

    // This is the only method, which returns hyperlinks, for now
    // If the resource is found, a link to its 'family' is appended to its native load
    @GetMapping("/{id}")
    public EntityModel<Student> retrieveStudent(@PathVariable int id)
    {
        Optional<Student> student = repo.findById(id);
        if (!student.isPresent())
            throw new StudentNotFoundException("id: " + id);

        EntityModel<Student> resource = EntityModel.of(student.get()); 						// get the resource
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllStudents()); // get link
        resource.add(linkTo.withRel("all-students"));										// append the link

        Link selfLink = linkTo(methodOn(this.getClass()).retrieveStudent(id)).withSelfRel(); //add also link to self
        resource.add(selfLink);
        return resource;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        repo.deleteById(id);
    }

    // Create a new resource and remember its unique location in the hypermedia
    @PostMapping("/")
    public ResponseEntity<Object> createStudent(@RequestBody Student student)
    {
        Student savedStudent = repo.save(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable int id)
    {
        Optional<Student> studentOptional = repo.findById(id);
        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();
        student.setId(id);
        repo.save(student);
        return ResponseEntity.noContent().build();
    }
}
