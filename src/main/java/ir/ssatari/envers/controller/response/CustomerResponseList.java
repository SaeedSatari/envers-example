package ir.ssatari.envers.controller.response;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
public class CustomerResponseList {
	@ApiModelProperty(notes = "list all customers")
	private List<CustomerResponse> customerResponses;
}
