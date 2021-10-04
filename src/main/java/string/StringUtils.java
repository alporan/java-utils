package string;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class StringUtils {

	private StringUtils() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Changes the format of string represents a specific date format.
	 * <p>
	 *
	 * @param date          value to be formatted
	 * @param sourcePattern the pattern of {@code date} not null
	 * @param targetPattern the pattern to use, not null
	 * @return the formatted string based on the pattern, not null
	 * @throws IllegalArgumentException if either of the patterns is invalid
	 * @throws DateTimeParseException   if the text cannot be parsed
	 */
	public static String formatDate(String date, String sourcePattern, String targetPattern) throws IllegalArgumentException, DateTimeParseException {
		return formatDate(date, sourcePattern, targetPattern, Locale.getDefault(Locale.Category.FORMAT));
	}

	/**
	 * Changes the format of string represents a locale specific date format.
	 * <p>
	 *
	 * @param date          value to be formatted
	 * @param sourcePattern the pattern of {@code date} not null
	 * @param targetPattern the pattern to use, not null
	 * @param locale        the locale to use, not null
	 * @return the formatted string based on the pattern, not null
	 * @throws IllegalArgumentException if either of the patterns is invalid
	 * @throws DateTimeParseException   if the text cannot be parsed
	 */
	public static String formatDate(String date, String sourcePattern, String targetPattern, Locale locale) throws IllegalArgumentException, DateTimeParseException {
		DateTimeFormatter sourceFormatter = DateTimeFormatter.ofPattern(sourcePattern, locale);
		DateTimeFormatter targetFormatter = DateTimeFormatter.ofPattern(targetPattern, locale);
		return LocalDate.parse(date, sourceFormatter).format(targetFormatter);
	}
}