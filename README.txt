This project contains the tests4j gwt framework,
which compiles into javascript so you can run 
java script tests in a 
java script test framework
for javascript code generated from GWT

This allows you to actually write tests
that run in JSE and java script
WITHOUT rewriting the test (if you do it right).

It also allows you to write tests vs the views
and other GWT code that is client specific.

This project will NOT be for a GWT Remote control, 
however there may become a tests4j_browser_harness project
which would allow you to target a single browser window
application (with a potental for multhreaded ground up
any device installable test harness using gwt), for testing of multiple windows you 
could fall back to Selenium.
Also if there does become a tests4j_browser_harness it may use Selenium
to open windows/tabs for it (passing just the urls, and browser window/tab would 
run their own test/threads.
Perhaps there would be a run in 'check me manually' mode as well
where any tester would simply need to open the url on the device,
and the server would be configured where to store the test results
after they were uploaded.  As long as your application architecture
is stateful (session cookie is not used/ instead session id is passed
on each request/web socket), you should be able to test multiple users 
on multiple threads on a single machine.  This would give you a good idea 
of the loads you could handle.
   This would also potentially allow you to have a huge usb bus of devices that
got the simple device.openUrl(String).
There are lots of design options here;
In one design the device would connect to the server the trial would connect to the server, 
the trial would control the tests through the server.  This way there could be a Selenium
thread that just opened urls, and returned which window/tab was opened.  
The selenium thread would open a new tab/window (api needs some thought) for the test,
the url would be a server hosting the tests4j_gwt_harness, and the remote control
would just be http up and down on the trial/test thread.

