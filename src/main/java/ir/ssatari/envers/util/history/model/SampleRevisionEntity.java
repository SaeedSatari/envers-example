package ir.ssatari.envers.util.history.model;

import java.text.DateFormat;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.envers.RevisionEntity;

@Entity
@RevisionEntity
@Table(name = "revinfo")
public class SampleRevisionEntity extends CustomRevisionEntity {

	public SampleRevisionEntity() {}

	public String toString() {
		return (
			"SampleRevisionEntity(revisionNumber = " +
			getRevisionNumber() +
			", revisionDate = " +
			DateFormat.getDateTimeInstance().format(this.getRevisionDate()) +
			")"
		);
	}
}
