/*
package com.projectsd.services.service;

import com.projectsd.services.model.Job;
import com.projectsd.services.repository.JobRepository;
import com.projectsd.services.service.impl.JobService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

public class JobServiceTest {

    private JobService jobService;

    @Mock
    private JobRepository jobRepository;

    private Job job;

    @BeforeEach
    void init() {
        initMocks(this);
        Job job01 = new Job();
        job01.setPrice(250);
        Job job02 = new Job();
        job02.setPrice(360);
        Job job03 = new Job();
        job03.setPrice(250);
        jobRepository.save(job01);
        jobRepository.save(job02);
        jobRepository.save(job03);
    }

    @AfterEach
    void teardown() {
        jobRepository.deleteAll();
    }

    @Test
    void updateJobTest() {
        jobService = new JobService(jobRepository);

        Job job01 = new Job();
        job01.setId(1L);
        job01.setPrice(320);

        Job jobToVerify = jobService.updateJob(job01);

        assertNotNull(jobToVerify);
        assertEquals(job01.getId(), jobToVerify.getId());
        assertEquals(job01.getPrice(), jobToVerify.getPrice());
    }
}
*/
