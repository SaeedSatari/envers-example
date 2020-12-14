package ir.ssatari.envers.controller;

import ir.ssatari.envers.controller.request.CustomerRequest;
import ir.ssatari.envers.controller.response.CustomerResponse;
import ir.ssatari.envers.controller.response.CustomerResponseList;
import ir.ssatari.envers.dal.entity.CustomerEntity;
import ir.ssatari.envers.mapper.CustomerMapper;
import ir.ssatari.envers.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
@CrossOrigin
public class CustomerResource {

    private final CustomerService customerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponseList getCustomerList() {
        CustomerResponseList customerResponseList = new CustomerResponseList();
        List<CustomerEntity> customers = customerService.getCustomers();
        customerResponseList.setCustomerResponses(customers.stream().map(CustomerMapper.MAPPER::customerEntityToCustomerResponse).collect(Collectors.toList()));
        return customerResponseList;
    }

    @GetMapping(path = "/id", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse getCustomer(@PathParam("id") String id) {
        CustomerEntity customer = customerService.getCustomer(id);
        return CustomerMapper.MAPPER.customerEntityToCustomerResponse(customer);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponse saveNewCustomer(CustomerRequest customerRequest) {
        return null;
    }

    @DeleteMapping("/id")
    public void deleteCustomer(@PathParam("id") Long id) {
    }
}
