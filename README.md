# reefnexus
<img src="mockuppics/logo.JPG" width="500px"/>
## Overview
Although there are many fish databases available, there are few applications that quickly lets an individual observe the reef fish ecology occurring in their local area.  Reef Nexus is a crowd-sourced application aimed towards divers and fishermen which stores the location of fish species, based on a user's own encounter/knowledge with that particular species.  The initial application will survey the Hawaiian Islands, and the database will have a full list of Hawaiian reef fish.  A user can create an account where they can choose and store a list of fishes they have encountered and the location of where they encountered them.  It will be saved in their own list for reference.  Those without accounts can enter a species location, but they will not be able to save a list.

The main page will contain a map of a default location (Oahu for now) or the user's own current location.  Each location will have statistics on the abundance of various fish based on the information provided by site users.  These will be the most basic functions of the website, and will be the main focus.

Extended functions include users contributing their own data on species of fish not already included in the database, and perhaps their own individual maps of personal encounters.

Possible issues include temporal change in fish locations and incorrect information (spamming, etc), although reef species tend to be static, and entries will be moderated by administrators.

The ultimate goal of the application is to provide ocean-enthusiasts with information on the abundance of various fish species in a specific area, so they have an idea of what they will encounter.  This will give snorkelers, divers, and fishermen a good idea of where to find species of interest.  The database will also offer detailed information for each fish, along with their abundancy for all areas in which they occur in.  

## Approach
The core components for this application, at least for the first deliverable, will be the map and reef fish database.  For the map, we will be utilizing the Google Maps Javascript API, and integrating it within our application so that we will be able to map the coastal areas of the island to specific names.  When a user clicks in a defined area on the map, a description will be provided with a list of fish species, and a user will be able to add a fish that they have spotted to this location.  A user can also choose not to click on a specific location, and instead have the app geolocation function automatically detect where they are.  This is useful for on-the-go fish adding, or if the user do not know their current location.

The exact calculation for abundance ratings for each fish is still being considered, but for now it will be a percentage termed "sighting rate", and will be based on the number of times seen by users compared to other fishes in the area.  Each location will have sighting rates independent of other locations.  

As for the reef fish database, it will contain a good amount of common reef fish, and there will be a detailed description with each species along with areas that they were sighted in, along with their respective sighting rates for each area.  At least for the first deliverable, this database will be limited to Hawaiian species.  

A login system will be implemented where users can view the fishes that they have sighted themselves.  Although right now the options are limited for members, there will be communial features added that will make the application more community friendly.  These options are discussed in the deliverables.

## Deliverable 1
Users will be able to add to the database of where they saw a particular fish.  In the fish database, the user will be able to search for a fish given certain parameters.  However, the fish database won't be implemented until later.  Another functionality is that given a location on an image of Oahu, our application will be able to display the fishes found at that location and its sighting rate.  Users will be able to sign in to add fishes, check their sighting and see a record of their record activity.
## Deliverable 2
Adding to the previous functionality of the application, the users will be able to
## Deliverable 3
Adding to the application's functionality will be a fully functional database with the detailed information about the reef fishes.
## Mockup

Home Page:
This page offers the main feature of viewing fish sighting rates for a user's current location.  Clicking on the map or having the GPS find your location will list the details on the right pane.  Additionally, the obnoxious add button will allow users to add fish they have sighted at the current location.  

Home Page (Desktop View)

<img src="mockuppics/home.JPG" width="700px"/>

Home Page (Mobile View)

<img src="mockuppics/homesmall.JPG" width="700px"/>

Add Fish Page:
The add fish function brings the user to this page, which requires several parameters.  First is the location, which will automatically be filled out if the user started from the home page.  The second parameter is the fish species itself, and there will be autocomplete so users will actively see a list of fish according to what they type in (common name and scientific name).  The third function will be for users who want to add a picture of the fish they sighted.  If a user cannot identify the fish, they can add a picture which will be available for others to see and confirm on the database page.

Add Fish Page (Desktop View)

<img src="mockuppics/addfish.JPG" width="700px"/>

Add Fish Page (Mobile View)

<img src="mockuppics/addfishsmall.JPG" width="700px"/>

Database Page: 
This page will allow users to search for fish in the database.  As of now, the available parameters will be common name, scientific name, family name, and location.  A second informational pane on the page will contain a list of fish that are curently unidentified but were seen by others.  Users will have the option to identify the fish should they know it.  

Database Page (Desktop View)

<img src="mockuppics/database.JPG" width="700px"/>

Database Page (Mobile View)

<img src="mockuppics/databasesmall.JPG" width="700px"/>

Login Page:
Page where members can log in and complete various tasks and observe their recent activity.

Login Page (Desktop View)

<img src="mockuppics/login.JPG" width="700px"/>

Login Page (Mobile View)

<img src="mockuppics/loginsmall.JPG" width="700px"/>

User Page:
This is the page users are greeted with when they log in.  Available tasks are listed in the left pane, whereas recent activity by the user will be presented in the middle-right pane.  One of the main draws for a user to register as a member is to view the fish that they have added themselves, so they may be able to reference them later.  Many of the later deliverables will add user features that will be listed on this page.  

User Page (Desktop View)

<img src="mockuppics/user.JPG" width="700px"/>

User Page (Mobile View)

<img src="mockuppics/usersmall.JPG" width="700px"/>
