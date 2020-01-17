

>**Author: Amin Essafi**   



# Extra Requirements    

This document contains information regarding Extra Requirements for various aspects of the application to work properly. In order to better organize the data, requirements will be, attemptively, organized by topics.    

---

## Use Case Model   

 - In order to accomplish what is proposed in the Use Case Model and to verify data persistence, the team needs:    
   - A working application with all activities, Views and activity transitions properly coded.    
   - A working database with CRUD (create, read, update, delete) functions defined and ready to use from activities that change the database.   

---   

## Design Document          

 - Something that can not be seen in the design is the data structure to use and what memory or runtime constraints we might run into:    
   - All lists will be stored as an arraylist and the reminders for each list will be stored in a hashset.    

---  

## Project Plan       

 - For this project, we must make sure the app runs smoothly and does not crash:    
   - Fragments will be destroyed whenever a new actvity is started to consrve memory.     

---   

## Test Plan          

 - In addition to expilicty testing what we have in mind, we should also test for what we haven't planned:    
   - After the testing, the app will be completed a week before the deadline and will used everyday as an actual reminder app to notice anything through regular long time use.  

---   

