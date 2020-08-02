# MAD-Team2-Assignment
## Team members' names, Student IDs<br/>
1)Goh Qi Xun, S10192811B<br/>
2)Yip Jun Wei, S10198567B<br/>
3)Kamarul Aszryn Bin Jalil, S10198273F<br/>
4)Tan Guan Teck, S10198165K<br/>

## Problem Statement

Have you ever struggled on deciding what career path to pursue in the future? Have you ever been indecisive about what course to select?

## Description of app

“Learning@NP” app is an excellent way for graduating students who are deciding what course they want to join in Ngee Ann Polytechnic. Our app provides many functions including a survey to give the students a better insight or clearer view of what path they want to choose. Our app also allows students to learn more about Ngee Ann Polytechnic with functions ranging from “Book Prices” to “Academic Calendar”.

Some of the features we hope to implement in the future:<br/>

- Implement a GPS to navigate visitors/new students.<br/>
- More In-depth information about each course.<br/>
- Allow students to purchase textbooks.<br/>
- Use online cloud storage (Firebase) to store information.<br/>
- Search Bar to allow users to search for specific courses and textbooks.<br/>
- Side menu for more navigation around the app.<br/>
- Create an admin user that allows them to add textbook, courses, other information, etc.<br/>

## Target Audience<br/>
Our target audience is graduating Secondary School students and ITE students planning to join Ngee Ann Polytechnic.Freshies that are new to the school.<br/>

## Basic features of our app<br/>
-Our app is responsive, allows the app to orientate and use for different sizes of phone<br/>
-Has a recycler view <br/>
-Includes SQLite and sharedpreferences <br/>
-Has multimedia <br/>

## Things that have been implemented<br/>
- GPS<br/>
- Admin to allow them to add textbook, courses, other information, etc.<br/>
- Used online cloud storage (Firebase) to store information.<br/>

## Roles and contributions of each member<br/>

**Jun Wei :**<br/>

AndroidManifest<br/>
-Programmed the actionbar so that there will be a back button to navigate to parent class<br/>

LoginPage<br/>
-Used SQLite and sharedPreference<br/>
-Programmed LoginActivity,MyDBHandler,UserData<br/>
-Used Event handling(Toast)<br/>
-Used responsive(OnFocus)<br/>

Homepage <br/>
-Programmed the Cardview Design <br/>
-Programmed and Design the Floating Action button<br/>

SignUp<br/>
-Used SQLite and sharedPreference<br/>
-Programmed SignUpActivity<br/>

Settings<br/>
-Used Linear View<br/>
-User SharedPreference<br/>
-Used Event Handling(Alert)<br/>
-Programmed SettingsActivity,ChangePassword Activity<br/>

ChangePassword<br/>
-Used SQLite and sharedPreference<br/>
-Programmed ChangePasswordActivity<br/>
-Used responsive(OnFocus)<br/>

CourseSuits/Quiz<br/>
-Programmed StartQuizActivity<br/>
-Used Intent to passdata(array)<br/>

Result<br/>
-Programmed ResultActivity<br/>
-Used Intent to received data(array)<br/>

GPS<br/>
-Programmed GPSActivity<br/>
-Used Map SDK for android and directions API<br/>
-Used Polyline to map out the route<br/>
-Used OnLocationChanged and Looper to constantly get user's current location<br/>
-Used try catch for error handling<br/>
-Used Floating Action button for better UI <br/>
-Used fragment to overlay two layouts together<br/>


Design<br/>
- Designed the app logo<br/>
- Admin main page banner<br/>
- appstore app preview banner<br/>

**Qi Xun :**<br/>

Homepage<br/>
-Design the layout of the page<br/>

CourseSuits/Quiz<br/>
-Design the instruction page<br/>

School<br/>
-Program and design the activity<br/>
-Used RecyclerView<br/>
-Created Model for the schools<br/>
-Used CardView for each RecyclerView row<br/>

Courses<br/>
-Used RecyclerView<br/>
-Created Model for courses<br/>
-Used CardView for each RecyclerView row<br/>

StartQuiz<br/>
-Created Model for the quiz to store data in list<br/>
-Override “Collections.sort” method in Model for sorting<br/>

BookPrice<br/>
-Designed the layout and the row<br/>

ContactUs<br/>
-Designed the layout<br/>

GeneralContact<br/>
-Designed the layout for each row<br/>
-Created Model<br/>

AcademicContact<br/>
-Designed the layout for each row<br/>
-Created Model<br/>

LoginPage<br/>
-Updated design for Login Page<br/>
-Programmed Forget password<br/>

Others<br/>
-Added scroll view in most layouts for responsiveness.<br/>
-Converting Constraint to Linear layout for responsiveness<br/>

Admin<br/>
-Designed Admin page <br/>
-Programmed Admin add courses <br/>

-Live Chat <br/>
-Programmed Live Chat for Admin and User<br/>

Create Account<br/>
-Programmed create account <br/>
-Changed SQLite to Firebase <br/> 

Splash Screen <br/>
-Programmed Splash Screen  <br/>
-Design Splash Screen <br/>

User Info  <br/>
-Programmed and design User Info Paged

**Kamarul :**<br/>

BookPrice<br/>
-Used RecyclerView<br/>
-Programmed BookActivity,BookAdapter,BookModel,BookViewHolder<br/>

AcademicContact<br/>
-Help key in more contact information<br/>
-Created RecyclerView<br/>

Help in design of LoginPage<br/>

Research on Quiz questions<br/>
-Help research on questions for quiz<br/>

Result<br/>
-Design for Result Page<br/>

Updated Documentation<br/>

Admin<br/>
-Programmed AddBookActivity<br/>
-Designed AddBookActivity<br/>

**Guan Teck :** <br/>

AcademicCalendar layout<br/>
-Designed using relativelayout and scrollview<br/>
-Programmed AcademicCalendar

GeneralContact layout<br/>
-Helped in keying more additional information<br/>
-Created RecyclerView

CourseSuits/Quiz layout<br/>
-Designed 1st draft for this layout

Homepage video<br/>
-Programmed to mute video<br/>
-Programmed video in homepage

Research on Quiz questions<br/>
-Done some research for quiz questions.<br/>

Updated Documentation<br/>

Designed icons<br/>

AutoLogin<br/>
-Programmed application to autologin
-Programmed admin role to admin page, user role to user page<br/>

Login<br/>
-Programmed LoginPage<br/>
-Changed SQLite to Firebase<br/>
-Used sharedpreference for Remember Me checkbox<br/>
-Programmed admin role to admin page, user role to user page<br/>

Change Password<br/>
-Programmed ChangePassword<br/>
-Changed SQLite to Firebase<br/>
-Used sharedpreference for Current Password<br/>

Sign out<br/>
-Programmed Sign out<br/>
-Changed SQLite to Firebase<br/>


## Relevant appendices (diagrams, screenshots, user guides)<br/>

Discussion on Health/Fitness App<br/>
<img src="Images/mad_discussion.png" width="450"><br/>
<img src="Images/mad_discussion2.png"><br/>

Decided to change idea from Health/Fitness app to Education app<br/>
<img src="Images/mad_discussion3.png">

## User Guide for our app<br/>

LoginPage<br/>
User inputs their username and password and presses the ‘LOGIN’ button to log in. They can click "Remember Me" to remember their credentials and "Stay Logged In" if they do not want to type out their username and password to login. For new users, they can click the "New user? Sign up here" to sign up.<br/>
<img src="Images/mad14.PNG" height="500">

SignUpPage<br/>
User inputs their credentials for their account. They can click on the ‘eye’ beside the password textbox to reveal the password they typed in. After finishing typing in their credentials, the user clicks on the “SIGN UP” button to complete their signup. For users that accidentally clicked to sign up, they can click “Already have an account? Return to login” or pressing the back button to go back to the login page.<br/>
<img src="Images/madsignup.png" height="500">

HomePage<br/>
In the homepage, above the text "WELCOME,ADMIN" there will be a video playing. This page is in cardview and users can click on the respective cardviews to go to the page stated in the text.<br/>
<img src="Images/madhomepage.png" height="500">

SchoolsPage<br/>
This page is a RecyclerView and shows all the schools in Ngee Ann Poly for users to see. Users can click on the respective images to see available courses in that school.<br/>
<img src="Images/mad2.PNG" height="500">

CoursesPage<br/>
This page is a RecyclerView and shows all the available courses for the respective schools in Ngee Ann Poly for users to see.<br/>
<img src="Images/mad3.PNG" height="500">

CourseQuizPage<br/>
This page uses a linear layout with scrollview and displays the image and instructions for the quiz. Users can click the “Start Quiz button” to start the quiz.<br/>
<img src="Images/mad4.PNG" height="500">

QuizPage<br/>
This page uses a linear layout with scrollview and displays the questions for the quiz. Users click on the radio buttons to pick their answers. After finishing the quiz and clicking submit, they will be shown the result of the school they are well fitted for.<br/>
<img src="Images/madquiz.png" height="500">

ResultPage<br/>
This page uses a linear layout with scrollview and displays the result after finishing the quiz. Users can click on the “RE-TRY QUIZ” button to do the quiz again, or click “BACK TO MAIN MENU” to return to the homepage.<br/>
<img src="Images/madresult.png" height="500">

AcademicCalenderPage<br/>
This page uses a linear layout with scrollview to display the academic calendar for the current year. It also implements a countdown function for days until the next holiday.<br/>
<img src="Images/mad6.PNG" height="500">

BookPricesPage<br/>
This page is a RecyclerView that displays some books that are shared between courses in the same school for users to see the price.<br/>
<img src="Images/mad7.PNG" height="500">

ContactPage<br/>
This page uses a linear layout with scrollview to display the address and opening hours of the campus. It also uses a cardview with relative layout where users can click on the card to go to ‘General Contact’, ‘Academic Contact’ pages. For the ‘QUALITY SERVICE FEEDBACK’, users will be asked to  choose their preferred web browser, and will be directed to a webpage where they can give feedback/comments on the service.<br/>
<img src="Images/mad8.PNG" height="500">

GeneralContactPage<br/>
This page is a RecyclerView that displays general contacts from Ngee Ann Poly. Users can call the number or mail the email for any enquiries.<br/>
<img src="Images/mad9.PNG" height="500">

AcademicContactPage<br/>
This page is a RecyclerView that displays academic contacts from Ngee Ann Poly. Users can refer to the telephone and email to contact the respective people.<br/>
<img src="Images/mad10.PNG" height="500">

SettingsPage<br/>
Users can come here to change their password and to sign out from the current account they are logged in to.<br/>
<img src="Images/mad11.PNG" height="500">

ChangePasswordPage<br/>
This page uses a linear layout with scrollview and displays textview to input the old and new passwords. Users input their current password and also their new password twice. After that, they can click the “CONFIRM” button to confirm changing their password or click the “CANCEL” button to return to the settings page.<br/>
<img src="Images/madchangepw.png" height="500">

GPS Function<br/>
This allows user to navigate user to certain blocks of the school.<br/>
<img src="Images/usergpsfunction2.png" height="500">

AdminHomePage<br/>
This page is similar to user homepage as it uses cardview and the admin users can click on the respective cardviews to go to the page stated in the text.<br/>
<img src="Images/madadminhome.jpg" height="500">

AdminModifySchoolPage<br/>
This page is a RecyclerView and shows all the available courses for the admin to modify. The admin can swipe left to update the course or swipe right to delete the course.<br/>
<img src="Images/adminmodifyschool.jpg" height="500">
<img src="Images/adminupdatecourse.jpg" height="500">
<img src="Images/admindeletecourseinfo.jpg" height="500">

AdminAddCoursePage<br/>
This page is for admin users to add a course to a chosen school.<br/>
<img src="Images/adminaddcourse.jpg" height="500">

AdminAddBookPage<br/>
This page is for admin users to add a new books to the book price listing for users to see.<br/>
<img src="Images/adminaddbook.jpg" height="500">

AdminSettingsPage<br/>
This page is similar to normal user settings as it allows the admin to change the password of the admin account and to sign out of the account.<br/>
<img src="Images/adminsettings.jpg" height="500">

