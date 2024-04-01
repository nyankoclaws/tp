---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---

# Dormie User Guide

Dormie is a **desktop app for managing contacts, optimized for use via a Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, Dormie can get your contact management tasks done faster than traditional GUI apps.

<!-- * Table of Contents -->
<page-nav-print />

---

## Command summary

| Action     | Format, Examples                                                      |
| ---------- | --------------------------------------------------------------------- |
| **Add**    | `add n/NAME r/ROOM_NUM​` <br> e.g., `add Alice Lim r/02-03`           |
| **Delete** | `delete INDEX`<br> e.g., `delete 3`                                   |
| **Edit**   | `edit INDEX [n/NAME] [r/ROOM_NUM​]​`<br> e.g.,`edit 1 n/Alex r/05-11` |
| **List**   | `list`                                                                |

---

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

   - MacOS: [Java 11](https://www.oracle.com/sg/java/technologies/javase/jdk11-archive-downloads.html)
   - Windows: [Java 11](https://www.azul.com/downloads/?version=java-11-lts&os=macos&architecture=arm-64-bit&package=jdk-fx#zulu)

1. Download the latest `dormie.jar` from [here](https://github.com/AY2324S2-CS2103T-F11-4/tp/releases).

1. Create a new _Home Folder_ you want Dormie to permanently reside in.

   - Move Dormie into the _Home Folder_
   - This is where Dormie and all it's supporting data will be stored

1. Open a command terminal (`Terminal` for MacOS, or `Windows Terminal` for Windows)

   - MacOS:
     1. Right click the _Home Folder_
     1. Left click `New Terminal at Folder`
   - Windows:
     1. Navigate into the _Home Folder_
     1. Right click anywhere inside the _Home Folder_
     1. Left click `Open in Windows Terminal`

1. Past this Command into the new terminal window `java -jar dormie.jar` and press enter.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it.<br>
   Quick Tutorial:

   - `add n/John Doe n/sw-01-01` : Adds a contact named `John Doe` to Dormie.

   - `find John` : Finds a contact with `John` in his name.

   - `delete 1` : Deletes the 1st contact shown in the current list.

   - `list` : Lists all contacts again.

1. Refer to [Features](#features) below for details of each command
or to [Command Summary](#command-summary) for a summary of the commands.

---

## Features

<box type="info" seamless>

**Notes about the command format:**<br>

- Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

- Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

- Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

- Extraneous parameters for commands that do not take in parameters (such as `list`) will be ignored.<br>
  e.g. if the command specifies `list 123`, it will be interpreted as `list`.

- If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
  </box>

### Adding a person: add

Creates a new contact for a dorm mate.

Format: `add NAME r/ROOM_NUM`

Examples:

- `add Alice Lim r/02-03`

### Listing all persons : list

List all contacts and their details

Format: `list`

### Editing a person : edit

Edits an existing person in Dormie.

Format: `edit INDEX n/NAME r/ROOM_NUM`

- Edits the person at the specified INDEX. The index refers to the index number shown in the displayed person list. The index must be a positive integer 1, 2, 3, …​
- Existing values will be updated to the input values.

Examples:

- `edit 1 n/Alex r/05-11` Edits the name and room number of the 1st person to be Alex and 05-11 respectively.

### Deleting a person : delete

Deletes the specified person from Dormie.

Format: `delete INDEX`

- Deletes the person at the specified INDEX.
- The index refers to the index number shown in the displayed person list.
- The index must be a positive integer 1, 2, 3, …​

Examples:

- `delete 2` deletes the 2nd person in Dormie.

### Saving the data

Dormie data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

Dormie data are saved automatically as a JSON file [JAR file location]/data/dormie.json. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>

Caution:
If your changes to the data file makes its format invalid, Dormie will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the Dormie to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</box>

---

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Dormie home folder.

---

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
