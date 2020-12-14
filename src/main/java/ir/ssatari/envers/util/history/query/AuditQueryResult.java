package ir.ssatari.envers.util.history.query;

import ir.ssatari.envers.util.history.model.CustomRevisionEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.envers.RevisionType;

@Getter
@AllArgsConstructor
public class AuditQueryResult<T> {

    private final T entity;
    private final CustomRevisionEntity revision;
    private final RevisionType type;
}
