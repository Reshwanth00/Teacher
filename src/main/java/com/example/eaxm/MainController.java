package com.example.eaxm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class MainController {
    @Autowired
    TeacherService teacherService;
    @PostMapping("/Add_teacher")
    public ResponseEntity<String> addTeacher(@RequestBody TeacherObject teacher){
            teacherService.add_teacher(teacher);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
    @GetMapping("/Student")
    public ResponseEntity<List<String>> all_Students(){
        return new ResponseEntity<>(teacherService.all(),HttpStatus.ACCEPTED);
    }
    @GetMapping("/addmission-number-of-teacher")
    public ResponseEntity<Integer> addmission(String name){
        if(teacherService.checkName(name)){
            return new ResponseEntity<>(teacherService.addmissionNo(name),HttpStatus.FOUND);
        }
        return new ResponseEntity<>(-1,HttpStatus.NOT_FOUND);
    }
    @PostMapping("/change")
    public ResponseEntity<String> change(@RequestParam String course,@RequestParam String name){
        if(teacherService.checkCourse(course)){
            teacherService.change(course,name);
            return new ResponseEntity<>("changed successfully",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("the requested course is not found",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/delete-teacher")
    public ResponseEntity<String> deleteTeacher(@RequestParam String name){
        if(teacherService.checkName(name)){
            teacherService.delete(name);
            return new ResponseEntity<>("Success of deletion",HttpStatus.FOUND);
        }
        return new ResponseEntity<>("teacher not found",HttpStatus.NOT_FOUND);
    }
}
