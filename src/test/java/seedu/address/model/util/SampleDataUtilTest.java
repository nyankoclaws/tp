package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.testutil.TypicalPersons;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtilTest {

    @Test
    public void sampleAddressBookTest() throws Exception {
        ReadOnlyAddressBook addressBookFromSample = SampleDataUtil.getSampleAddressBook();
        ReadOnlyAddressBook typicalPersonsAddressBook =
                (ReadOnlyAddressBook) TypicalPersons.getTypicalAddressBook();
        assertEquals(addressBookFromSample, typicalPersonsAddressBook);
    }
}
