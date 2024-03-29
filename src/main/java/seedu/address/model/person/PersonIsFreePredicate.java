package seedu.address.model.person;

import java.util.function.Predicate;

/**
 * Tests that a {@code Person}'s {@code FreeTimeTag} contains the current time.
 */
public class PersonIsFreePredicate implements Predicate<Person> {
    private final String currentTime;
    public PersonIsFreePredicate(String currentTime) {
        this.currentTime = currentTime;
    }

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param person the input argument
     * @return {@code true} if the input argument matches the predicate, otherwise {@code false}
     */
    @Override
    public boolean test(Person person) {
        return person.getTags().stream().anyMatch(
                tag -> tag.isContained(this.currentTime)
        );
    }
}
