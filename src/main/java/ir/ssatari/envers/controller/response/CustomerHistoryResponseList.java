package ir.ssatari.envers.controller.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CustomerHistoryResponseList {
    @ApiModelProperty(notes = "list all the histories of a specific customer")
    List<CustomerHistoryResponse> customerHistoryResponses;
}
