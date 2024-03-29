package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindFreePersonCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.PersonIsFreePredicate;

public class FindFreePersonCommandParserTest {
    @Test
    public void parse_emptyArgs_failure() {
        assertThrows(ParseException.class, () -> new FindFreePersonCommandParser().parse(""));
    }

    @Test
    public void parse_invalidArgs_failure() {
        assertThrows(ParseException.class, () ->
                new FindFreePersonCommandParser().parse("Mon:0700-0900"));
        assertThrows(ParseException.class, () ->
                new FindFreePersonCommandParser().parse("random"));
        assertThrows(ParseException.class, () ->
                new FindFreePersonCommandParser().parse("Ton:0700"));
    }

    @Test
    public void parse_validArgs_success() {
        FindFreePersonCommand expected = new FindFreePersonCommand(new PersonIsFreePredicate("Mon:0700"));
        try {
            assertTrue(expected.equals(new FindFreePersonCommandParser().parse("Mon:0700")));
        } catch (ParseException e) {
            fail();
        }
    }
}
