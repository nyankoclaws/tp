package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.DormTag;
import seedu.address.model.tag.FreeTimeTag;

/**
 * Represents a Person in the logbook.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {
    private static final Logger logger = LogsCenter.getLogger(Person.class);


    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final RoomNumber roomNumber;
    private final Telegram telegram;
    private final Birthday birthday;
    private final DormTag dormTag;
    private final Set<FreeTimeTag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, RoomNumber roomNumber, Telegram telegram, Birthday birthday,
                  DormTag dormTag, Set<FreeTimeTag> tags) {
        requireAllNonNull(name, phone, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.roomNumber = roomNumber;
        this.telegram = telegram;
        this.birthday = birthday;
        this.dormTag = dormTag;
        this.tags.addAll(tags);
    }

    public Name getName() {
        logger.log(Level.INFO, "Retrieved person's name");
        return name;
    }

    public Phone getPhone() {
        logger.log(Level.INFO, "Retrieved person's phone number");
        return phone;
    }

    public Email getEmail() {
        logger.log(Level.INFO, "Retrieved person's email");
        return email;
    }

    public RoomNumber getRoomNumber() {
        logger.log(Level.INFO, "Retrieved person's room number");
        return roomNumber;
    }

    public Telegram getTelegram() {
        logger.log(Level.INFO, "Retrieved person's telegram");
        return telegram;
    }

    public Birthday getBirthday() {
        logger.log(Level.INFO, "Retrieved person's birthday");
        return birthday;
    }

    public DormTag getDormTag() {
        return dormTag;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<FreeTimeTag> getTags() {
        logger.log(Level.INFO, "Retrieved person's free time tags");
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;

        boolean isEqual = name.equals(otherPerson.name)
                && phone.equals(otherPerson.phone)
                && equalsHelperForOptional(email, otherPerson.email)
                && equalsHelperForOptional(roomNumber, otherPerson.roomNumber)
                && equalsHelperForOptional(telegram, otherPerson.telegram)
                && equalsHelperForOptional(birthday, otherPerson.birthday)
                && equalsHelperForOptional(dormTag, otherPerson.dormTag)
                && tags.equals(otherPerson.tags);

        return isEqual;
    }

    /**
     * A private method to facilitate optional field comparison.
     * Returns true if and only if both objects that are compared are equal.
     *
     * The usage of Object as parameter type is to accommodate different types of field,
     * since Object class is the super class of any class.
     * To avoid unintended usage, both parameters are checked to be objects of same class by assertion.
     */
    private boolean equalsHelperForOptional(Object self, Object other) {
        // The code path can be splited into three cases and be dealt accordingly
        // Case 1: Only one of the object is null
        if (self != null && other == null || self == null && other != null) {
            return false;

        // Case 2: Both of the object is not null
        } else if (self != null && other != null) {
            assert self.getClass().equals(other.getClass());
            return self.equals(other);
        }

        // Case 3: Both of the object is null
        return true;
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, roomNumber, telegram, birthday, dormTag, tags);
    }

    @Override
    public String toString() {
        ToStringBuilder sb = new ToStringBuilder(this);
        sb.add("name", name);
        sb.add("phone", phone);
        sb.add("tags", tags);

        if (email != null) {
            sb.add("email", email);
        }

        if (roomNumber != null) {
            sb.add("roomNumber", roomNumber);
        }

        if (telegram != null) {
            sb.add("telegram", telegram);
        }

        if (birthday != null) {
            sb.add("birthday", birthday);
        }

        if (dormTag != null) {
            sb.add("dormTag", dormTag);
        }

        return sb.toString();
    }

}
