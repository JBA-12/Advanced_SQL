# Advanced_SQL

This the code written as part of the Assignment of Introduction to DBMS II course.

In this, the Database Queries are Accessed and Executed using JDBC.

A university database from the following link has been used for this work <br>
https://www.db-book.com/university-lab-dir/sample_tables-dir/index.html <br>
<strong>DDL.sql</strong> file has the code to generate all the required tables and <strong>largeRelationsInsertFile.sql</strong> contains the required data about the database to be inserted into the created tables.<br>
<strong>ex1.java</strong> is a Java method that takes the name of a table and row count k as input from the user, and then prints the table with appropriate names as column headings and any k rows of the table. <br>
<strong>ex2.java</strong> is a Java program using JDBC that takes course_id from a user and then prints all the prerequisites (also includes prerequisites of prerequisites) of the given course.<br>
<strong>ex4.java</strong> is a Java program that takes as input the roll number of a student and then prints the CGPA of the student else if the input roll number does not exist, then prints an error message. <br>
<strong>ex4.sql</strong> code first adds an extra gp column to the table takes where gp is grade-points and then creates a view named cgpa including all the required attributes for calculating the cgpa of the student. <br>
<strong>ex5.sql</strong> code creates a view output from the view created in ex4.sql which calculates the cgpa of the students. <br>
<strong>ex5a.java</strong> contains Java Program that allows university administrators to print the Top-k students with highest CGPA. <br>
<strong>ex5b.java</strong> contains Java Program that allows university administrators to print the Top-k students with highest CGPA in a given department. <br>
<strong>ex5c.java</strong> contains Java Program that allows university administrators to print the Top-k students with highest CGPA enrolled in a given course. <br>

<strong>output.pdf</strong> file contains the results obtained after running the codes for some examples.
