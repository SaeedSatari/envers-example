package ir.ssatari.envers.controller.response;

import lombok.Data;

import java.util.List;

@Data
public class CustomerResponseList {
    private List<CustomerResponse> customerResponses;
}
