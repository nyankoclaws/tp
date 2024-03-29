package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.FindFreePersonCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.PersonIsFreePredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindFreePersonCommandParser extends FindCommandParser {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns a FindCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindFreePersonCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty() || !trimmedArgs.matches(FindFreePersonCommand.INPUT_PATTERN)) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindFreePersonCommand.MESSAGE_USAGE));
        }
        return new FindFreePersonCommand(new PersonIsFreePredicate(trimmedArgs));
    }

}
