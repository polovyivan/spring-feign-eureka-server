package com.polovyi.ivan.client;

import com.polovyi.ivan.dto.CreateCustomerRequest;
import com.polovyi.ivan.dto.CustomerResponse;
import com.polovyi.ivan.dto.UpdateCustomerRequest;
import feign.Response;
import java.time.LocalDate;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "customer-service")
public interface CustomerAPIClient {

    @RequestMapping(value = "/customer-app/v1/customers", method = RequestMethod.GET)
    List<CustomerResponse> getCustomersWithFilters(@RequestParam String fullName,
            @RequestParam String phoneNumber,
            @RequestParam LocalDate createdAt);

    @PostMapping("/customer-app/v1/customers")
    Response createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest);

    @GetMapping(path = "/customer-app/v1/{customerId}")
    CustomerResponse getCustomerById(@PathVariable String customerId);

    @PutMapping(path = "/customer-app/v1/{customerId}")
    void updateCustomer(@PathVariable String customerId, @RequestBody UpdateCustomerRequest updateCustomerRequest);

    @DeleteMapping(path = "/customer-app/v1/{customerId}")
    void deleteCustomer(@PathVariable String customerId);

}
