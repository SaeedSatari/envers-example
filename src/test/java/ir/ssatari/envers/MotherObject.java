package ir.ssatari.envers;

import ir.ssatari.envers.controller.response.CustomerResponse;
import ir.ssatari.envers.controller.response.CustomerResponseList;
import ir.ssatari.envers.dal.entity.CustomerEntity;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MotherObject {

	public static CustomerEntity anyCustomerEntity() {
		CustomerEntity customer = new CustomerEntity();
		customer.setFirstName("Saeed");
		customer.setLastName("Sattari");
		customer.setCreatedAt(new Date());
		customer.setCreatedBy("Dummy Creator");
		customer.setLastModifiedAt(new Date());
		customer.setLastModifiedBy("Dummy Modifier");
		return customer;
	}

	public static List<CustomerEntity> anyCustomerEntityList() {
		return Collections.singletonList(anyCustomerEntity());
	}

	public static CustomerResponse anyCustomerResponse() {
		CustomerResponse response = new CustomerResponse();
		response.setFirstName("Saeed");
		response.setLastName("Sattari");
		return response;
	}
}
