package ir.ssatari.envers.exceptions;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class EntityExistsException extends RuntimeException {
    public EntityExistsException(Class clazz, String... searchParamsMap) {
        super(
                EntityExistsException.generateMessage(
                        clazz.getSimpleName(),
                        toMap(searchParamsMap)
                )
        );
    }

    private static String generateMessage(String entity, Map<String, String> searchParams) {
        return (
                StringUtils.capitalize(entity) + " already exist " + searchParams
        );
    }

    private static <K, V> Map<K, V> toMap(
            Object... entries
    ) {
        if (entries.length % 2 == 1) throw new IllegalArgumentException("Invalid entries");
        return IntStream
                .range(0, entries.length / 2)
                .map(i -> i * 2)
                .collect(
                        HashMap::new,
                        (m, i) -> m.put(((Class<K>) String.class).cast(entries[i]), ((Class<V>) String.class).cast(entries[i + 1])),
                        Map::putAll
                );
    }
}