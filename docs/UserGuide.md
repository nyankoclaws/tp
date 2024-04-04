---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---

# Dormie User Guide

Dormie is a **desktop app for managing contacts, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, Dormie can get your contact management tasks done faster than traditional GUI apps.

<!-- * Table of Contents -->
<page-nav-print />

---

## Command Summary

Action     | Format, Examples
-----------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Add**    | `add n/NAME r/ROOM_NUM​` <br> e.g., `add Alice Lim r/02-03`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`
**Edit**   | `edit INDEX [n/NAME] [r/ROOM_NUM​]​`<br> e.g.,`edit 1 n/Alex r/05-11`
**Exit**   | `exit`
**Find**   | `find KEYWORD`<br> e.g., `find Alice`
**Help**   | `help`
**List**   | `list`
**Who Is Free**| `whoisfree TIME`<br> e.g., `whoisfree Mon:0800`

---

## Using This User Guide
### Text Types
Type                                | What it means
-----------                         |----------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Bold**                            | Command word <br> e.g., **add**, which adds a new contact
`Code Block`                        | A line of command that can be entered into Dormie's input field <br> e.g., `add n/John Doe p/98765432 e/johnd@example.com r/sw-01-01 t/johnDoe b/12/12/2000 ft/Mon:1300-1400`
\<value\>                           | Value for the respective field <br> e.g., `add n/<name> p/<phoneNumber> e/<email> r/<roomNumber> t/<telegramHandle> b/<birthday>`
\[optionalField\]                   | Indicates an optional field <br> e.g., `add n/<name> [t/<telegramHandle>]`, where telegramHandle is an optional field.

### Searching for Keywords (Ctrl-F)
1. Press the Ctrl + F keys on your keyboard.
2. A search bar or dialog box should appear on your screen.
3. Type the keyword or phrase you want to search for in the search bar or dialog box.
4. Press Enter or click on the "Find" button to start the search.
5. The document viewer or web browser will highlight all instances of the keyword or phrase found within the document.
6. To navigate through the search results, you can use the arrow buttons or options provided by the search feature.
7. Once you have finished reviewing the search results, you can close the search bar or dialog box to return to your document.

---

## Quick Start

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

## Contact Fields

| Field Name        | Valid Format, Examples                                                                                                                                           |
|-------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Name**          | Any non-empty String, eg:`Dormie`                                                                                                                                |
| **Dorm Tag**      | Any non-empty String, eg:`PGPR`                                                                                                                                  |
| **Free Time Tag** | DDD:HHmm-HHmm, Start Time **must** be earlier than End Time, eg:`Mon:1300-1400`                                                                                  |
| **Phone**         | Must contain 8 digits, eg:`91234567`                                                                                                                             |
| **Room Number**   | {block}-{floor}-{room number}, where block and room number are at least 2 alphanumeric characters and floor is strictly 2 alphanumeric characters, eg:`nw-12-12` |
| **Email**         | Must contain @ and .com, eg:`dormie@example.com`                                                                                                                 |
| **Telegram**      | Can only contain case-insensitive letters A-Z, digits 0-9, and underscores, with a length between 5 and 32 characters, eg:`dormie_123`                           |
| **Birthday**      | dd/MM/yyyy", "dd-MM-yyyy", "yyyy/MM/dd", "yyyy-MM-dd, eg:`21/01/2024`, `21-01-2024`, `2024/01/21`, `2024-01-21`                                                  |

---

## Features

<box type="info" seamless>

**Notes about the command format:**<br>

- Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

- Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

- Free Time Tags are in the following format: `DDD:HHmm-HHmm` <br>
- `DDD` is from Mon-Sun, `HHmm` is 24 hour time format <br>
  e.g. **Mon:1300-1400**

- Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

- Extraneous parameters for commands that do not take in parameters (such as `list`) will be ignored.<br>
  e.g. if the command specifies `list 123`, it will be interpreted as `list`.

- If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
  </box>

### Adding a person: add

Creates a new contact for a dorm mate.

Format: `add n/NAME p/PHONE_NUMBER`

Examples:

- `add Alice Lim p/91234567`

### Add Free Time Tag
Adds 1 or multiple specified `freeTimeTags`

Format: `addTime INDEX ft/FREE_TIME_TAG`

Examples:
- Single input: `addTime 1 ft/Mon:1300-1400`
- Multiple input: `addTime 1 ft/Mon:1300-1400 ft/Tue:1300-1400`

### Delete Free Time Tag
Deletes 1 or multiple specified `freeTimeTags`

Format: `deleteTime INDEX ft/FREE_TIME_TAG`

Examples:
- Single input: `deleteTime 1 ft/Mon:1300-1400`
- Multiple input: `deleteTime 1 ft/Mon:1300-1400 ft/Tue:1300-1400`

### Check who is free
View all persons that are available on the specified day and time

Format: `whoisfree DAY:TIME`
- `DAY` is from Mon-Sun
- `TIME` is 24-hour time format

Example:
- `whoisfree Mon:1300`

### Listing all persons : list

List all contacts and their details

Format: `list`

### Editing a person : edit

Edits the specified fields of an existing person in Dormie.

- Edit function will replace the specified field with the new input
- Edits the person at the specified INDEX. The index refers to the index number shown in the displayed person list. The index must be a positive integer 1, 2, 3, …​
- Existing values will be updated to the input values.
- Minimum 1 parameter must be specified

Format: `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [r/ROOM_NUM] [t/TELEGRAM] [d/DORM_TAG] [ft/FREE_TIME_TAG]`

Examples:

- `edit 1 n/Alex r/01-05-11` Edits the name and room number of the 1st person to be Alex and 05-11 respectively.

**Important Note**
- If `freeTimeTags` are edited, the person's `freeTimeTags` will be replaced with the new set of `freeTimeTags`.
- Example:
    - Let Joe have a `freeTimeTag`:`Mon:1300-1400` and have the index 1:
    - `edit 1 ft/`: Will delete the existing `freeTimeTags`
    - `edit 1 ft/Tue:1300-1400 ft/Wed:1300-1400` Will replace the existing _Monday_ tag with the _Tuesday_ and _Wednesday_ tag.


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

## Known Issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Glossary

| Term                                  | Definition, Examples                                                                                                                                                                                                                                                                            |
|---------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Command**                           | Instruction provided by a user to specify the desired action or change to be performed by an application.                                                                                                                                                                                       |
| **Command Line Interface (CLI)**      | Text-based interface used to interact with the application by typing commands into a command box.                                                                                                                                                                                               |
| **Graphical User Interface (GUI)**    | User interface that allows users to interact with graphical icons and visual indicators, use graphical elements such as windows, buttons, menus, and dialog boxes to facilitate user interaction with the application.                                                                          |
| **JavaScript Object Notation (JSON)** | Lightweight data interchange format that is easy for humans to read and write and easy for machines to parse and generate. JSON is based on key-value pairs and data structures, making it a popular format for representing structured data in web development and other programming contexts. |
