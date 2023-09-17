# CLI BASED EMAIL CLIENT
The email client has two types of recipients, official and personal. Some official recipients are close friends.Details of the recipient list are stored in a text file.  An official recipient’s record in the text file has the following format:
official: \<name\>, \<email\>,\<designation\>. 

A sample record for official recipients in the text file looks as follows:
Official: nimal,nimal@gmail.com,ceo

A sample record for official friends in the text file looks as follows (last value is the recipient's birthday):
Office_friend:kamal,kamal@gmail.com,clerk,2000/12/12

A sample record for personal recipients in the text file looks as follows (last value is the recipient's birthday):
Personal:sunil,<nick-name>,sunil@gmail.com,2000/10/10


When the email client is running, an object for each email recipient is maintained in the application. For this, application will load the recipient details from the text file into the application. For each recipient having a birthday, a birthday greeting should be sent on the correct day.Different messages are sent for official friends and personal recipients (e.g. Wish you a Happy Birthday. \<your name\> for an office friend, and hugs and love on your birthday. <your name> for personal recipients). But all personal recipients receive the same message, and all office friends receive the same message.  A list of recipients to whom a birthday greeting is maintained in the application, when it is running. When the email client is started, traverse this list, and send a greeting email to anyone having their birthday on that day.


Command-line options are available for:

- Adding a new recipient
- Sending an email
- Printing out all the names of recipients who have their birthday set to current date
- Printing out details (subject and recipient) of all the emails sent on a date specified by user input
- Printing out the number of recipient objects in the application
