
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
* 
* ASSESSMENT 1:		Employee events organiser/ communication platform
* 
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *


FUNCTIONAL OBJECTIVE:
Build an application to manage the organisation of company events.
Application will allow a (relevant) user to register for an upcoming event.
A registration confirmation will be sent to the user as soon as they register.
A "thankyou" message will be sent to all users after the event finishes.



---------------------------------------
TECHNICAL OBJECTIVES:
Demonstrate use of S.O.L.I.D. principles where appropriate.
Implement a basic data structure/model to store attributes & information on employees 
	(contact info, email address, etc)
Allow for multiple types of employee (each with different attributes, but some traits in common).  
Separate out functionality to allow piecewise replacement of parts.
	e.g. we want to email confirmations currently, but may switch to SMS down the line.
Simulation is sufficient for functions such as delayed messages being sent/ scheduled for 
	specific time. Registration confirmation can be represented by just println().
	
	
----------------------------------------
DESIGN FEATURES:
"BaseEmployee" parent class, contains the attributes and capabilities (methods) which
	all relevant employee groups can perform. Therefore we can just extend BaseEmployee,
	and add extra attributes and features unique to each subclass. 
	This also reduces code duplication (D.R.Y.)
Interfaces ("IEmployee"), etc help us to loosely couple the system. Rather than  a consumer
	class requesting a specific service class (which it shouldnt really "have to know" anything
	about other classes in the system), we have it implement an interface (like a contract)
	stating that in order for it to work correctly, it will NEED a pointer to a class which 
	can fulfill all duties stipulated in Interface. 
	Likewise, for a service class to be "usable", it must state that it implements "myInterface"
	AND include all relevant functionality. 
	Great e.g. is a "Communications Service" interface. We're just going to email employees for
	now, but later might switch to SMS. Therefore, to loosely couple this, we need to generalise
	the class, so we want something which can "send a message", and later possibly receive too,
	and some other management and protocol setup methods(this wasnt part of required design spec).
Used ArrayList for simple way to allow attendees list to grow as needed (arrays wouldnt do).
	Also this is other good e.g. of interfaces; the "type" of arraylist==IEmployee,
	which is the simplest way i could have an attendee list containing multiple types of attendee
	(contractor, manager, etc). otherwise i probably would have needed one list for each type.