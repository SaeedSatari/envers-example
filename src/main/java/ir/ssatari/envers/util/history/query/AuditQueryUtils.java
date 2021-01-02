package ir.ssatari.envers.util.history.query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;
import org.hibernate.envers.query.AuditQuery;

@NoArgsConstructor
public class AuditQueryUtils {

	public static <TTargetType> List<AuditQueryResult<TTargetType>> getAuditQueryResults(
		AuditQuery query,
		Class<TTargetType> targetType
	) {
		List<?> results = query.getResultList();

		if (results == null) {
			return new ArrayList<>();
		}

		// The AuditReader returns a List of Object[], where the indices are:
		//
		// 0 - The queried entity
		// 1 - The revision entity
		// 2 - The Revision Type
		//
		// We cast it into something useful for a safe access:
		return results
			.stream()
			.filter(x -> x instanceof Object[])
			.map(x -> (Object[]) x)
			.map(x -> AuditQueryResultUtils.getAuditQueryResult(x, targetType))
			.collect(Collectors.toList());
	}
}
