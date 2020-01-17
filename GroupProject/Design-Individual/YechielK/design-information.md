
## Create files and folders

**1. A list consisting of reminders the users want to be aware of. The application must allow users to add reminders to a list, delete reminders from a list, and edit the reminders in the list.**
Uses a list class of a list of reminders, contains functions add, delete, and edit.

**2. The application must contain a database (DB) of reminders and corresponding data.**
Contains a database that contains lists of reminders.

**3. Users must be able to add reminders to a list by picking them from a hierarchical list, where the first level is the reminder type (e.g., Appointment), and the second level is the name of the actual reminder (e.g., Dentist Appointment).**
Will be implemented in the application

**4. Users must also be able to specify a reminder by typing its name. In this case, the application must look in its DB for reminders with similar names and ask the user whether that is the item they intended to add. If a match (or nearby match) cannot be found, the application must ask the user to select a reminder type for the reminder, or add a new one, and then save the new reminder, together with its type, in the DB.**
Implemented in the UML

**5. The reminders must be saved automatically and immediately after they are modified.**
Beyond the scope of the UML
**6. Users must be able to check off reminders in the list (without deleting them).**
checkDatabase function in UML

**7. Users must also be able to clear all the check-off marks in the reminder list at once.**
checkOffReminders function in UML

**8. Check-off marks for the reminder list are persistent and must also be saved immediately.**
Beyond scope

**9. The application must present the reminders grouped by type.**
type is implemented, display will be designed later

**10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”, “Kid’s Reminders”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete reminder lists.**
Multiple lists in database

**11. The application should have the option to set up reminders with day and time alert. If this option is selected allow option to repeat the behavior.**
Time, Date, and repeatBehavior in UML
**12. Extra Credit: Option to set up reminder based on location. **

**13. The User Interface (UI) must be intuitive and responsive.**
Beyond scope of UML
