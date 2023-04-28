/*Inserting Values*/
Insert into regions(region_name)
values ('North America'),
('Cerntal America and Carribean'),
('South America');

Insert into countries(country_name, region_id)
values ('United States', 1),
('Canada', 1),
('Mexico', 1),
('Jamaica', 2),
('Belize', 2),
('Costa Rica', 2),
('Brazil', 3),
('Argentina', 3),
('Chile', 3);

Insert into locations(street_address, city, state_province, postal_code, country_id)
values ('6400 Main Steet', 'Houston', 'Texas', '77005', 1),
('27 Maple Lane', 'Smallville', 'Kansas', '66204', 1),
('24 Sussex Drive', 'Ottawa', 'Ontario', 'K1M 1M4', 2);

Insert into departments(department_name, manager_id, location_id)
values ('Customer Service', 1, 1),
('Computer Systems', 2, 1),
('Build your Own PC', 3, 1),
('Warehouse', 4, 1),
('Customer Service', 1, 2),
('Computer Systems', 2, 2),
('Networking', 3, 2),
('Warehouse', 4, 2),
('Customer Service', 1, 3),
('Build your Own PC', 2, 3),
('Do It Yourself Electronics', 3, 3),
('Warehouse', 4, 3);

Insert into jobs(job_title, min_salary, max_salary)
values ('Customer Service Represenative', 25000, 30000),
('Manager', 30000, 45000),
('Sales Representative', 30000, 45000),
('General Manager', 35000, 50000),
('Warehouse Associate', 25000, 30000);

Insert into employees(first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
values ('Drew','Burnham','mb123@gmail.com','(682) 555-5555','2020-08-01', 1, 25000, 0, 1,1),
('Abigail','Charles','anitac1@gmail.com','(482) 555-5555','2014-09-20', 4, 40000, 2, 4,1),
('Millard','Jarred','mjarred2@yahoo.com','(262) 555-5555','2019-05-17', 3, 35000, 5, 3,3),
('Arthur','Mann','amann45@gmail.com','(713) 555-5555','2021-02-05', 5, 27000, 2, 5,4),
('Nkem','Said','nkems3@yahoo.com','(214) 555-5555','2017-03-09', 2, 40000, 0, 2, 10),
('Naomi','Chausiku','naomic@gmail.com','(832) 555-5555','2019-07-24', 3, 35000, 2, 2, 10),
('Anita','Oswald','ao72@gmail.com','(905) 555-5555','2018-06-08', 3, 35000, 2, 2, 10);

Insert into job_history(employee_id, start_date, end_date, job_id, department_id)
values (1, '2020-08-01', null, 1,1);

Truncate table job_history;
Insert into job_history(employee_id, start_date, end_date, job_id, department_id)
values (1, '2020-08-01', null, 1,1),
(2, '2014-09-20', '2020-05-17', 2, 2),
(2, '2020-05-18', null, 5, 1),
(3, '2019-05-17', '2021-02-03', 1,1),
(3, '2021-02-04', null, 3,3),
(4, '2021-02-05', null, 5, 4),
(5,'2017-03-09','2021-01-15',3,11),
(5,'2021-01-16', null,2,10),
(6,'2019-07-24', null,3,10),
(7,'2018-06-08','2019-05-10',1,9),
(7,'2019-05-11', null,3,10);

/*Completing Main Assignment Objectives, Utilizes Joins*/

/*Write a SQL query to find the first name, last name, 
department number, and department name for each employee. */
Create view employee_department as
(select employees.first_name, employees.last_name, employees.department_id, departments.department_name
from employees
left join departments
on employees.department_id = departments.department_id);

/*Write a SQL query to find the first name, last name,
 department, city, and state province for each employee */
Create view employee_department_location as
select employees.first_name, employees.last_name, employees.department_id, departments.department_name, locations.city, locations.state_province
from employees, departments, locations
where departments.location_id = locations.location_id and employees.department_id = departments.department_id;

/*Write a SQL query to find the first name, last name, 
salary, and job title for all employees. */
Create view employee_title as
(select employees.first_name, employees.last_name, employees.salary, jobs.job_title
from employees 
right join jobs
on employees.job_id = jobs.job_id);

/*Write a SQL query to find all those employees who work in department ID 20 or 10. 
Return first name, last name, department id and department name.*/
Create view employee_department_ten as
(select employees.first_name, employees.last_name, employees.department_id, departments.department_name
from employees
inner join departments
on employees.department_id = departments.department_id);
Select * from employee_department where department_id = 10;

/*More Queries that employ the rest of the clauses and key words*/
Select * from employee_title order by salary;
-- Select first_name, count(*) from employees group by department_id;
Select distinct first_name from employees;

Select job_id, Count(employee_id) as Number_of_Employees_who_held_the_position from job_history group by job_id;
Delete from job_history where employee_id = 2 and start_date = '2014-09-20';
Update jobs set job_title = 'Department Manager' where job_title = 'Manager';
