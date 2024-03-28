package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_BIRTHDAY_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_FREE_TIME_TAG_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ROOMNUMBER_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TELEGRAM_BOB;

import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in
 * tests.
 */
public class TypicalNewPersons {
    // All fields present
    public static final Person ALICE = new NewPersonBuilder().withName("Alice Pauline")
            .withRoomNumber("nw-12-12").withTelegram("alicePauline").withBirthday("23/12/1990")
            .withEmail("alice@example.com").withPhone("94351253").withFreeTimeTags("Mon:1000-1400").build();
    // Room number not present
    public static final Person BENSON = new NewPersonBuilder().withName("Benson Meier")
            .withTelegram("bensonMeier").withBirthday("25/02/2001")
            .withEmail("johnd@example.com").withPhone("98765432").withFreeTimeTags("Mon:1000-1400").build();
    // Email not present
    public static final Person CARL = new NewPersonBuilder().withName("Carl Kurz").withPhone("95352563")
            .withRoomNumber("IW-03-12").withTelegram("carlKurz")
            .withBirthday("12/04/1995").withFreeTimeTags("Mon:1000-1400").build();
    // Telegram not present
    public static final Person DANIEL = new NewPersonBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withRoomNumber("an-10-10")
            .withBirthday("10/10/2002").withFreeTimeTags("Mon:1000-1400").build();
    // Birthday not present
    public static final Person ELLE = new NewPersonBuilder().withName("Elle Meyer").withPhone("94822243")
            .withEmail("werner@example.com").withRoomNumber("tt-02-12B")
            .withTelegram("elleMeyer").withFreeTimeTags("Mon:1000-1400").build();
    public static final Person FIONA = new NewPersonBuilder().withName("Fiona Kunz").withPhone("94822427")
            .withEmail("lydia@example.com").withRoomNumber("od-05-12S").withTelegram("fionaKunz")
            .withBirthday("12/05/2002").withFreeTimeTags("Mon:1000-1400").build();
    public static final Person GEORGE = new NewPersonBuilder().withName("George Best").withPhone("94824142")
            .withEmail("anna@example.com").withRoomNumber("ie-23-12B").withTelegram("georgeBest")
            .withBirthday("22/12/1997").withFreeTimeTags("Mon:1000-1400").build();

    public static final Person BOB = new NewPersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withRoomNumber(VALID_ROOMNUMBER_BOB).withTelegram(VALID_TELEGRAM_BOB)
            .withBirthday(VALID_BIRTHDAY_BOB).withFreeTimeTags(VALID_FREE_TIME_TAG_BOB).build();
}
