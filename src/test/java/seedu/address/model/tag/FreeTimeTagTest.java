package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FreeTimeTagTest {
    @Test
    public void isValidTimeInterval() {
        assertTrue(FreeTimeTag.isValidTimeInterval("Mon:0700-0900")); // Start > End
        assertFalse(FreeTimeTag.isValidTimeInterval("Mon:0700-0700")); // Start == End
        assertFalse(FreeTimeTag.isValidTimeInterval("Mon:0701-0700")); // Start < End
    }

    @Test
    public void isContained() {
        FreeTimeTag freeTimeTag = new FreeTimeTag("Mon:0700-0900");

        assertTrue(freeTimeTag.isContained("Mon:0700")); // On time
        assertTrue(freeTimeTag.isContained("Mon:0800")); // In between
        assertTrue(freeTimeTag.isContained("Mon:0900")); // On time

        assertFalse(freeTimeTag.isContained("Tue:0700")); // Different day
        assertFalse(freeTimeTag.isContained("Mon:0659")); // Earlier time
        assertFalse(freeTimeTag.isContained("Mon:0901")); // Later time
    }
    @Test
    public void equals() {
        FreeTimeTag freeTimeTag1 = new FreeTimeTag("Mon:0700-0900");
        FreeTimeTag freeTimeTag2 = new FreeTimeTag("Tue:0700-0900");

        // same object -> returns true
        assertTrue(freeTimeTag1.equals(freeTimeTag1));

        // same values -> returns true
        FreeTimeTag freeTimeTag1Copy = new FreeTimeTag("Mon:0700-0900");
        assertTrue(freeTimeTag1.equals(freeTimeTag1Copy));

        // different types -> returns false
        assertFalse(freeTimeTag1.equals(1));

        // null -> returns false
        assertFalse(freeTimeTag1.equals(null));

        // different object -> returns false
        assertFalse(freeTimeTag1.equals(freeTimeTag2));
    }


    @Test
    public void compareTo() {
        FreeTimeTag freeTimeTag1 = new FreeTimeTag("Mon:0700-0900");
        FreeTimeTag freeTimeTag2 = new FreeTimeTag("Tue:0700-0900");
        FreeTimeTag freeTimeTag3 = new FreeTimeTag("Wed:0700-0900");
        FreeTimeTag freeTimeTag4 = new FreeTimeTag("Thu:0700-0900");
        FreeTimeTag freeTimeTag5 = new FreeTimeTag("Fri:0700-0900");
        FreeTimeTag freeTimeTag6 = new FreeTimeTag("Sat:0700-0900");
        FreeTimeTag freeTimeTag7 = new FreeTimeTag("Sun:0700-0900");
        FreeTimeTag freeTimeTag8 = new FreeTimeTag("Mon:0700-0901");
        FreeTimeTag freeTimeTag9 = new FreeTimeTag("Mon:0701-0900");

        // Compares all days for the same time
        assertTrue(freeTimeTag1.compareTo(freeTimeTag1) == 1);
        assertTrue(freeTimeTag2.compareTo(freeTimeTag2) == 1);
        assertTrue(freeTimeTag3.compareTo(freeTimeTag3) == 1);
        assertTrue(freeTimeTag4.compareTo(freeTimeTag4) == 1);
        assertTrue(freeTimeTag5.compareTo(freeTimeTag5) == 1);
        assertTrue(freeTimeTag6.compareTo(freeTimeTag6) == 1);
        assertTrue(freeTimeTag7.compareTo(freeTimeTag7) == 1);

        // Compares different days
        assertTrue(freeTimeTag1.compareTo(freeTimeTag2) == -1);
        assertTrue(freeTimeTag2.compareTo(freeTimeTag1) == 1);

        // Compares different start and end timings
        assertTrue(freeTimeTag1.compareTo(freeTimeTag8) == -1);
        assertTrue(freeTimeTag8.compareTo(freeTimeTag1) == 1);
        assertTrue(freeTimeTag1.compareTo(freeTimeTag9) == -1);
        assertTrue(freeTimeTag9.compareTo(freeTimeTag1) == 1);
        assertTrue(freeTimeTag8.compareTo(freeTimeTag9) == -1);
        assertTrue(freeTimeTag9.compareTo(freeTimeTag8) == 1);
    }
}
