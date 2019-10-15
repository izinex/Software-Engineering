**1. A list consisting of reminders the users want to be aware of. The application must allow users to add reminders to a list, delete reminders from a list, and edit the reminders in the list.** 

***Users are created in the Users class, where each user provides a Name, username and a password to create their account.***

**2. The application must contain a database (DB) of reminders and corresponding data.** 

***The database portion wasn't included since it wasn't necessary for the diagram***

**3. Users must be able to add reminders to a list by picking them from a hierarchical list, where the first level is the reminder type (e.g., Appointment), and the second level is the name of the actual reminder (e.g., Dentist Appointment).** 

***We allow the users to create lists in the user class once a lists is created we allow them to name the lists how large the size of the list into the ReminderList class. Which forms a hierarchy to the ReminderType class that goes to the ReminderName class.*** 

**4. Users must also be able to specify a reminder by typing its name. In this case, the application must look in its DB for reminders with similar names and ask the user whether that is the item they intended to add. If a match (or nearby match) cannot be found, the application must ask the user to select a reminder type for the reminder, or add a new one, and then save the new reminder, together with its type, in the DB.** 

***In the ReminderName class we implement a reminderNameFind() function which allows the users to find a specfic reminder by typing its name and if it is already in the DB it will prompt the user if they wish to still add it or go to the similar reminder that was created prior. And when creating a new reminder the SelectReminderType operation will allow users to put that reminder to which ever type is already in the DB.***

**5. The reminders must be saved automatically and immediately after they are modified.** 

***This feature is not necessary for this diagram.***

**6. Users must be able to check off reminders in the list (without deleting them).** 

***Every Reminder Class has a function/method that has a checkoff function which allows the users to check off a specific reminder or all reminders in a reminder type, or the whole list.***

**7. Users must also be able to clear all the check-off marks in the reminder list at once.** 

***This is implemented with the checkAll() function in ReminderList class.***

**8. Check-off marks for the reminder list are persistent and must also be saved immediately.** 

***This is not required for the diagram.***

**9. The application must present the reminders grouped by type.** 

***Since this is specific to the UI, so this portion will not be necessary for the diagram.***

 **10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”, “Kid’s Reminders”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete reminder lists.** 

***When creating a user, the user will be able to create as many lists as they want with createList(), or edit the list with editList() and delete lists with deleteList() and even rename the lists with renameList() in Users class.***

**11. The application should have the option to set up reminders with day and time alert. If this option is selected allow option to repeat the behavior.** 

***This option is enabled when creating a specific reminder in the ReminderName class where the user is allowed to check the ReminderTimeDate option.  And a reminder is also allowed to repeat if the reminder was given the the time and date option as that is an operation called ReminderRepeat in the ReminderName class.***

**12. Extra Credit: Option to set up reminder based on location.** 

***In the ReminderName class we allow users to enable location on or off, if the they enable it in the location class will allow them to turn the location function on which checks for the location upon which the reminder was created or if they are at a specific location they may create a reminder based on that location which is pushed from the Location class to the ReminderName. The LocationCheck functions allows certain remainders to turn on depending on if the reminderLocationONandOFF() function is enabled*** 

**13. The User Interface (UI) must be intuitive and responsive.**
***This portion does not require a design within the diagram process*** 
