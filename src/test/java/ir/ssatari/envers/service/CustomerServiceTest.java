package ir.ssatari.envers.service;

import static ir.ssatari.envers.MotherObject.anyCustomerEntityList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

import ir.ssatari.envers.dal.entity.CustomerEntity;
import ir.ssatari.envers.dal.repository.CustomerRepository;
import ir.ssatari.envers.exceptions.EntityNotFoundException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class CustomerServiceTest {
	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	private CustomerService customerService;

	@Test
	@DisplayName("getCustomers, when there is a list of customers, should returns the list of the customers")
	void getCustomers_whenListOfCustomersIsExisting_shouldReturnsTheList() {
		List<CustomerEntity> customerList = anyCustomerEntityList();
		doReturn(customerList).when(customerRepository).findAll();
		List<CustomerEntity> persistedCustomerList = customerService.getCustomers();
		assertNotNull(persistedCustomerList);
		assertTrue(customerList.containsAll(persistedCustomerList) && persistedCustomerList.containsAll(customerList));
	}

	@Test
	@DisplayName("getCustomers, when there is not a list of customers, should throws new EntityNotFoundException")
	void getCustomers_whenListOfCustomersIsNotExisting_shouldThrowsNewException() {
		assertThrows(EntityNotFoundException.class, () -> customerService.getCustomers());
	}

	@Test
	void getCustomer() {}

	@Test
	void saveNewCustomer() {}

	@Test
	void deleteCustomer() {}
}
