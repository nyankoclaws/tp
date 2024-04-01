package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class RoomNumberTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RoomNumber(null));
    }

    @Test
    public void constructor_invalidRoomNumber_throwsIllegalArgumentException() {
        String invalidRoomNumber = "";
        assertThrows(IllegalArgumentException.class, () -> new RoomNumber(invalidRoomNumber));
    }

    @Test
    public void isValidRoomNumber() {
        // null address
        assertThrows(NullPointerException.class, () -> RoomNumber.isValidRoomNumber(null));

        // invalid addresses
        assertFalse(RoomNumber.isValidRoomNumber("")); // empty string
        assertFalse(RoomNumber.isValidRoomNumber(" ")); // spaces only

        // valid addresses
        assertTrue(RoomNumber.isValidRoomNumber("sw-12-12"));
        assertTrue(RoomNumber.isValidRoomNumber("kw-01-02"));
        assertTrue(RoomNumber.isValidRoomNumber("kms-03-01"));
    }

    @Test
    public void isValidRoomNumberWDate() {
        // null address
        assertThrows(NullPointerException.class, () -> RoomNumber.isValidRoomNumberWDate(null));
        assertFalse(RoomNumber.isValidRoomNumberWDate("sw-12-12"));

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate tomorrow = today.plusDays(1);

        // valid addresses & dates
        assertTrue(RoomNumber.isValidRoomNumberWDate("sw-12-12 " + today.toString()));
        assertTrue(RoomNumber.isValidRoomNumberWDate("kw-01-02 " + tomorrow.toString()));
        assertTrue(RoomNumber.isValidRoomNumberWDate("kms-03-01 " + yesterday.toString()));

        // valid addresses & invalid date formats
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        assertFalse(RoomNumber.isValidRoomNumberWDate("sw-12-12 " + today.format(formatter)));
        assertFalse(RoomNumber.isValidRoomNumberWDate("kw-01-02 " + tomorrow.format(formatter)));
        assertFalse(RoomNumber.isValidRoomNumberWDate("kms-03-01 " + yesterday.format(formatter)));
    }

    @Test
    public void isValidDate() {
        LocalDate today = LocalDate.now();
        assertTrue(RoomNumber.isValidDate(today));

        LocalDate yesterday = today.minusDays(1);
        assertTrue(RoomNumber.isValidDate(yesterday));

        LocalDate tomorrow = today.plusDays(1);
        assertFalse(RoomNumber.isValidDate(tomorrow));
    }

    @Test
    public void isOutdated() {
        RoomNumber roomNumber = new RoomNumber("sw-01-01");
        assertFalse(roomNumber.isOutdated());

        // If updated on the lastResultRelease for this AY
        LocalDate date1 = LocalDate.parse("2020-04-12");
        date1 = date1.withYear(LocalDate.now().getYear());
        if (date1.isAfter(LocalDate.now())) {
            date1 = date1.minusYears(1);
        }
        assertFalse(RoomNumber.isOutdated(date1));
        assertFalse((new RoomNumber("sw-01-01", date1)).isOutdated());

        // If updated on the firstResultRelease for this AY
        LocalDate date2 = LocalDate.parse("2020-04-05");
        date2 = date2.withYear(LocalDate.now().getYear());
        if (date2.isAfter(LocalDate.now())) {
            date2 = date2.minusYears(1);
        }
        assertFalse(RoomNumber.isOutdated(date2));
        assertFalse((new RoomNumber("sw-01-01", date2)).isOutdated());

        // If updated before the firstResultRelease for this AY
        LocalDate date3 = date2.minusDays(1);
        assertTrue(RoomNumber.isOutdated(date3));
        assertTrue((new RoomNumber("sw-01-01", date3)).isOutdated());
    }

    @Test
    public void toStringWDate() {
        String roomNum = "sw-01-01";
        RoomNumber roomNumber = new RoomNumber(roomNum);
        String expected = roomNum + " " + LocalDate.now().toString();
        assertTrue(roomNumber.toStringWDate().equals(expected));

        String dateStr = "2022-05-02";
        LocalDate date1 = LocalDate.parse(dateStr);
        RoomNumber roomNumber1 = new RoomNumber(roomNum, date1);
        String expected1 = roomNum + " " + dateStr;
        assertTrue(roomNumber1.toStringWDate().equals(expected1));
    }

    @Test
    public void equals() {
        RoomNumber roomNumber = new RoomNumber("sw-01-01");

        // same values -> returns true
        assertTrue(roomNumber.equals(new RoomNumber("sw-01-01")));

        // same object -> returns true
        assertTrue(roomNumber.equals(roomNumber));

        // null -> returns false
        assertFalse(roomNumber.equals(null));

        // different types -> returns false
        assertFalse(roomNumber.equals(5.0f));

        // different values -> returns false
        assertFalse(roomNumber.equals(new RoomNumber("nw-02-02")));
    }
}
