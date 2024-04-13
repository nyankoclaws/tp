package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_BIRTHDAY_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DORM_TAG_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_FREE_TIME_TAG_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ROOMNUMBER_BOB_W_DATE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TELEGRAM_BOB;
import static seedu.address.testutil.TypicalNewPersons.BOB;
import static seedu.address.testutil.TypicalPersons.ALICE;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class PersonTest {

    @Test
    public void isSamePerson_trueCases_assertTrue() {
        // same object
        assertTrue(ALICE.isSamePerson(ALICE));

        // all attributes same
        Person sameAlice = new PersonBuilder(ALICE).build();
        assertTrue(ALICE.isSamePerson(sameAlice));

        // same phone, all other attributes different
        Person editedPhoneAlice = new PersonBuilder(ALICE).withPhone(VALID_PHONE_BOB).build();
        assertTrue(BOB.isSamePerson(editedPhoneAlice));

        // same email, all other attributes different
        Person editedEmailAlice = new PersonBuilder(ALICE).withEmail(VALID_EMAIL_BOB).build();
        assertTrue(BOB.isSamePerson(editedEmailAlice));

        // same telegram, all other attributes different
        Person editedTelegramAlice = new PersonBuilder(ALICE).withTelegram(VALID_TELEGRAM_BOB).build();
        assertTrue(BOB.isSamePerson(editedTelegramAlice));
    }

    @Test
    public void isSamePerson_falseCases_assertFalse() {
        // null
        assertFalse(ALICE.isSamePerson(null));

        // same name, all other attributes different
        Person editedNameAlice = new PersonBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(BOB.isSamePerson(editedNameAlice));

        // same birthday, all other attributes different
        Person editedBirthdayAlice = new PersonBuilder(ALICE).withBirthday(VALID_BIRTHDAY_BOB).build();
        assertFalse(BOB.isSamePerson(editedBirthdayAlice));

        // same room number, all other attributes different
        Person editedRoomNumberAlice = new PersonBuilder(ALICE).withRoomNumber(VALID_ROOMNUMBER_BOB_W_DATE).build();
        assertFalse(BOB.isSamePerson(editedRoomNumberAlice));

        // same dorm, all other attributes different
        Person editedDormAlice = new PersonBuilder(ALICE).withDormTag(VALID_DORM_TAG_BOB).build();
        assertFalse(BOB.isSamePerson(editedDormAlice));

        // same free time, all other attributes different
        Person editedFreeTimeAlice = new PersonBuilder(ALICE).withFreeTimeTags(VALID_FREE_TIME_TAG_BOB).build();
        assertFalse(BOB.isSamePerson(editedFreeTimeAlice));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Person aliceCopy = new PersonBuilder(ALICE).build();
        assertTrue(ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE.equals(ALICE));

        // null -> returns false
        assertFalse(ALICE.equals(null));

        // different type -> returns false
        assertFalse(ALICE.equals(5));

        // different person -> returns false
        assertFalse(ALICE.equals(BOB));

        // different name -> returns false
        Person editedAlice = new PersonBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different phone -> returns false
        editedAlice = new PersonBuilder(ALICE).withPhone(VALID_PHONE_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different email -> returns false
        editedAlice = new PersonBuilder(ALICE).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different room number -> returns false
        editedAlice = new PersonBuilder(ALICE).withRoomNumber(VALID_ROOMNUMBER_BOB_W_DATE).build();
        assertFalse(ALICE.equals(editedAlice));
    }

    @Test
    public void equals_someOptionalFieldsAreNull_success() {
        Person aliceCopyWithoutEmail = new Person(
                ALICE.getName(),
                ALICE.getPhone(),
                null,
                ALICE.getRoomNumber(),
                ALICE.getTelegram(),
                ALICE.getBirthday(),
                ALICE.getDormTag(),
                ALICE.getTags());
        assertFalse(ALICE.equals(aliceCopyWithoutEmail));
        assertFalse(aliceCopyWithoutEmail.equals(ALICE));

        Person aliceCopyWithoutRoomNumber = new Person(
                ALICE.getName(),
                ALICE.getPhone(),
                ALICE.getEmail(),
                null,
                ALICE.getTelegram(),
                ALICE.getBirthday(),
                ALICE.getDormTag(),
                ALICE.getTags());
        assertFalse(ALICE.equals(aliceCopyWithoutRoomNumber));
        assertFalse(aliceCopyWithoutRoomNumber.equals(ALICE));

        Person aliceCopyWithoutTelegram = new Person(
                ALICE.getName(),
                ALICE.getPhone(),
                ALICE.getEmail(),
                ALICE.getRoomNumber(),
                null,
                ALICE.getBirthday(),
                ALICE.getDormTag(),
                ALICE.getTags());
        assertFalse(ALICE.equals(aliceCopyWithoutTelegram));
        assertFalse(aliceCopyWithoutTelegram.equals(ALICE));

        Person aliceCopyWithoutBirthday = new Person(
                ALICE.getName(),
                ALICE.getPhone(),
                ALICE.getEmail(),
                ALICE.getRoomNumber(),
                ALICE.getTelegram(),
                null,
                ALICE.getDormTag(),
                ALICE.getTags());
        assertFalse(ALICE.equals(aliceCopyWithoutBirthday));
        assertFalse(aliceCopyWithoutBirthday.equals(ALICE));
    }

    @Test
    public void toStringMethod() {
        String expected = Person.class.getCanonicalName() + "{name=" + ALICE.getName() + ", phone=" + ALICE.getPhone()
                + ", tags=" + ALICE.getTags() + ", email=" + ALICE.getEmail() + ", roomNumber=" + ALICE.getRoomNumber()
                + ", telegram=" + ALICE.getTelegram() + ", birthday=" + ALICE.getBirthday()
                + ", dormTag=" + ALICE.getDormTag() + "}";
        assertEquals(expected, ALICE.toString());
    }
}
