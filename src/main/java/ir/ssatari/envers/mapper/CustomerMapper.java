package ir.ssatari.envers.mapper;

import ir.ssatari.envers.controller.response.CustomerResponse;
import ir.ssatari.envers.dal.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "firstName", source = "source.firstName")
    @Mapping(target = "lastName", source = "source.lastName")
    CustomerResponse customerEntityToCustomerResponse(CustomerEntity source);
}
