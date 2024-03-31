package seedu.address.model.tag;

import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Dorm Tag in Dormie.
 */
public class DormTag extends Tag {

    public static final String MESSAGE_CONSTRAINTS = "Dorm Tag should be a non-empty string";
    public static final String VALIDATION_REGEX = "^(?!\\s*$).+";

    /**
     * Constructs a {@code DormTag}.
     *
     * @param tagName A valid tag name.
     */
    public DormTag(String tagName) {
        super(tagName);
        checkArgument(isValidTagName(tagName), MESSAGE_CONSTRAINTS);
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidTagName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Tag)) {
            return false;
        }

        Tag otherTag = (Tag) other;
        return tagName.equals(otherTag.tagName);
    }

    public int hashCode() {
        return tagName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + tagName + ']';
    }
}
