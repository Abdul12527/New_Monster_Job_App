package com.Monster.NewMonster.services;

import com.Monster.NewMonster.Model.Job;
import com.Monster.NewMonster.Model.JobTypes;
import com.Monster.NewMonster.repository.IJobRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

@Service
public class JobServices {
    @Autowired
    IJobRepo jobRepo;
    public void addJob(Job job) {
        jobRepo.save(job);
    }

    public List<Job> getAllJobs() {
        return (List<Job>) jobRepo.findAll();
    }

    public Job getJobById(Long id) {
        return jobRepo.findById(id).orElse(null);
    }

    public List<Job> findByJobTypes(JobTypes type) {
        return jobRepo.findByJobTypes(type);
    }

    public List<Job> findBySalaryGreaterThanEqualOrderBySalaryDesc(Double salary) {
        return jobRepo.findBySalaryGreaterThanEqualOrderBySalaryDesc(salary);
    }

    public List<Job> findByJobTypesAndSalaryGreaterThanEqualOrderByDesc(JobTypes type, Double salary) {
        return jobRepo.findByJobTypesAndSalaryGreaterThanEqualOrderBySalaryDesc(type,salary);
    }
    @Transactional
    public void updateSalaryByJobType(Double hikeAmount, JobTypes jobType) {
        jobRepo.updateSalaryByJobType(hikeAmount, jobType.name());
    }

    private static void updateIfNotNullAndNotEmpty(String value, Consumer<String> updater) {
        if (value != null && !value.isEmpty()) {
            updater.accept(value);
        }
    }
    public void updateJob(Long id, String title, String description, String location, Double salary, String companyEmail, String companyName, String employerName, JobTypes jobTypes, Date appliedDate) {
        if(!jobRepo.existsById(id))return;
        Job job=jobRepo.findById(id).get();
        updateIfNotNullAndNotEmpty(title, value -> job.setTitle(title));
        updateIfNotNullAndNotEmpty(description, value -> job.setDescription(description));
        updateIfNotNullAndNotEmpty(location, value -> job.setLocation(location));
        if(salary!=null)
            updateIfNotNullAndNotEmpty(salary.toString(), value -> job.setSalary(salary));
        updateIfNotNullAndNotEmpty(companyEmail, value -> job.setCompanyEmail(companyEmail));
        updateIfNotNullAndNotEmpty(companyName, value -> job.setCompanyName(companyName));
        if(jobTypes!=null)
            updateIfNotNullAndNotEmpty(jobTypes.name(), value -> job.setJobTypes(jobTypes));
        updateIfNotNullAndNotEmpty(employerName, value -> job.setEmployerName(employerName));

        jobRepo.save(job);
    }

    public void deleteJobById(Long id) {
        jobRepo.deleteById(id);
    }
    @Transactional
    public void deleteAllJobsBeforeDate(Date date){
        jobRepo.deleteJobsWithAppliedDateLessThan(date);
    }

}
