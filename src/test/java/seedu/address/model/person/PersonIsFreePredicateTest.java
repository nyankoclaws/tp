package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PersonIsFreePredicateTest {
    @Test
    public void equals() {
        PersonIsFreePredicate firstPredicate = new PersonIsFreePredicate("free");
        PersonIsFreePredicate secondPredicate = new PersonIsFreePredicate("busy");

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        PersonIsFreePredicate firstPredicateCopy = new PersonIsFreePredicate("free");
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertTrue(!firstPredicate.equals(1));

        // null -> returns false
        assertTrue(!firstPredicate.equals(null));

        // different predicate
        assertTrue(!firstPredicate.equals(secondPredicate));
    }
}
