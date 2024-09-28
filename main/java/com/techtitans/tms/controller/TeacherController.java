package com.techtitans.tms.controller;

import com.techtitans.tms.model.Announcement;
import com.techtitans.tms.model.Students;
import com.techtitans.tms.model.Subject;

import com.techtitans.tms.model.Teachers;
import com.techtitans.tms.services.AnnouncementService;
import com.techtitans.tms.services.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    AnnouncementService announcementService;

    @Autowired
    StudentService studentService;

    @PostMapping("/register")
    public String registerTeacher(@RequestBody Teachers teacher)
    {
        System.out.println(teacher);
        return "teacher registered";
    }

    //geting specific sub when cliked from home
    @GetMapping("/home/{id}")
    public String subject(@PathVariable int id)
    {
        System.out.println(id);
        return "welcome to subject:";
    }

    @PostMapping("/home/subdetail")
    public String addSubDetail(@RequestBody Subject subject)
    {
        System.out.println(subject);
        return "subject added to DB..";
    }

    //giving all studs for DB for attendance
    @GetMapping("/attendance")
    public List<Students> studentsAttendance()
    {
        List<Students>students = studentService.getAllStudents();
        return students;
    }

    @PostMapping("/announcement")
    public void announcement(@RequestBody Announcement data){

        announcementService.saveAnnouncement(data);

    }

}
