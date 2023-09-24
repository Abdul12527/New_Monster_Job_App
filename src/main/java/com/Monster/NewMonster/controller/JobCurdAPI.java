package com.Monster.NewMonster.controller;

import com.Monster.NewMonster.Model.Job;
import com.Monster.NewMonster.Model.JobTypes;
import com.Monster.NewMonster.services.JobServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class JobCurdAPI {
    @Autowired
    JobServices jobServices;

    @PostMapping("/job")
    public String addJob(@Valid @RequestBody Job job){
        jobServices.addJob(job);
        return "200 job added sucessfully";
    }

    @GetMapping("/jobs")
    public List<Job> getAllJobs(){
        return jobServices.getAllJobs();
    }

    @GetMapping("/job/id/{id}")
    public Job getJobById(@PathVariable Long id){
        return jobServices.getJobById(id);
    }

    @GetMapping("/jobs/type/{type}")
    public List<Job> filterByJobType(@PathVariable JobTypes type){
        return jobServices.findByJobTypes(type);
    }

    @GetMapping("/jobs/salary/{salary}")
    public List<Job> filterBySalary(@PathVariable Double salary){
        return  jobServices.findBySalaryGreaterThanEqualOrderBySalaryDesc(salary);
    }

    @GetMapping("/jobs/type/salary")
    public List<Job> filterByJobTypeAndSalary(@RequestParam JobTypes type,@RequestParam Double salary){
        return  jobServices.findByJobTypesAndSalaryGreaterThanEqualOrderByDesc(type,salary);
    }
    @PutMapping("jobs/type/hike")
    public String slaryHikeforType(@RequestParam JobTypes jobType, @RequestParam Double hike) {
        jobServices.updateSalaryByJobType(hike, jobType);
        return "updated";
    }
@PutMapping("job/id")
    public String updateJob(@RequestParam Long id, @RequestParam(required = false) String title, @RequestParam(required = false) String description, @RequestParam(required = false) String location,@RequestParam(required = false) Double salary, @RequestParam(required = false) String companyEmail, @RequestParam(required = false) String companyName, @RequestParam(required = false) String employerName, @RequestParam(required = false) JobTypes jobTypes,@RequestParam(required = false) Date appliedDate){
        jobServices.updateJob(id,title,description,location,salary,companyEmail,companyName,employerName,jobTypes,appliedDate);
        return "Updated";
    }





}
