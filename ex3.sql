
CREATE or replace function my_function
		    RETURNS trigger as $$
		    begin
		 	 if (
                referencing new row as nrow
                for each row
		 		 when (nrow.time_slot_id in (
		 		 select time_slot_id
		 		 from teaches natural join section
		 		 where id in (
		 					  select id
		 					  from teaches natural join section
		 					  where sec_id = nrow.sec_id and course_id = nrow.course_id and
		 					  semester = nrow.semester and year = nrow.year
		    ))))
		    end ;
		    $
		    CREATE or replace trigger my_function before insert on teaches 
		    for each row execute procedure my_function() ;

CREATE or replace function my_function
		    RETURNS trigger as $$
		    begin
		 	 if (
                referencing new row as nrow
                for each row
		 		 when (exists (
		 		 select time_slot_id
		 		 from teaches natural join section
		 		 where id = new row.id
                 intersect 
                 select time_slot_id
                 from section
                 where sec_id = nrow.sec_id and course_id = nrow.course_id AND
                 semester = nrow.semester and year = nrow.year
                 )
                 ))
		    end ;
		    $
		    CREATE or replace trigger my_function before insert on section 
		    for each row execute procedure my_function() ;

--Solution from the reference attached
           