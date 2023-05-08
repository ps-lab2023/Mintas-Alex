package com.projectsd.services.service.implementation;

import com.projectsd.services.model.Worker;
import com.projectsd.services.repository.WorkerRepository;
import com.projectsd.services.service.IWorkerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static java.lang.Boolean.TRUE;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class WorkerService implements IWorkerService {
    @Autowired
    private WorkerRepository workerRepository;

/*    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }*/

    @Override
    public Worker createWorker(Worker worker) {
        log.info("Saving new worker: {}", worker.getEmail());
        return workerRepository.save(worker);
    }

    @Override
    public Collection<Worker> getWorkers(int limit) {
        log.info("Fetching all workers");
        return workerRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Worker findWorkerById(Long id) {
        log.info("Fetching worker by id: {}", id);
        return workerRepository.findById(id).get();
    }


    @Override
    public Worker updateWorker(Worker worker) {
        log.info("Updating worker: {}", worker.getEmail());
/*        Worker updatedWorker = workerRepository.findById(worker.getId()).get();

        updatedWorker.setFirstName(worker.getFirstName());
        updatedWorker.setLastName(worker.getLastName());
        updatedWorker.setEmail(worker.getEmail());
        updatedWorker.setPhoneNumber(worker.getPhoneNumber());
        updatedWorker.setAge(worker.getAge());
        updatedWorker.setCustomer(worker.getCustomer());

        workerRepository.save(updatedWorker);*/

        return workerRepository.save(worker);
    }

    @Override
    public Boolean deleteWorker(Long id) {
        log.info("Deleting worker by ID: {}", id);
/*        Worker workerToDelete = workerRepository.findById(id).get();

        workerRepository.deleteById(workerToDelete.getId());

        return workerToDelete;*/
        workerRepository.deleteById(id);
        return TRUE;
    }
}
