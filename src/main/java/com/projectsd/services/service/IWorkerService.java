package com.projectsd.services.service;

import com.projectsd.services.model.Worker;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IWorkerService {
    List<Worker> getWorkers();
    Worker findWorkerById(Long id);
    Worker createWorker(Worker worker);
    Worker updateWorker(Worker worker);
    Worker deleteWorker(Long id);
}
