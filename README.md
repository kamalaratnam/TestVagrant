# TestVagrant

Hi,

I have Created a Repository Based on the requirement.
Here, I have We have Two Packages under src/main/java. First one is com.Page, In this package we have Two Page Classes. In these Page Classes I ahev saved the Object and methods reuired in that particular Page. In The Second Package (com.Utility), We have Reusable Functions and classes which implements some of the lisners used to generate the reports.
In src/test/java, I have one Package called com.testscripts. Here I have one class MovieInformation.java. In this particular class I have the Testscripts reuired to complete the requirement.
In src/test/resources, I have MovieInfo.xml. In MovieInfo.xml, I gave the Urls of th IMDB and Wiki, I gave the MovieName as parameter. Suppose if you need to execute for another movie, we need to change the moviename parmeter in this xml.

For running, we need to rightclick on the MovieInfo.xml and click on Runas>> TestNg Test.
After completion of the execution you can find the MovieInfo.html report in test-output folder and Screenshot for the failure testcases in Target Folder with the methodnameFollowed.
