package ir.ssatari.envers.service;

import ir.ssatari.envers.dal.entity.CustomerEntity;
import ir.ssatari.envers.dal.repository.CustomerRepository;
import ir.ssatari.envers.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<CustomerEntity> getCustomers() {
        List<CustomerEntity> foundCustomers = customerRepository.findAll();
        if (foundCustomers.isEmpty()) {
            throw new EntityNotFoundException(CustomerEntity.class);
        }
        return foundCustomers;
    }

    public CustomerEntity getCustomer(String id) {
        return customerRepository
                .findById(Long.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException(CustomerEntity.class, "id", id));
    }
}
