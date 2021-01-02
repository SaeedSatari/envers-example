package ir.ssatari.envers.util.history.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@MappedSuperclass
@NoArgsConstructor
@Getter
public class CustomRevisionEntity implements Serializable {
	private static final long serialVersionUID = 8530213963961662300L;

	@Id
	@RevisionNumber
	@GeneratedValue
	@Column(name = "revision_number")
	private int revisionNumber;

	@RevisionTimestamp
	@Column(name = "revision_timestamp")
	private long revisionTimestamp;

	@Transient
	public Date getRevisionDate() {
		return new Date(this.revisionTimestamp);
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (!(o instanceof CustomRevisionEntity)) {
			return false;
		} else {
			CustomRevisionEntity that = (CustomRevisionEntity) o;
			return this.revisionNumber == that.revisionNumber && this.revisionTimestamp == that.revisionTimestamp;
		}
	}

	public int hashCode() {
		int result = this.revisionNumber;
		result = 31 * result + (int) (this.revisionTimestamp ^ this.revisionTimestamp >>> 32);
		return result;
	}

	public String toString() {
		return (
			"CustomRevisionEntity(revisionNumber = " +
			this.revisionNumber +
			", revisionDate = " +
			DateFormat.getDateTimeInstance().format(this.getRevisionDate()) +
			")"
		);
	}
}
