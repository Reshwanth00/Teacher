package com.example.eaxm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    public void add_teacher(TeacherObject teacher){
        teacher.setAddMissionNo(teacherRepository.teacherDB.size()+1);
        teacherRepository.teacherDB.put(teacher.getName(),teacher);
    }
    public List<String> all(){
        return new ArrayList<>(teacherRepository.teacherDB.keySet());
    }
    public boolean checkCourse(String course){
        for(Map.Entry<String,TeacherObject> itr: teacherRepository.teacherDB.entrySet()){
            if(itr.getValue().getCourse().equals(course)){
                return true;
            }
        }
        return false;
    }
    public boolean checkName(String name){
        return teacherRepository.teacherDB.containsKey(name);
    }
    public void change(String course, String name) {
        for(Map.Entry<String,TeacherObject> itr: teacherRepository.teacherDB.entrySet()) {
            if (itr.getValue().getCourse().equals(course)) {
                teacherRepository.teacherDB.put(name,itr.getValue());
                return ;
            }
        }
    }
    public void delete(String name) {
        teacherRepository.teacherDB.remove(name);
    }

    public int addmissionNo(String name) {
        return teacherRepository.teacherDB.get(name).getAddMissionNo();
    }

}
