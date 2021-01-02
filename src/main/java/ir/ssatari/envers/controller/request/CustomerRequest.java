package ir.ssatari.envers.controller.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CustomerRequest {
	@ApiModelProperty(example = "Saeed", required = true)
	@NotBlank(message = "First name can not be empty")
	private String firstName;

	@ApiModelProperty(example = "Sattari", required = true)
	@NotBlank(message = "Last name can not be empty")
	private String lastName;
}
