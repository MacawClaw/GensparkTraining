drop database if exists hr;
create database hr;
use hr;

create table regions(
	region_id int primary key auto_increment,
    region_name varchar(512) unique not null
);

create table countries(
	country_id int primary key auto_increment,
    country_name varchar(512) unique not null,
    region_id int not null,
    constraint fk_countries_region_id
		foreign key (region_id)
        references regions(region_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE    
);

create table locations(
	location_id int primary key auto_increment,
    street_address varchar(512) not null,
    postal_code varchar(40) not null,
    city varchar(512) not null,
    state_province varchar(512) not null,
    country_id int not null,
    constraint fk_locations_country_id
		foreign key (country_id)
        references countries(country_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE    
);

create table departments(
	department_id int primary key auto_increment,
    department_name varchar(512) not null,
    manager_id int not null,
    location_id int not null,
    constraint fk_departments_location_id
		foreign key (location_id)
        references locations(location_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE    
);

create table jobs(
	job_id int primary key auto_increment,
    job_title varchar(512),
    min_salary int default 25000,
    max_salary int not null,
    check (min_salary >= 25000),
    check (max_salary < 100000)
);        

create table employees(
	employee_id int primary key auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(256) not null,
    phone_number varchar(15) not null,
    hire_date date not null,
    job_id int not null,
    salary decimal(10,2) not null,
    commission_pct int default 0,
    manager_id int not null,
    department_id int not null,
	check (email like '%_@__%.__%'),
    check (commission_pct >= 0),
    constraint fk_employee_department_id
		foreign key (department_id)
        references departments(department_id),
   constraint fk_employee_job_id
		foreign key (job_id)
        references jobs(job_id)
   ON DELETE CASCADE
   ON UPDATE CASCADE
);

create table job_history(
	employee_id int not null,
    start_date date not null,
    job_created date,
    job_id int not null,
    department_id int not null,
    primary key (employee_id, start_date),
    constraint fk_job_history_employee_id
		foreign key (employee_id)
        references employees(employee_id),
    constraint fk_job_history_job_id
		foreign key (job_id)
        references jobs(job_id),
    constraint fk_job_history_department_id
		foreign key (department_id)
        references departments(department_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE    
);

Alter table job_history
Drop job_created;

Alter table job_history
Add end_date date;