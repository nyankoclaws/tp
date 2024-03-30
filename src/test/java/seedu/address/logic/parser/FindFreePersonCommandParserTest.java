package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindFreePersonCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.PersonIsFreePredicate;

public class FindFreePersonCommandParserTest {
    private static final FindFreePersonCommandParser parser = new FindFreePersonCommandParser();
    @Test
    public void parse_nullArgs_throwNullPointerException() {
        assertThrows(NullPointerException.class, () -> parser.parse(null));
    }
    @Test
    public void parse_emptyArgs_failure() {
        assertThrows(ParseException.class, () -> parser.parse(""));
    }

    @Test
    public void parse_invalidArgs_failure() {
        assertParseFailure(parser, "Mon:0700-0900", String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, FindFreePersonCommand.MESSAGE_USAGE));
        assertParseFailure(parser, "random", String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, FindFreePersonCommand.MESSAGE_USAGE));
        assertParseFailure(parser, "Ton:0700", String.format(
                MESSAGE_INVALID_COMMAND_FORMAT, FindFreePersonCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_success() {
        FindFreePersonCommand expected = new FindFreePersonCommand(new PersonIsFreePredicate("Mon:0700"));
        assertParseSuccess(parser, "Mon:0700", expected);
    }
}
