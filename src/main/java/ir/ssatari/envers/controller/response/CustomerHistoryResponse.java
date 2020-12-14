package ir.ssatari.envers.controller.response;

import lombok.Data;

@Data
public class CustomerHistoryResponse {
    private final CustomerResponse customer;
    private final Number revision;
    private final RevisionType type;
}
