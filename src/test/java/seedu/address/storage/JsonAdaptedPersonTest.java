package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedPerson.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BENSON;
import static seedu.address.testutil.TypicalPersons.CARL;
import static seedu.address.testutil.TypicalPersons.DANIEL;
import static seedu.address.testutil.TypicalPersons.ELLE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Birthday;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.RoomNumber;
import seedu.address.model.person.Telegram;
import seedu.address.model.tag.DormTag;
import seedu.address.model.tag.FreeTimeTag;

public class JsonAdaptedPersonTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_ROOMNUMBER = " ";
    private static final String INVALID_TELEGRAM = " ";
    private static final String INVALID_BIRTHDAY = " ";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_DORMTAG = " ";
    private static final String INVALID_FREETIMETAGS = "Mon:1pm-2pm";

    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_PHONE = BENSON.getPhone().toString();
    private static final String VALID_EMAIL = BENSON.getEmail().toString();
    private static final String VALID_ROOMNUMBER =
                BENSON.getRoomNumber() == null ? null : BENSON.getRoomNumber().toStringWDate();
    private static final String VALID_TELEGRAM = BENSON.getTelegram().toString();
    private static final String VALID_BIRTHDAY = "25/02/2001";
    private static final String VALID_DORMTAG = BENSON.getDormTag().toString();
    private static final List<JsonAdaptedFreeTimeTag> VALID_FREETIMETAGS = BENSON.getTags().stream()
            .map(JsonAdaptedFreeTimeTag::new)
            .collect(Collectors.toList());

    @Test
    public void toModelType_validPersonDetails_returnsPerson() throws Exception {
        JsonAdaptedPerson person1 = new JsonAdaptedPerson(ALICE);
        assertEquals(ALICE, person1.toModelType());
        JsonAdaptedPerson person2 = new JsonAdaptedPerson(BENSON);
        assertEquals(BENSON, person2.toModelType());
        JsonAdaptedPerson person3 = new JsonAdaptedPerson(CARL);
        assertEquals(CARL, person3.toModelType());
        JsonAdaptedPerson person4 = new JsonAdaptedPerson(DANIEL);
        assertEquals(DANIEL, person4.toModelType());
        JsonAdaptedPerson person5 = new JsonAdaptedPerson(ELLE);
        assertEquals(ELLE, person5.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(INVALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ROOMNUMBER, VALID_TELEGRAM,
                        VALID_BIRTHDAY, VALID_DORMTAG, VALID_FREETIMETAGS);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
        JsonAdaptedPerson person1 = new JsonAdaptedPerson(VALID_NAME, INVALID_PHONE, VALID_EMAIL, VALID_ROOMNUMBER,
                VALID_TELEGRAM, VALID_BIRTHDAY, VALID_FREETIMETAGS);
        String expectedMessage1 = Phone.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage1, person1::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(null, VALID_PHONE, VALID_EMAIL, VALID_ROOMNUMBER,
                VALID_TELEGRAM, VALID_BIRTHDAY, VALID_DORMTAG, VALID_FREETIMETAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, INVALID_PHONE, VALID_EMAIL, VALID_ROOMNUMBER, VALID_TELEGRAM,
                        VALID_BIRTHDAY, VALID_DORMTAG, VALID_FREETIMETAGS);
        String expectedMessage = Phone.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullPhone_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, null, VALID_EMAIL, VALID_ROOMNUMBER,
                VALID_TELEGRAM, VALID_BIRTHDAY, VALID_DORMTAG, VALID_FREETIMETAGS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, INVALID_EMAIL, VALID_ROOMNUMBER, VALID_TELEGRAM,
                        VALID_BIRTHDAY, VALID_DORMTAG, VALID_FREETIMETAGS);
        String expectedMessage = Email.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidRoomNumber_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, INVALID_ROOMNUMBER, VALID_TELEGRAM,
                        VALID_BIRTHDAY, VALID_DORMTAG, VALID_FREETIMETAGS);
        String expectedMessage = RoomNumber.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidTelegram_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ROOMNUMBER, INVALID_TELEGRAM,
                        VALID_BIRTHDAY, VALID_DORMTAG, VALID_FREETIMETAGS);
        String expectedMessage = Telegram.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidBirthday_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ROOMNUMBER, VALID_TELEGRAM,
                        INVALID_BIRTHDAY, VALID_DORMTAG, VALID_FREETIMETAGS);
        String expectedMessage = Birthday.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidFreeTimeTags_throwsIllegalValueException() {
        List<JsonAdaptedFreeTimeTag> invalidTags = new ArrayList<>(VALID_FREETIMETAGS);
        invalidTags.add(new JsonAdaptedFreeTimeTag(INVALID_FREETIMETAGS));
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ROOMNUMBER,
                VALID_TELEGRAM, VALID_BIRTHDAY, VALID_DORMTAG, invalidTags);
        String expectedMessage = FreeTimeTag.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidDormTag_throwsIllegalValueException() {
        JsonAdaptedPerson person =
                new JsonAdaptedPerson(VALID_NAME, VALID_PHONE, VALID_EMAIL, VALID_ROOMNUMBER, VALID_TELEGRAM,
                        VALID_BIRTHDAY, INVALID_DORMTAG, VALID_FREETIMETAGS);
        String expectedMessage = DormTag.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }
}
