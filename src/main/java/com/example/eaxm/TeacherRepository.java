package com.example.eaxm;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class TeacherRepository {
    Map<String,TeacherObject> teacherDB = new HashMap<String, TeacherObject>();

}
