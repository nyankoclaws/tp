package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a Person's Birthday in the address book.
 * Guarantees: immutable; is valid as declared in
 * {@link #isValidBirthday(String)}
 */
public class Birthday {

    public static final String MESSAGE_CONSTRAINTS = "Birthdays should consist of dates in certain formats. "
            + "Refer to help for more information";
    public static final String VALIDATION_REGEX = "\\d{3,}";
    private static final String[][] DATE_PATTERNS = {
            { "\\\\d{4}-\\\\d{1,2}-\\\\d{1,2}", "yyyy-M-d" },
            { "\\d{1,2}-\\d{1,2}-\\d{4}", "d-M-yyyy" },
            { "\\d{4}\\/\\d{2}\\/\\d{1,2}", "yyyy/M/d" },
            { "\\d{1,2}\\/\\d{1,2}\\/\\d{4}", "d/M/yyyy" },
            { "\\d{1,2}-\\[a-zA-Z]{3}-\\d{4}", "d-LLL-yyyy" },
            { "\\d{1,2}\\/\\[a-zA-Z]{3}\\/\\d{4}", "d/LLL/yyyy" },
            { "\\d{1,2} [a-zA-Z]{3} \\d{4}", "d LLL yyyy" },
    };
    public final LocalDate value;

    /**
     * Constructs a {@code Birthday}.
     *
     * @param birthday A valid birthday.
     */
    public Birthday(String birthday) {
        requireNonNull(birthday);
        LocalDate birthdayDate = getValidBirthday(birthday);
        checkArgument(birthdayDate != null, MESSAGE_CONSTRAINTS);
        value = birthdayDate;
    }

    /**
     * Returns true if a given string is a valid birthday.
     */
    public static LocalDate getValidBirthday(String test) {

        for (String[] datePattern : DATE_PATTERNS) {
            Pattern pattern = Pattern.compile(datePattern[0]);
            Matcher matcher = pattern.matcher(test);
            while (matcher.find()) {
                try {
                    String dateStr = matcher.group();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern[1]);
                    LocalDate date = LocalDate.from(formatter.parse(dateStr, new ParsePosition(0)));
                    return date;
                } catch (DateTimeParseException e) {
                    System.out.println(e);
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return value.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Birthday)) {
            return false;
        }

        Birthday otherBirthday = (Birthday) other;
        return value.equals(otherBirthday.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
