package ir.ssatari.envers.service;

import ir.ssatari.envers.dal.entity.CustomerHistoryEntity;
import ir.ssatari.envers.dal.repository.history.CustomerHistoryRepository;
import ir.ssatari.envers.exceptions.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerHistoryService {

    private final CustomerHistoryRepository customerHistoryRepository;

    public List<CustomerHistoryEntity> getHistory(String id) {
        List<CustomerHistoryEntity> history = customerHistoryRepository.listCustomerRevisions(Long.valueOf(id));
        if (history.isEmpty()) {
            throw new EntityNotFoundException(CustomerHistoryEntity.class);
        }
        return history;
    }
}
