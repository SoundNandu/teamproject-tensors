## Project Architecture:

The idea of this project is to leverage the individual project implementation and build the following API’s.
User Profiles API
Add Card API
Managed Orders API
Payments API

## Framework:
We developed the API’s in spring boot which is an open source Java-based framework mostly used to create micro Services.

## Database:
We have used the Amazon Relational Database Service (Amazon RDS) which is a distributed relational database service by Amazon Web Services.

## Deployment:
We used Amazon EC2 instance for deploying the API’s.
We deployed the API’s to AWS in an Auto Scaled EC2 Cluster with Load Balancer as Docker Containers.

## Methodology:
Agile- We worked on the Agile Method which is a an approach to project management utilized in software development. This method assisted us in responding to the unpredictability of constructing software. We decided to go with a 1- week sprint methodology.

Test Driven Development- We practiced the TDD which helped us writing clearer, simple and bug-free code.

## Design Pattern:
We developed the API’s using the MVC (Model- View- Controller) design pattern with setter dependency injection. This pattern is used for separation of application's concerns meaning each of the components has a demarcated set of tasks which ensures smooth functioning of the entire application along with complete modularity. This makes the code a lot more readable, reusable and maintainable.

Since, we can utilize these API’s for building a web or a mobile application, the MVC pattern solves this problem as we can create different interfaces for different devices, and based on from which device the request is made, the controller will select an appropriate view. 
The model will send the same data irrespective of the device being used, which ensures a complete consistency across all devices.



Image: https://www.upgrad.com/blog/15-spring-mvc-interview-questions/?iref=Blog_Content_MVC_Architecture




![Screen Shot 2019-05-10 at 6 19 27 PM](https://user-images.githubusercontent.com/43118872/57563777-d6d25100-7356-11e9-8af1-d9b09c252a9e.png)





## Journal Week #1 - 05/04 to 05/10

## Login API (Rajshree Chauhan)
### What I have done this today
I started from looking at the architecture of the project.
Project setup and dependency installation
Writing JUnit tests for the API.
Started creating User tables and dependency for adding user details.
## What I plan to do next 5 days
Creating the data classes, interfaces and the controller for the Login API implementation.
Create methods for checking user authentication.
Create methods of getting logged in user details, adding, updating and deleting users.
Unit Test
Deployment
Documentation
## XP Core Value - Communication
I have able to facilitate continuous and constant communication throughout week 1. Initiatives I took for communicating.
Communicated with the team about different possibilities of design patterns.
Initiated a Whatsapp group discussion.
Set up a zoom meeting to discuss the roadblocks.
## Add Card API (Lalitha A)
### What I have done this today
Started working on the architecture and design pattern.
Project setup and dependency installation.
Writing JUnit tests for the Add card API.
Created database tables for the add card functionality.
### What I plan to do next 5 days
Create the data classes, interfaces and the controller for the Add card API.
Create methods for adding, updating and deleting cards.
Unit Test
Deployment
Documentation
## XP Core Value - Communication
I have able to facilitate continuous and constant communication throughout week 1. Initiatives I took for communicating.
Zoom meeting every other day
Private project group message in WhatsApp and Google hangouts.
Project integration meetings.
## Manage Orders API (Sowndhariya N)
### What I have done this today
Started working on the architecture and design pattern.
Project setup and dependency installation.
Writing JUnit tests for the Manage Orders API.
Created database tables for the order functionality.
### What I plan to do next 5 days
Create the data classes, interfaces and the controller for the Manage Orders API.
Create methods for adding new orders.
Unit Test
Deployment
Documentation
## XP Core Value - Communication
I have able to facilitate continuous and constant communication throughout week 1. Initiatives I took for communicating.
Zoom meeting every other day
Private project group message in WhatsApp and Google hangouts.
Project integration meetings.
## Payment API (Yee Zhian)
### What I have done this today
Started working on the architecture and design pattern.
Project setup and dependency installation.
Writing JUnit tests for the Payments API.
Created database tables for the payment functionality.
### What I plan to do next 5 days
Create the data classes, interfaces and the controller for the Payment API.
Create methods for adding, updating and deleting cards.
Unit Test
Deployment
Documentation
## XP Core Value - Courage
I have able to facilitate continuous and constant communication throughout week 1. Initiatives I took for communicating.
Presented ideas to implement to the team.
Always encourage everyone to try new things.
Brought Positive Energy in Team Meeting.
 
 
 
 
 




