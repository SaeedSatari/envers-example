package ir.ssatari.envers.dal.repository.history;

import ir.ssatari.envers.dal.entity.CustomerEntity;
import ir.ssatari.envers.dal.entity.CustomerHistoryEntity;
import ir.ssatari.envers.util.history.query.AuditQueryResult;
import ir.ssatari.envers.util.history.query.AuditQueryUtils;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerHistoryRepositoryImpl implements CustomerHistoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<CustomerHistoryEntity> listCustomerRevisions(Long customerId) {

        /**
         * Create the audit reader. It uses the EntityManager, which will be opened when starting
         * the new transaction and closed when the transaction finishes.
         */
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        AuditQuery auditQuery = auditReader.createQuery()
                .forRevisionsOfEntity(CustomerEntity.class, false, true)
                .add(AuditEntity.id().eq(customerId));

        /**
         * We don't operate on the untyped Results, but cast them into a List of AuditQueryResult
         */
        return AuditQueryUtils.getAuditQueryResults(auditQuery, CustomerEntity.class).stream()
                .map(CustomerHistoryRepositoryImpl::getCustomerHistory)
                .collect(Collectors.toList());
    }

    private static CustomerHistoryEntity getCustomerHistory(AuditQueryResult<CustomerEntity> auditQueryResult) {
        return new CustomerHistoryEntity(
                auditQueryResult.getEntity(),
                auditQueryResult.getRevision().getRevisionNumber(),
                auditQueryResult.getType()
        );
    }
}
