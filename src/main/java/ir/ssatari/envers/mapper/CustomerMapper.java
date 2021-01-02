package ir.ssatari.envers.mapper;

import ir.ssatari.envers.controller.request.CustomerRequest;
import ir.ssatari.envers.controller.response.CustomerHistoryResponse;
import ir.ssatari.envers.controller.response.CustomerResponse;
import ir.ssatari.envers.dal.entity.CustomerEntity;
import ir.ssatari.envers.dal.entity.CustomerHistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

	@Mapping(target = "firstName", source = "source.firstName")
	@Mapping(target = "lastName", source = "source.lastName")
	CustomerResponse customerEntityToCustomerResponse(CustomerEntity source);

	@Mapping(target = "firstName", source = "source.firstName")
	@Mapping(target = "lastName", source = "lastName")
	CustomerEntity customerRequestToCustomerEntity(CustomerRequest source);

	@Mapping(target = "customer", source = "source.customer")
	@Mapping(target = "revision", source = "revision")
	@Mapping(target = "type", source = "revisionType")
	CustomerHistoryResponse customerHistoryEntityToCustomerHistoryResponse(CustomerHistoryEntity source);
}
