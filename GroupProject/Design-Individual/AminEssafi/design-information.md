**1.A list consisting of reminders the users want to be aware of. The application must allow users to add reminders to a list, delete reminders from a list, and edit the reminders in the list.**
A list class has been created that stores an array of datatype Reminder. Reminders can be added, deleted, and edited based on index number with methods within the List class.

**2. The application must contain a database (DB) of reminders and corresponding data.**
A database stores an array of datatype List and a second array called types to keep track of the different types of lists.

**3. Users must be able to add reminders to a list by picking them from a hierarchical list, where the first level is the reminder type (e.g., Appointment), and the second level is the name of the actual reminder (e.g., Dentist Appointment).**
When a new reminder is created, a method called lookup searches if the type the user enters already exists in the database. If that type does exist, the reminder is added to that list; if that type does not exist, the createList method is called. The name of the actual reminder is taken as a String and the createReminder method is called.

**4. Users must also be able to specify a reminder by typing its name. In this case, the application must look in its DB for reminders with similar names and ask the user whether that is the item they intended to add. If a match (or nearby match) cannot be found, the application must ask the user to select a reminder type for the reminder, or add a new one, and then save the new reminder, together with its type, in the DB.**
When the user types into the interface, they are typing into the New class, which does a lookup and allows the user to edit, select, or (if none is found) to create a new reminder.

**5. The reminders must be saved automatically and immediately after they are modified.**
Does not affect design.

**6. Users must be able to check off reminders in the list (without deleting them).**
The Reminder class has a boolean for the states of a checkbox.

**7. Users must also be able to clear all the check-off marks in the reminder list at once.**
The List class has a clearAll method that sets all checked booleans for its Reminders to false.

**8. Check-off marks for the reminder list are persistent and must also be saved immediately.**
Does not affect design.

**9. The application must present the reminders grouped by type.**
The identifier for all Lists is a string known as type.

**10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”, “Kid’s Reminders”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete reminder lists.**
Selecting is part of interface and not design. The List has a method to rename its type. The database has a method to delete the List from its array of lists.

**11. The application should have the option to set up reminders with day and time alert. If this option is selected allow option to repeat the behavior.**
An alert boolean is the option, the alarm is stored as a string, and a method ring compares the alarm with the utility containing date and time to know when to ring. 

**13. The User Interface (UI) must be intuitive and responsive.**
Does not affect design.