package ir.ssatari.envers.dal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.envers.RevisionType;

@AllArgsConstructor
@Getter
public class CustomerHistoryEntity {
	private final CustomerEntity customer;
	private final Number revision;
	private final RevisionType revisionType;
}
