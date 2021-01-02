package ir.ssatari.envers.mapper;

import ir.ssatari.envers.controller.response.CustomerResponse;
import ir.ssatari.envers.dal.entity.CustomerEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static ir.ssatari.envers.MotherObject.anyCustomerEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class CustomerMapperTest {

    CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);

    @Test
    @DisplayName("map customerEntity to customerResponse")
    void customerEntityToCustomerResponse() {
        CustomerEntity customerEntity = anyCustomerEntity();
        CustomerResponse customerResponse = customerMapper.customerEntityToCustomerResponse(customerEntity);
        assertEquals(customerEntity.getFirstName(), customerResponse.getFirstName());
        assertEquals(customerEntity.getLastName(), customerResponse.getLastName());
    }


    @Test
    void customerRequestToCustomerEntity() {
    }

    @Test
    void customerHistoryEntityToCustomerHistoryResponse() {
    }
}