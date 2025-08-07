# Messaging_Microservices
Messaging Microservice project using  Java, Spring Boot, MySql testable with PostMan

before testing it on postman:
change the message service , user service yaml files in the config server project to set the mysql url of your personal database.
for testing:

to signup:
use this url in postman
http://localhost:8082/userservice/signup and set to postmapping and go to body tab and set to send as jsonfile add your detials 
{
"username":"yourusername",
"password":"yourpassword"
}
in the yourusername and yourpassword set your own username and password respsectively and send ;

to login:
use this url in postman,
http://localhost:8082/userservice and set to getmapping and in the authorization tab set type to basic authentication and put your username and password in the respective fields and send . if successful youll see "signed in Successfully".

to get users / know their usernames:
use this url http://localhost:8082/userservice/getusers with the getmapping and send.
(note: the authorization tab should be in basic auth and your login detail deatails needs to typed )

to get friends / users you have chatted with before:
use this url http://localhost:8082/userservice/getfriends with the getmapping and send.
(note: the authorization tab should be in basic auth and your login detail deatails needs to typed)

to send message to users/friends:
use this url http://localhost:8082/userservice/sendmessage with the postmapping and like signup 
go to body tab and set to send as json file and type...
{
"tousername":"the user name you want to send message to",
"message":""your message to the user"
}
type the username of the recipient of the message in tousername section and message in message section and send
(note: the authorization tab should be in basic auth and your login detail deatails needs to typed )

to view message/conversation with a specific user you had previously:
use this url http://localhost:8082/userservice/viewmessage/[type the username] in postmapping and type the user name of the one you want to see messages , at the end of the url after / and send


