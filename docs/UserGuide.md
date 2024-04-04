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

## Command summary

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

- Free Time Tags are in the following format: `DDD:HHmm-HHmm` <br>
- `DDD` is from Mon-Sun, `HHmm` is 24 hour time format <br>
  e.g. **Mon:1300-1400**

- Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

- Extraneous parameters for commands that do not take in parameters (such as `list`) will be ignored.<br>
  e.g. if the command specifies `list 123`, it will be interpreted as `list`.

- Fields with the format followed by `...` can have more than one copy in the command. <br>
  e.g. `[ft/FREE TIME TAG]...` means there can be more than one free time tag. 

- Command keywords for the commands should be exactly the same as demonstration, or else Dormie would not recognize it.
  e.g. `add` is the command keyword in the add command, where `Add` or `ADD` will not work.

- If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
  </box>

### Creates a new contact for a dorm mate : add

Adds a person to Dormie.

Format: `add n/NAME p/PHONE [e/EMAIL] [r/ROOM NUMBER] [t/TELEGRAM] [b/BIRTHDAY] [d/DORM TAG] [ft/FREE TIME TAG]...`

Command usage examples:

- Adding a person with only mandatory fields: `add n/Alice Lim p/91234567`
- Adding a person with all mandatory fields and some optional fields: `add n/Bob p/88998899 r/21-03-01 ft/Tue:1300-1400 ft/Mon:0900-1200 ft/Tue:0800-1000`
- Adding a person with all fields: `add n/John Doe p/98765432 e/johnd@example.com r/sw-01-01 t/johnDoe b/12/12/2000 d/PGPR ft/Mon:1300-1400`

Some common cases that considered as invalid inputs:

- Invalid format, e.g. missing spaces
- Missing mandatory fields (name and phone)
- Duplicate parameters for fields except free time tags: e.g. having two name in the command

### Add Free Time Tag : addTime

Adds 1 or multiple specified `freeTimeTags` to the specified person.

Format: `addTime INDEX ft/FREE_TIME_TAG...`

Notes on format:

- The index refers to the index number shown in the displayed person list
- The index must be a positive integer e.g. 1, 2, 3

Command usage examples:

- Single input: `addTime 1 ft/Mon:1300-1400`
- Multiple input: `addTime 1 ft/Mon:1300-1400 ft/Tue:1300-1400`

Future enhancement (not implemented yet):

- The command can be performed on multiple person, 
  e.g. `addTime 1 2 ft/Mon:1300-1400` will add the free time tag to both the first and second person.

### Clear the entire contact list : clear

Removes all existing contacts from Dormie.

Format: `clear`

### Deleting a person : delete

Deletes the specified person from Dormie.

Format: `delete INDEX`

Notes on format:

- Deletes the person at the specified INDEX
- The index refers to the index number shown in the displayed person list
- The index must be a positive integer e.g. 1, 2, 3

Command usage examples:

- Deletes the 2nd person in Dormie: `delete 2`

### Delete Free Time Tag : deleteTime

Deletes 1 or multiple specified `freeTimeTags` from the specified person.

Format: `deleteTime INDEX ft/FREE_TIME_TAG`

Notes on format:

- The index refers to the index number shown in the displayed person list
- The index must be a positive integer e.g. 1, 2, 3

Command usage examples:

- Single input: `deleteTime 1 ft/Mon:1300-1400`
- Multiple input: `deleteTime 1 ft/Mon:1300-1400 ft/Tue:1300-1400`

Future enhancement (not implemented yet):

- The command can be performed on multiple person,
  e.g. `deleteTime 1 2 ft/Mon:1300-1400` will delete the free time tag from both the first and second person.

### Editing a person : edit

Replaces the specified field(s) of an existing person in Dormie with the new input(s).

Format: `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [r/ROOM_NUM] [t/TELEGRAM] [d/DORM_TAG] [ft/FREE_TIME_TAG]...`

Notes on format:

- Edits the person at the specified INDEX. The index refers to the index number shown in the displayed person list. 
- The index must be a positive integer e.g. 1, 2, 3
- Minimum 1 parameter must be specified

Command usage examples:

- Edits the name and room number of the 1st person to be Alex and 05-11 respectively: `edit 1 n/Alex r/01-05-11`

**Important Note**
- If `freeTimeTags` are edited, the person's `freeTimeTags` will be replaced with the new set of `freeTimeTags`. 
  Example:
    - Let Joe have a `freeTimeTag`:`Mon:1300-1400` and have the index 1:
    - `edit 1 ft/`: Will delete the existing `freeTimeTags`
    - `edit 1 ft/Tue:1300-1400 ft/Wed:1300-1400` Will replace the existing _Monday_ tag with the _Tuesday_ and _Wednesday_ tag.
- The edit command can be done on multiple person when the change is only done on dorm tag and / or free time tags.

### End the application : exit

Closes the application.

Format: `exit`

### Filter the contact list by name : find

View all persons with name containing the given keyword. 

Format: `find KEYWORD`

### Provide more detail on existing commands : help

Show a link to the User Guide.

Format: `help`

### Listing all persons in Dormie : list

List all persons in Dormie and their details.

Format: `list`

**Important Note**
- This command can be used to "reset" the view after using `find`.

### Check who is free : whoisfree

View all persons that are available on the specified day and time.

Format: `whoisfree DAY:TIME`

- `DAY` is from Mon-Sun
- `TIME` is 24-hour time format

Command usage examples:

- `whoisfree Mon:1300`

### Saving the data

Dormie data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

Dormie data are saved automatically as a JSON file [JAR file location]/data/dormie.json. It's possible for advanced users to update data directly by editing that data file.

<box type="warning" seamless>

Warning: If the data file is edited wrongly, there is no guarantee that Dormie will behave as expected.

</box>

---

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Dormie home folder.

---

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Glossary

| Term                                  | Definition, Examples                                                                                                                                                                                                                                                                            |
|---------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Command**                           | Instruction provided by a user to specify the desired action or change to be performed by an application.                                                                                                                                                                                       |
| **Command Line Interface (CLI)**      | Text-based interface used to interact with the application by typing commands into a command box.                                                                                                                                                                                               |
| **Graphical User Interface (GUI)**    | User interface that allows users to interact with graphical icons and visual indicators, use graphical elements such as windows, buttons, menus, and dialog boxes to facilitate user interaction with the application.                                                                          |
| **JavaScript Object Notation (JSON)** | Lightweight data interchange format that is easy for humans to read and write and easy for machines to parse and generate. JSON is based on key-value pairs and data structures, making it a popular format for representing structured data in web development and other programming contexts. |
