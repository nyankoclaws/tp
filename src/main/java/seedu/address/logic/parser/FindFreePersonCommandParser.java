package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.FindFreePersonCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.PersonIsFreePredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindFreePersonCommandParser extends FindCommandParser {
    @Override
    public FindFreePersonCommand parse(String args) throws ParseException {
        requireNonNull(args);
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty() || !trimmedArgs.matches(FindFreePersonCommand.INPUT_PATTERN)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindFreePersonCommand.MESSAGE_USAGE));
        }
        return new FindFreePersonCommand(new PersonIsFreePredicate(trimmedArgs));
    }

}
