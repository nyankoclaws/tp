package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Birthday;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.RoomNumber;
import seedu.address.model.person.Telegram;

/**
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String name;
    private final String phone;
    private final String email;
    private final String roomNumber;
    private final String telegram;
    private final String birthday;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
            @JsonProperty("email") String email, @JsonProperty("roomNumber") String roomNumber,
                             @JsonProperty("telegram") String telegram, @JsonProperty("birthday") String birthday) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.roomNumber = roomNumber;
        this.telegram = telegram;
        this.birthday = birthday;
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        name = source.getName().fullName;
        phone = source.getPhone().value;
        email = source.getEmail() == null ? null : source.getEmail().value;
        roomNumber = source.getRoomNumber() == null ? null : source.getRoomNumber().toStringWDate();
        telegram = source.getTelegram() == null ? null : source.getTelegram().value;
        birthday = source.getBirthday() == null ? null : String.valueOf(source.getBirthday().value);
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Person toModelType() throws IllegalValueException {

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        }
        if (!Phone.isValidPhone(phone)) {
            throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
        }
        final Phone modelPhone = new Phone(phone);

        Email modelEmail = null;
        if (email != null) {
            if (!Email.isValidEmail(email)) {
                throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
            }
            modelEmail = new Email(email);
        }

        RoomNumber modelRoomNumber = null;
        if (roomNumber != null) {
            if (!RoomNumber.isValidRoomNumberWDate(roomNumber)) {
                throw new IllegalValueException(RoomNumber.MESSAGE_CONSTRAINTS);
            }
            modelRoomNumber = new RoomNumber(roomNumber, true);
        }

        Telegram modelTelegram = null;
        if (telegram != null) {
            if (!Telegram.isValidTelegram(telegram)) {
                throw new IllegalValueException(Telegram.MESSAGE_CONSTRAINTS);
            }
            modelTelegram = new Telegram(telegram);
        }

        Birthday modelBirthday = null;
        if (birthday != null) {
            if (!Birthday.isValidBirthday(birthday)) {
                throw new IllegalValueException(Birthday.MESSAGE_CONSTRAINTS);
            }
            modelBirthday = new Birthday(birthday);
        }

        return new Person(modelName, modelPhone, modelEmail, modelRoomNumber, modelTelegram, modelBirthday);
    }

}
