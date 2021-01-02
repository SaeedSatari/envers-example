package ir.ssatari.envers.controller.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerResponse {
    @ApiModelProperty(example = "Saeed")
    private String firstName;
    @ApiModelProperty(example = "Sattari")
    private String lastName;
}
