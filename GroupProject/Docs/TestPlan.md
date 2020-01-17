# Test Plan

**Author**: Team5a

## 1 Testing Strategy

### 1.1 Overall strategy

We will manually test all of our functions and methods, we will also test front-end widgets and all GUI. 

### 1.2 Test Selection

We will use black-box testing to test front-end widgets and GUI and white-box to test back-end functionality if all methods and functions are working properly.

### 1.3 Adequacy Criterion

We will doing manual testing on most levels which we will manually fix or re-figure to solve any issues.

### 1.4 Bug Tracking

We will me implementing manual testing for all levels of app development, if encounter with various bugs we will communicate through slack to resolve as a team or to re-configure to alleviate the issue. All issues will be recorded through some level of version control where we will record what were the issues and what was changed.

### 1.5 Technology

All testing and usage of the application will be done on Android as of now further testing scenerios will be looked upon further into development to see which will be the best route depending on the issues at hand. 

## 2 Test Cases


|Purpose | Steps | Expect | Results | Pass/Fail |
|-------|--------|--------|---------|--------|
|Scrollability  |1.Open app to homepage with all reminder lists 2. View List(s) 3. Access/View all items on your list|You can scroll down to see all the items|         | Undetermined
|AddItemToDB |1.Open app to homepage with all reminder lists 2.View List(s) 3. View Items on the list 4. Search the database for an item you want to add 5. If item not listed, create a new item by giving its name and type| Allows user to add items to the database|         | Undetermined
|AddItemToList |1.Open app to homepage with all reminder lists 2. View list(s) 3. Access the list 4. Search the database for an item you'd like to add 5. Add Item to list|User is able to add item to the list and see it displayed on their list|          | Undetermined
|RemoveItemFromList |1.Open app to homepage with all reminder lists 2. View list(s) 3. Select an item to remove from the list|User was able to remove item from the reminder list|        | Undetermined
|CreateList |1.Open app to homepage with all lists 2. View List(s) 3. Create a new reminder list by entering a name, regardless of whether there exists a list or not|User should be able to create a new reminder list|         | Undetermined
|RemoveList|1.Open app to homepage with all reminder lists 2. View List(s) 3. Select a list the user wants to delete|User should be able to remove a reminder list|         | Undetermined
|RenameList |1.Open app to homepage with all reminder lists 2. View List(s) 3. Hold down on the list you want to rename|User should be able to rename a reminder list|         | Undetermined
|SearchForItem |1.Open app to homepage with all reminder lists 2. View List(s) 3. When adding an item the user should be able to type in the name of the item they are searching for and the app should respond in real time by showing results that are similar to what they are typing|User should be able to see the item they are searching for and those items with similar names|       | Undetermined
