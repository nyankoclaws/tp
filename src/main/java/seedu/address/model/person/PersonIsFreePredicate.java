package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Person}'s {@code FreeTimeTag} contains the current time.
 */
public class PersonIsFreePredicate implements Predicate<Person> {
    private final String currentTime;

    /**
     * Constructs a {@code PersonIsFreePredicate}.
     * @param currentTime the current time.
     */
    public PersonIsFreePredicate(String currentTime) {
        requireNonNull(currentTime);
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
        requireNonNull(person);
        return person.getTags().stream().anyMatch(
                tag -> tag.isContained(this.currentTime)
        );
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PersonIsFreePredicate)) {
            return false;
        }
        PersonIsFreePredicate otherPredicate = (PersonIsFreePredicate) other;
        return currentTime.equals(otherPredicate.currentTime);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("current time", currentTime)
                .toString();
    }
}
