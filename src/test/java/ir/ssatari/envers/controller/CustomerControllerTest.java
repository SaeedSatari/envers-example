package ir.ssatari.envers.controller;

import static ir.ssatari.envers.MotherObject.anyCustomerEntity;
import static ir.ssatari.envers.MotherObject.anyCustomerEntityList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import ir.ssatari.envers.service.CustomerHistoryService;
import ir.ssatari.envers.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
	@Spy
	@InjectMocks
	CustomerController controller;

	@MockBean
	CustomerService customerService;

	@MockBean
	CustomerHistoryService historyService;

	@Autowired
	MockMvc mockMvc;

	@Test
	void getCustomerListSuccess() throws Exception {
		when(customerService.getCustomers()).thenReturn(anyCustomerEntityList());

		mockMvc
			.perform(MockMvcRequestBuilders.get("/api/customers").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().is2xxSuccessful());
	}

	@Test
	void getCustomerListClientError() throws Exception {
		mockMvc
			.perform(MockMvcRequestBuilders.get("/api/customer").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().is4xxClientError());
	}

	@Test
	void getCustomerSuccess() throws Exception {
		when(customerService.getCustomer(anyString())).thenReturn(anyCustomerEntity());

		mockMvc
			.perform(
				MockMvcRequestBuilders.get("/api/customers").param("id", "1").contentType(MediaType.APPLICATION_JSON)
			)
			.andExpect(status().is2xxSuccessful());
	}

	@Test
	void saveNewCustomer() {}

	@Test
	void deleteCustomer() {}

	@Test
	void getHistory() {}
}
