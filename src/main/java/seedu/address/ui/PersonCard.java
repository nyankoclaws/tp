package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved
     * keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The
     *      issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label roomNumber;
    @FXML
    private Label telegram;
    @FXML
    private Label birthday;
    @FXML
    private Label email;
    @FXML
    private FlowPane dormTag;
    @FXML
    private FlowPane tags;
    @FXML
    private ImageView birthdayIcon;
    @FXML
    private ImageView changeRoomNumberIcon;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to
     * display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;
        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
        phone.setText(person.getPhone().value);

        roomNumber.setText(person.getRoomNumber() != null ? person.getRoomNumber().toString() : "");
        telegram.setText(person.getTelegram() != null ? "@" + person.getTelegram().value : "");
        birthday.setText(person.getBirthday() != null ? String.valueOf(person.getBirthday()) : "");
        email.setText(person.getEmail() != null ? person.getEmail().value : "");

        if (person.getDormTag() != null) {
            dormTag.getChildren().add(new Label(person.getDormTag().tagName));
        }

        person.getTags().stream()
                .sorted()
                .forEach(freeTag -> tags.getChildren().add(new Label(freeTag.tagName)));

        birthdayIcon.setVisible(person.getBirthday() != null ? person.getBirthday().isBirthday() : false);
        changeRoomNumberIcon.setVisible(person.getRoomNumber() != null ? person.getRoomNumber().isOutdated() : false);
    }
}
