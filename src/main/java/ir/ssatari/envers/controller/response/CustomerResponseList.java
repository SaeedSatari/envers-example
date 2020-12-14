package ir.ssatari.envers.controller.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CustomerResponseList {
    @ApiModelProperty(notes = "list all customers")
    private List<CustomerResponse> customerResponses;
}
