package ir.ssatari.envers.controller.response;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
public class CustomerHistoryResponseList {
	@ApiModelProperty(notes = "list all the histories of a specific customer")
	List<CustomerHistoryResponse> customerHistoryResponses;
}
