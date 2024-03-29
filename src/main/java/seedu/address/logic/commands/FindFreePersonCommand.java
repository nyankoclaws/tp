package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.person.PersonIsFreePredicate;

/**
 * Finds and lists all persons in address book who are free at the specified time.
 */
public class FindFreePersonCommand extends FindCommand {
    public static final String INPUT_PATTERN = "^(Mon|Tue|Wed|Thu|Fri|Sat|Sun):(0[0-9]|1[0-9]|2[0-3])([0-5][0-9])$";
    public static final String COMMAND_WORD = "whoisfree";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons who are free given by "
            + "the specified timestamp (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " Mon:1000-1200";

    /**
     * Creates a FindFreePersonCommand to find the specified {@code PersonIsFreePredicate}
     * @param predicate the predicate to find free persons
     */
    public FindFreePersonCommand(PersonIsFreePredicate predicate) {
        super(predicate);
        requireNonNull(predicate);
    }
}
