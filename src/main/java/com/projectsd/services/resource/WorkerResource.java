package com.projectsd.services.resource;

import com.projectsd.services.model.Response;
import com.projectsd.services.model.Worker;
import com.projectsd.services.service.implementation.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerResource {
    private final WorkerService workerService;

    @GetMapping("/getWorkers")
    public ResponseEntity<Response> getWorkers() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("workers", workerService.getWorkers(30)))
                        .message("Workers retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/saveWorker")
    public ResponseEntity<Response> saveWorker(@RequestBody @Valid Worker worker) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("worker", workerService.createWorker(worker)))
                        .message("Worker created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/findWorkerByID/{id}")
    public ResponseEntity<Response> getWorker(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("worker", workerService.findWorkerById(id)))
                        .message("Worker retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/deleteWorker/{id}")
    public ResponseEntity<Response> deleteWorker(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", workerService.deleteWorker(id)))
                        .message("Worker deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
