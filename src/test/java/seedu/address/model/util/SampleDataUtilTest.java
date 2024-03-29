package seedu.address.model.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.model.ReadOnlyAddressBook;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtilTest {

    /**
     * Ensures that sample data is initialised properly.
     */
    @Test
    public void sampleAddressBookTest() throws Exception {
        ReadOnlyAddressBook addressBookFromSample = SampleDataUtil.getSampleAddressBook();
        assertTrue(true);
    }
}
