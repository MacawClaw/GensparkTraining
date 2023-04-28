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
);

create table departments(
	department_id int primary key auto_increment,
    department_name varchar(512) not null,
    manager_id int not null,
    location_id int not null,
    constraint fk_departments_location_id
		foreign key (location_id)
        references locations(location_id)
);

create table jobs(
	job_id int primary key auto_increment,
    job_title varchar(512),
    min_salary int not null,
    max_salary int not null
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
    commission_pct int not null,
    manager_id int not null,
    department_id int not null,
    constraint fk_employee_department_id
		foreign key (department_id)
        references departments(department_id),
   constraint fk_employee_job_id
		foreign key (job_id)
        references jobs(job_id)    
);

create table job_history(
	employee_id int primary key not null,
    start_date date not null,
    end_date date,
    job_id int not null,
    department_id int not null,
    constraint fk_job_history_employee_id
		foreign key (employee_id)
        references employees(employee_id),
    constraint fk_job_history_job_id
		foreign key (job_id)
        references jobs(job_id),
    constraint fk_job_history_department_id
		foreign key (department_id)
        references departments(department_id)    
);