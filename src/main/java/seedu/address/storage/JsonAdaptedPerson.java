package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
import seedu.address.model.tag.DormTag;
import seedu.address.model.tag.FreeTimeTag;

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
    private final String dormTag;
    private final List<JsonAdaptedFreeTimeTag> freeTimeTags = new ArrayList<>();
    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
            @JsonProperty("email") String email, @JsonProperty("roomNumber") String roomNumber,
                             @JsonProperty("telegram") String telegram, @JsonProperty("birthday") String birthday,
                             @JsonProperty("dormTag") String dormTag,
                             @JsonProperty("tags") List<JsonAdaptedFreeTimeTag> freeTimeTags) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.roomNumber = roomNumber;
        this.telegram = telegram;
        this.birthday = birthday;
        this.dormTag = dormTag;
        if (freeTimeTags != null) {
            this.freeTimeTags.addAll(freeTimeTags);
        }
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
        dormTag = source.getDormTag() == null ? null : source.getDormTag().tagName;
        freeTimeTags.addAll(source.getTags().stream()
                .map(JsonAdaptedFreeTimeTag::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Person toModelType() throws IllegalValueException {
        final List<FreeTimeTag> freeTimeTagList = new ArrayList<>();
        for (JsonAdaptedFreeTimeTag freeTimeTag : freeTimeTags) {
            freeTimeTagList.add(freeTimeTag.toModelType());
        }

        checkAndThrow(name == null, String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        checkAndThrow(!Name.isValidName(name), Name.MESSAGE_CONSTRAINTS);
        final Name modelName = new Name(name);

        checkAndThrow(phone == null, String.format(MISSING_FIELD_MESSAGE_FORMAT, Phone.class.getSimpleName()));
        checkAndThrow(!Phone.isValidPhone(phone), Phone.MESSAGE_CONSTRAINTS);
        final Phone modelPhone = new Phone(phone);

        Email modelEmail = null;
        if (email != null) {
            checkAndThrow(!Email.isValidEmail(email), Email.MESSAGE_CONSTRAINTS);
            modelEmail = new Email(email);
        }

        RoomNumber modelRoomNumber = null;
        if (roomNumber != null) {
            checkAndThrow(!RoomNumber.isValidRoomNumberWDate(roomNumber), RoomNumber.MESSAGE_CONSTRAINTS_DATE);
            checkAndThrow(!RoomNumber.isValidDate(roomNumber), RoomNumber.MESSAGE_CONSTRAINTS_DATE_BEFORE);
            modelRoomNumber = new RoomNumber(roomNumber, true);
        }

        Telegram modelTelegram = null;
        if (telegram != null) {
            checkAndThrow(!Telegram.isValidTelegram(telegram), Telegram.MESSAGE_CONSTRAINTS);
            modelTelegram = new Telegram(telegram);
        }

        Birthday modelBirthday = null;
        if (birthday != null) {
            if (!Birthday.isValidBirthdayFormat(birthday)) {
                throw new IllegalValueException(Birthday.MESSAGE_CONSTRAINTS);
            }
            if (!Birthday.isValidBirthdayValue(birthday)) {
                throw new IllegalValueException(Birthday.INVALID_DATE);
            }
            if (Birthday.isBirthdayFuture(birthday)) {
                throw new IllegalValueException(Birthday.FUTURE_DATE);
            }
            modelBirthday = new Birthday(birthday);
        }

        DormTag modelDormTag = null;
        if (dormTag != null) {
            checkAndThrow(!DormTag.isValidTagName(dormTag), DormTag.MESSAGE_CONSTRAINTS);
            modelDormTag = new DormTag(dormTag);
        }

        final Set<FreeTimeTag> modelFreeTimeTags = new HashSet<>(freeTimeTagList);

        return new Person(modelName, modelPhone, modelEmail, modelRoomNumber, modelTelegram, modelBirthday,
                modelDormTag, modelFreeTimeTags);
    }

    private void checkAndThrow(boolean condition, String errorMessage) throws IllegalValueException {
        if (condition) {
            throw new IllegalValueException(errorMessage);
        }
    }

}
