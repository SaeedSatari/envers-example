package ir.ssatari.envers.service;

import ir.ssatari.envers.dal.entity.CustomerEntity;
import ir.ssatari.envers.dal.repository.CustomerRepository;
import ir.ssatari.envers.exceptions.EntityExistsException;
import ir.ssatari.envers.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public CustomerEntity saveNewCustomer(CustomerEntity customerEntity) {
        Optional<CustomerEntity> optionalCustomer = customerRepository.findByFirstNameAndLastName(customerEntity.getFirstName(), customerEntity.getLastName());
        if (optionalCustomer.isPresent())
            throw new EntityExistsException(CustomerEntity.class, "customer", customerEntity.getFirstName() + " " + customerEntity.getLastName());
        return customerRepository.save(customerEntity);
    }

    public void deleteCustomer(String id) {
        CustomerEntity customerEntity = customerRepository
                .findById(Long.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException(CustomerEntity.class, "id", id));
        customerRepository.delete(customerEntity);
    }
}
