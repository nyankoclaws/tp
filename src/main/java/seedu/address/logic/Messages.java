package seedu.address.logic;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.person.Person;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_WELCOME =
            "Welcome to Dormie!\n"
                    + "The available commands are as follows: add, addTime, clear, delete, deleteTime, edit, exit, "
                    + "find, help, list, whoisfree.\n"
                    + "Refer to the help guide (link can be found above) for more details.";
    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_NO_FREETIME_SPECIFIED = "Please specify a free time.";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
            "Multiple values specified for the following single-valued field(s): ";
    public static final String MESSAGE_NO_MATCHING_FREE_TIME =
            "No matching free time to be deleted for the chosen person.";
    public static final String MESSAGE_NO_NEW_FREE_TIME =
            "No new free time to be added for the chosen person.";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return MESSAGE_DUPLICATE_FIELDS + String.join(" ", duplicateFields);
    }

    /**
     * Formats the {@code person} for display to the user.
     */
    public static String format(Person person) {
        final StringBuilder builder = new StringBuilder();
        builder.append(person.getName())
                .append("; Phone: ")
                .append(person.getPhone());

        formatHelper(builder, "; Email: ", person.getEmail());
        formatHelper(builder, "; Room Number: ", person.getRoomNumber());
        formatHelper(builder, "; Telegram: ", person.getTelegram());
        formatHelper(builder, "; Birthday: ", person.getBirthday());
        formatHelper(builder, "; Dorm Tag: ", person.getDormTag());

        if (!person.getTags().isEmpty()) {
            builder.append("; Free Time Tags: ");
            person.getTags().forEach(builder::append);
        }

        return builder.toString();
    }

    private static void formatHelper(StringBuilder builder, String prependString, Object field) {
        if (field != null) {
            builder.append(prependString).append(field);
        }
    }

}
