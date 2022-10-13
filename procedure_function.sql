-- Bảng employees
name         country       salary
A	    VIETNAM	    4
B	    VIETNAM	    6
C	    ENGLAND	    3
D	    ENGLAND	    7
F		NULL        10

-- Tạo PROCEDURE
DELIMITER //
CREATE PROCEDURE insert_emp (INOUT var1 VARCHAR(20), OUT var2 VARCHAR(20))
BEGIN
	SELECT name, country INTO var1, var2 FROM employees WHERE salary = var1;
END //
DELIMITER ;

-- Tạo FUNCTION
DELIMITER $$
CREATE FUNCTION getMaxSalary ()
RETURNS INT
DETERMINISTIC  
BEGIN
	DECLARE maxSalary INT; 
	SELECT MAX(salary) INTO maxSalary FROM employees;
    RETURN maxSalary;
END $$
DELIMITER ;
