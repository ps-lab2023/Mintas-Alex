package com.projectsd.services.resource;

import com.projectsd.services.model.Customer;
import com.projectsd.services.model.Response;
import com.projectsd.services.service.implementation.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerResource {
    private final CustomerService customerService;

    @GetMapping("/getCustomers")
    public ResponseEntity<Response> getCustomers() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("customers", customerService.getCustomers(30)))
                        .message("Customers retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/saveCustomer")
    public ResponseEntity<Response> saveCustomer(@RequestBody @Valid Customer customer) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("customer", customerService.createCustomer(customer)))
                        .message("Customer created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/findCustomerByID/{id}")
    public ResponseEntity<Response> getCustomer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("customer", customerService.findCustomerById(id)))
                        .message("Customer retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<Response> deleteCustomer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", customerService.deleteCustomer(id)))
                        .message("Customer deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
