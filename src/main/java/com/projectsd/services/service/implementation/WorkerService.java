package com.projectsd.services.service.impl;

import com.projectsd.services.model.Worker;
import com.projectsd.services.repository.WorkerRepository;
import com.projectsd.services.service.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService implements IWorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public List<Worker> getWorkers() {
        return (List<Worker>) workerRepository.findAll();
    }

    @Override
    public Worker findWorkerById(Long id) {
        return workerRepository.findById(id).get();
    }

    @Override
    public Worker createWorker(Worker worker) {
        workerRepository.save(worker);
        return worker;
    }

    @Override
    public Worker updateWorker(Worker worker) {
        Worker updatedWorker = workerRepository.findById(worker.getId()).get();

        updatedWorker.setFirstName(worker.getFirstName());
        updatedWorker.setLastName(worker.getLastName());
        updatedWorker.setEmail(worker.getEmail());
        updatedWorker.setPhoneNumber(worker.getPhoneNumber());
        updatedWorker.setAge(worker.getAge());
        updatedWorker.setCustomer(worker.getCustomer());

        workerRepository.save(updatedWorker);

        return updatedWorker;
    }

    @Override
    public Worker deleteWorker(Long id) {
        Worker workerToDelete = workerRepository.findById(id).get();

        workerRepository.deleteById(workerToDelete.getId());

        return workerToDelete;
    }
}
