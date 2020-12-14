package ir.ssatari.envers.controller;

import io.swagger.annotations.ApiOperation;
import ir.ssatari.envers.controller.request.CustomerRequest;
import ir.ssatari.envers.controller.response.CustomerResponse;
import ir.ssatari.envers.controller.response.CustomerResponseList;
import ir.ssatari.envers.dal.entity.CustomerEntity;
import ir.ssatari.envers.mapper.CustomerMapper;
import ir.ssatari.envers.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
@CrossOrigin
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @ApiOperation(value = "get list of existing customers", nickname = "get-customer-list")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponseList getCustomerList() {
        log.info("going to get list of the customers");
        CustomerResponseList customerResponseList = new CustomerResponseList();
        List<CustomerEntity> customers = customerService.getCustomers();
        customerResponseList.setCustomerResponses(customers.stream().map(CustomerMapper.MAPPER::customerEntityToCustomerResponse).collect(Collectors.toList()));
        return customerResponseList;
    }

    @ApiOperation(value = "get customer using given id", nickname = "get-customer")
    @GetMapping(path = "/id")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getCustomer(@PathParam("id") String id) {
        log.info("going to get customer with given id {}", id);
        CustomerEntity customer = customerService.getCustomer(id);
        return CustomerMapper.MAPPER.customerEntityToCustomerResponse(customer);
    }

    @ApiOperation(value = "save a new customer", nickname = "save-new-customer")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse saveNewCustomer(@RequestBody CustomerRequest customerRequest) {
        log.info("going to save a new customer with given request {}", customerRequest);
        CustomerEntity customerEntity = customerService.saveNewCustomer(CustomerMapper.MAPPER.customerRequestToCustomerEntity(customerRequest));
        return CustomerMapper.MAPPER.customerEntityToCustomerResponse(customerEntity);
    }

    @ApiOperation(value = "delete customer using given id", nickname = "delete-customer")
    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathParam("id") String id) {
        log.info("going to delete customer with given id {}", id);
        customerService.deleteCustomer(id);
        log.info("deleting customer with given id finished successfully {}", id);
    }
}
