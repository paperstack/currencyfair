# currencyfair
Welcome to the CurrencyFair test repo. A mock currency trading dashboard implemented at [www.thepaperstack.com](www.thepaperstack.com). Please see the notes and assumptions for the endpoints to be used for interacting w/ the system. 

##Summary
This repo contains source code for a system that is used to parse JSON formatted trade data and display it back to the user as outlined in the problem description document.

###Architecture, Implementation, and Functionality
Because of the open ended nature of this project I have chosen to leverage the [Liferay Portal Framework](www.liferay.com). Liferay is an open source Java based portal implementation that is based on other open source technologies such as Spring and Hibernate. As portlet container, it allows the developer to write and deploy portlets which offer small, distinct, and focused units of functionality (if so designed/implemented). My reasons for choosing Liferay were as follows:

* It provides a convenient modeling framework. A data object (in this case a Trade) can be modeled in an XML file and a code generator will create all the Spring/Hibernate wiring as well as sql scripts create the necessary database tables. It will also create the model classes and stub service methods where business logic can be implemented

* It provides a variety of out of the box features such as user and role management, automatic web service exposure, various portlets such as a message boards (not used) and currency converter (used). 

* It provides for development in a variety of front end development languages. PHP, JSP, JSF, Vaadin (used in this project) and others. 

* Active open source community to provide support when needed.

For the front end I have chosen to utilize [Vaadin](www.vaadin.com). A GWT based front end development framework that lets the developer write front end code in Java (similar to a Swing application). The Java code is then compiled to javascript and facilitates user interaction via a client-server AJAX communication channel.
Vaadin is also open source and has a modular architecture which allows the community to develop additional components that can be leveraged in development. The filtering table was one such add-on integration in this project.

The arching functionality of the site is as follows:

* The user is presented with a login screen on the public portion of the site. After loging in the user can go to the private portion of the site where they can see various portlets (via a drop down in the top right corner if not taken directly). 

* There are 3 primary user roles: Admin - super user that can control everything (login: Admin/admin), CFAdmin - A more limited admin user that can add only certain portlets to pages (login: cfadmin/cfadmin) but can see all trades in the system. User - Cannot do any site management and can only view their own trades. To facilitate testing a new user will be created every time a trade is processed and the user id associated with the trade has not been created previously. The login of the newly created user will be their user id as the login and password. For instance if we have 3 trades trade1 - userid:134265 trade2 - userid:134266 trade3 - userid:134265, after processing these trades there will be two new users in the system 134265/134265 and 134266/134266. The tester can then login w/ each respective login.

* There is only one page with functionality of consequence (ie: not admin or login). This page has 5 portlets, 4 of them have been developed for the test and one (Currency Calculator) is an example of an out of the box functionality that was leveraged w/ out writing any code. Each custom portlet has a *UI class in the src folder which is responsible for gathering and displaying the content. The following is a list of the developed portlets (the names will correspond to the folder names in source) and their functionality. 

* tradedisplay - This portlet presents a list of trades that belong to the user (or all trades if admin). This portlet will allow an admin to delete trades (for testing purposes only) as well as filter by putting in text or appropriate criteria in the column headers. In addition to displaying trades this portlet will drive the content for all the other portlets aside from Currency Converter. As trades are filtered, the content on all other portlets will be updated to show only the data that corresponds to the visible trades. The content will either be updated manually by clicking a button, or automatically, depending on the setting which is provided in the portlet user interface. Inter portlet communication is provided by an addon component which allows providers to send events, and listeners to respond to the events. So as content changes, update events are sent out, and all portlets that are registered to listen to the update event will update their own content accordingly.

* trademap - This portlet is only visible to the admin/cfadmin roles. Its an example of container imposed permission checking (ie: regular users will be given an error message saying they dont have the rights to view the content). This portlet will draw a heat map of all the trades currently displayed in the selection table by their originating country. The heat zones get more pronounced with volume so the more trades there are in the system the better the map looks. 

* tradematrix - This portlet shows a matrix of how many times currency X has been converted to currency Y. 

* tradesums - This portlet will show how many times each currency has been converted from and how many times it has been converted to. In addition it will will display two pie charts. One for the "from" data and one for the "to" data (ie: 50 trades USD->GBP, 50 trades EUR - > GBP will show 50/50 USD/EUR and 100 GBP). The charts are interactive, clicking on a currency in the legend will exclude that currency from the data and redraw the pie. 

In addition to the portlets there is a service layer responsible for data processing(TradeService). There are two subfolders: TradeService-portlet which has implementation and wiring code, and TradeService-portlet-service which has interface classes used by clients. A lot of the code is system generated plumbing but the classes of note are described below:

* /TradeService-portlet/src/main/java/com/currencyfair/service/impl/TradeServiceImpl.java - This class provides functionality to the web services layer and will consume the JSON data and create a Trade object to be stored in the database

* /TradeService-portlet/src/main/java/com/currencyfair/service/impl/TradeLocalServiceImpl.java' - This class will provide CRUD functionality as well as helper lookup methods. This class will have an enumeration of locales that will be used for originating countries (along w/ the coordinates for the map portlet). Basic validation has been implemented in that a trade will not be added to the system if the originating country is not in the locale list. Other validation should be done for a real deal production system such as to/from amounts matching the conversion rate but this was left out of this implementation. 

* /TradeService/TradeService-portlet/src/test/java/com/currencyfair/test/TradeTest.java - This is a basic unit test meant to be a jumping off point for further unit test development. It will check the locale lookup functionality in the TradeLocalServiceImpl class. Due to the various wiring mechanisms of the Liferay framework setting up additional JUnit tests was too time consuming for the scope of this project

* /TradeService/TradeService-portlet/src/main/webapp/WEB-INF/service.xml - This file contains the model description used to generate the wiring classes.

####Notes and assumptions
* JSON data will be in the following format: '{"userId": "134265", "currencyFrom": "EUR", "currencyTo": "USD", "amountSell": 100000, "amountBuy": 74710.00, "rate": 0.7471, "timePlaced" : "14-JAN-15 10:27:44", "originatingCountry" : "US"}'
* The date in the trade is in day-month-year format. As the example date was 14-Jan-15 its possible that it could be in year-month-day format but the former seemed to make more sense.

* rate will always be correct. An incorrect rate will not be validated and will be accepted by system. 

* The liferay webservices mechanism will not accept JSON in the message body with out it being associated with an x-www-form-urlencoded parameter. To get around this a proxy portlet was developed to retrieve the message body from the request and call the backend service to do the processing. While this will work in inserting data it is slower than going against the webservice. Therefore the following url's can be used for interfacing w/ the system.

Direct webservice call url: http://thepaperstack.com/api/jsonws/TradeService-portlet.trade/add-trade/ 

Curl Example:
curl http://thepaperstack.com/api/jsonws/TradeService-portlet.trade/add-trade 
  -d json='{"userId": "134265", "currencyFrom": "EUR", "currencyTo": "USD", "amountSell": 100000, "amountBuy": 74710.00, "rate": 0.7471, "timePlaced" : "14-JAN-15 10:27:44", "originatingCountry" : "US"}'
  
 Indirect webservice call url: http://thepaperstack.com/web/guest/dummy?p_p_id=jsonlistener_WAR_JSONListenerportlet&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1
 
 Access to console url: http://thepaperstack.com/group/guest/trades


