                                     Vagner Machado
                                  Professor Andy Abreu
                                 Software Engineering
                                      9 Oct. 2019

### Requirements for Assignment #5
**1.**  A list consisting of reminders the users want to be aware of. The application must allow users to add reminders to a list, delete reminders from a list, and edit the reminders in the list.
> The application will contain classes named **Reminder** and **List**  to support these requirements.  Reminders can be edited through the getter and setter methods defined in that class, while each list can be manipulated through methods that allow the application to **add, delete and edit** reminders in it.
___
**2.** The application must contain a database (DB) of reminders and corresponding data.
> The database requirement is accomplished through the a class called **Database**, which will contain all data related to reminders and lists.
___
**3.** Users must be able to add reminders to a list by picking them from a hierarchical list, where the first level is the reminder type (e.g., Appointment), and the second level is the name of the actual reminder (e.g., Dentist Appointment).
>Each list will contain reminders of a specific type, defined in the instance variable **type** in List class. Each of those reminders in the list have a specific name, defined in the instance variable **name** in Reminder class. These two variables provide data for the hierarchical choice to be implemented. The mechanics of how the application accomplishes this will be defined at a later stage of development.
___
**4.** Users must also be able to specify a reminder by typing its name. In this case, the application must look in its DB for reminders with similar names and ask the user whether that is the item they intended to add. If a match (or nearby match) cannot be found, the application must ask the user to select a reminder type for the reminder, or add a new one, and then save the new reminder, together with its type, in the DB.
>This step involves the mechanics of how a part of the application should work; This will be described at a later stage of development. For now, each reminder has a **name** instance variable, both List and Database classes contain **search** methods that should, respectively, search for a reminder by name and seach for a list by type. Together with the **addReminder** method in list class, these requirements are fulfilled by the given variables and methods.
___
**5.** The reminders must be saved automatically and immediately after they are modified.
>This step involves the mechanics of how a part of the application should work; This will be described at a later stage of development. 
___
**6.** Users must be able to check off reminders in the list (without deleting them)
> The Reminder class contain boolean instance variable **checked** which holds the status of a reminder - checked or unchecked. This variable can be updated through **setChecked** setter method defined in Reminder class. Additionally, the List class provides a **checkOff** method to check off reminder(s) in the list of reminders.
___
**7.** Users must also be able to clear all the check-off marks in the reminder list at once.
>The class List provides a method to **uncheckAll** reminders in a list in order to fulfill this requirement.
___
**8.** Check-off marks for the reminder list are persistent and must also be saved immediately.
>This step involves the mechanics of how a part of the application should work; This will be described at a later stage of development. 
___
**9.** The application must present the reminders grouped by type.
>This step involves the mechanics of how a part of the application should work; This will be described in more detail at a later stage of development. For now, each list stores reminders of same **type**, providing a variable that allows for grouping reminders alike. 
___
**10.** The application must support multiple reminder lists at a time *(e.g., “Weekly”, “Monthly”, “Kid’s Reminders”).* Therefore, the application must provide the users with the ability to create, (re)name, select, and delete reminder lists.
> The Database class contains many lists as instance variable where each list is of a specific type. The database class provides methods to **add, rename, search** and **delete** list of reminders. 
___
**11.** The application should have the option to set up reminders with day and time alert. If this option is selected allow option to repeat the behavior.
> The Reminder class has as instance variables **date**, **time**, **incrementalTime**, **incrementalDay** and **repeat** that can be used to implement this behaviour. The mechanics of how the application accomplished this actions will be described at a later stage of development.
___
**12.** Extra Credit: Option to set up reminder based on location.
>Additionally to instance variables mentioned, the Reminder class contains **latitude** and **longitude** instance variables to store the location for the reminder to be set off.
___
**13.** The User Interface (UI) must be intuitive and responsive.
>This step involves the mechanics of how the application should work; This will be described at a later stage of development. 
___

##### NOTE: This is the preliminary design information for the given requirements. During reevaluation and implementation, the suggested **classes, instance variables and methods** may change as needed.  
