package com.example.Student_management_System.Controller;


import com.example.Student_management_System.Dao.IStudentrepository;
import com.example.Student_management_System.Model.Course;
import com.example.Student_management_System.Model.Student;
import com.example.Student_management_System.Service.Courseservice;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Coursecontroller {

    @Autowired
    Courseservice courseservice;

    @Autowired
    IStudentrepository studentrepository;

    @PostMapping("savecourse")
    public ResponseEntity savecourse(@RequestBody Course courses){
//        JSONObject coursedetails=new JSONObject(requestcourse);
//        Course courses=setcourse(coursedetails);
        courseservice.savecourse(courses);
        return new ResponseEntity<>("course book", HttpStatus.CREATED);
    }

//    private Course setcourse(JSONObject json) {
//
//        Course course=new Course();
//
//        course.setTitle(json.getString("title"));
//        course.setDescription(json.getString("description"));
//        course.setDuration(json.getString("duration"));
//
//        JSONArray jsonArray=json.getJSONArray("studentlist");
//        List<Student> students=new ArrayList<>();
//        int i= jsonArray.length();
//        while(i!=0){
//            JSONObject jsonObject=jsonArray.getJSONObject(i);
//            students.add(studentrepository.findById(jsonObject.getInt("student_id")).get());
//            i++;
//        }


//         course.setStudentList(students);
//
//         return course;
//    }

    @GetMapping("savecourse")
    public List<Course> getcourse(@Nullable @RequestParam Integer course_id){
        List<Course> courses=courseservice.getcourse(course_id);
        return courses;
    }


    @PutMapping("updatecourse/{course_id}")
    public String updatecourse(@PathVariable Integer course_id, @RequestBody Course newcourse){
        courseservice.updatecourse(course_id,newcourse);
        return "course updated";
    }

}
