package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FreeTimeTagTest {
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
}
