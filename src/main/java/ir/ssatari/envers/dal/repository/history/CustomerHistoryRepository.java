package ir.ssatari.envers.dal.repository.history;

import ir.ssatari.envers.dal.entity.CustomerHistoryEntity;

import java.util.List;

public interface CustomerHistoryRepository {
    List<CustomerHistoryEntity> listCustomerRevisions(Long customerId);
}
