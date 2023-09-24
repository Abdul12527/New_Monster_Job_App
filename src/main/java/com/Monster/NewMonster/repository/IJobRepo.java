package com.Monster.NewMonster.repository;

import com.Monster.NewMonster.Model.Job;
import com.Monster.NewMonster.Model.JobTypes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IJobRepo extends CrudRepository<Job,Long> {

    List<Job> findByJobTypes(JobTypes type);

    List<Job> findBySalaryGreaterThanEqualOrderBySalaryDesc(Double salary);

    List<Job> findByJobTypesAndSalaryGreaterThanEqualOrderBySalaryDesc(JobTypes type, Double salary);

    @Modifying
    @Query(value = " UPDATE JOB SET SALARY = SALARY + :hikeAmount WHERE JOB_TYPES = :jobType", nativeQuery = true)
    void updateSalaryByJobType( Double hikeAmount,  String jobType);


}
