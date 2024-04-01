package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.person.NameContainsKeywordsPredicate;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindByNameCommand extends FindCommand {
    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons whose names contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";

    /**
     * Constructs a FindByNameCommand with the specified predicate.
     * @param predicate The predicate to test against.
     */
    public FindByNameCommand(NameContainsKeywordsPredicate predicate) {
        super(predicate);
        requireNonNull(predicate);
    }
}
