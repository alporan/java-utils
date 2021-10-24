package collection;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class CollectionUtils {

	private CollectionUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Set<Object> seen = ConcurrentHashMap.newKeySet();
		return t -> seen.add(keyExtractor.apply(t));
	}

	public static <E> Set<E> removeDuplicates(Collection<E> collection) {
		return new LinkedHashSet<>(collection);
	}
}
