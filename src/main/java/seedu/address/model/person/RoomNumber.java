package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a Person's room number in the logbook.
 * Guarantees: immutable; is valid as declared in
 * {@link #isValidRoomNumber(String)}
 */
public class RoomNumber {

    public static final String MESSAGE_CONSTRAINTS = "Room numbers should be in the format: "
            + "{block}-{floor}-{room number}";
    public static final String MESSAGE_CONSTRAINTS_DATE = "Dates for last modified should be in the format: "
            + "yyyy-mm-dd";
    public static final String MESSAGE_CONSTRAINTS_DATE_BEFORE = "Dates last modified should after today";

    /*
     * The first character of the room number must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "(\\w{2,})-(\\w{2})-(\\w{2,})";
    public static final String VALIDATION_REGEX_W_DATE = "(\\w{2,})-(\\w{2})-(\\w{2,}) (\\d{4}-\\d{2}-\\d{2})";

    // Ignore the year, it will be updated
    private static final LocalDate FIRST_RESULT_RELEASE = LocalDate.parse("2020-04-05");
    private static final LocalDate LAST_RESULT_RELEASE = LocalDate.parse("2020-04-12");

    private final String block;
    private final String floor;
    private final String roomNumber;
    private final LocalDate lastModified;

    /**
     * Constructs an {@code RoomNumber}.
     *
     * @param roomNumber A valid room number.
     */
    public RoomNumber(String roomNumber) {
        this(roomNumber, LocalDate.now());
    }

    /**
     * Constructs an {@code RoomNumber}.
     *
     * @param roomNumber A valid room number.
     * @param lastModified A valid room number.
     */
    public RoomNumber(String roomNumber, LocalDate lastModified) {
        requireNonNull(roomNumber);
        checkArgument(isValidRoomNumber(roomNumber), MESSAGE_CONSTRAINTS);
        Matcher matcher = Pattern.compile(VALIDATION_REGEX).matcher(roomNumber);
        matcher.find();
        this.block = matcher.group(1);
        this.floor = matcher.group(2);
        this.roomNumber = matcher.group(3);
        this.lastModified = lastModified;
    }

    /**
     * Constructs an {@code RoomNumber}.
     *
     * @param roomNumber A valid room number.
     * @param flag Indicator to process date from roomNumber.
     */
    public RoomNumber(String roomNumber, boolean flag) {
        requireNonNull(roomNumber);
        checkArgument(isValidRoomNumberWDate(roomNumber), MESSAGE_CONSTRAINTS_DATE);
        Matcher matcher = Pattern.compile(VALIDATION_REGEX_W_DATE).matcher(roomNumber);
        matcher.find();
        LocalDate date = LocalDate.parse(matcher.group(4));
        checkArgument(isValidDate(date), MESSAGE_CONSTRAINTS_DATE);
        this.block = matcher.group(1);
        this.floor = matcher.group(2);
        this.roomNumber = matcher.group(3);
        this.lastModified = date;
    }

    /**
     * Returns true if a given string is a valid room number.
     */
    public static boolean isValidRoomNumber(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns true if a given string is a valid room number with date.
     */
    public static boolean isValidRoomNumberWDate(String test) {
        return test.matches(VALIDATION_REGEX_W_DATE);
    }

    /**
     * Returns true if a given date is before today.
     */
    public static boolean isValidDate(LocalDate test) {
        return !test.isAfter(LocalDate.now());
    }

    /**
     * Returns true when RoomNumber is due for an udpdate.
     */
    public boolean isOutdated() {
        return isOutdated(lastModified);
    }

    /**
     * Returns true when RoomNumber is due for an udpdate.
     */
    protected static boolean isOutdated(LocalDate date) {
        LocalDate lastRelease = LAST_RESULT_RELEASE;
        lastRelease = lastRelease.withYear(LocalDate.now().getYear());
        if (lastRelease.isAfter(LocalDate.now())) {
            lastRelease = lastRelease.minusYears(1);
        }

        if (!date.isBefore(lastRelease)) {
            return false;
        }

        LocalDate firstRelease = FIRST_RESULT_RELEASE;
        firstRelease = firstRelease.withYear(LocalDate.now().getYear());
        if (firstRelease.isAfter(LocalDate.now())) {
            firstRelease = firstRelease.minusYears(1);
        }

        if (!date.isBefore(firstRelease)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return block + "-" + floor + "-" + roomNumber;
    }

    public String toStringWDate() {
        return block + "-" + floor + "-" + roomNumber + " " + lastModified.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RoomNumber)) {
            return false;
        }

        RoomNumber otherRoomNumber = (RoomNumber) other;
        return toString().equals(otherRoomNumber.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

}
