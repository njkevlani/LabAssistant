# LabAssistant

This is an java based application that helps a Lab Assistant to supervise students' activities during a Lab session. 

Mainly this entire project is devided into two parts:
* An client side application, that is installed on each student's computer
* An server side application, that is installde on Lab Assistant's computer

Each client is initialized and connection to server is established.

On request by server computer, The client side program captures the screen and sends the screenshot to server at an interval of 5 seconds. Somple concepts of Socket programming are used to achive this functionality.
