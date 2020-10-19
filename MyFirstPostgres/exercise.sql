BEGIN TRANSACTION;

-- Create a departments table with id, name


CREATE TABLE departments (
        id              serial,
        name            varchar(255) NOT NULL UNIQUE,
        CONSTRAINT pk_departments_id PRIMARY KEY (id)   
 );

-- Create a job_titles table with id, title


CREATE TABLE job_titles (
        id              serial,
        title           varchar(255) NOT NULL UNIQUE,
        CONSTRAINT pk_job_titles_id PRIMARY KEY (id)       
);

-- Create an employees table with id, first_name, last_name, gender, birthdate, hiredate, department_id, job_title_id
 
CREATE TABLE employees (
        id              serial,
        first_name      varchar(255) NOT NULL,
        last_name       varchar(255) NOT NULL,
        gender          char(1),
        birthday        date,
        hireday         date NOT NULL,
        departments_id  integer NOT NULL,
        job_titles_id   integer NOT NULL,
        CONSTRAINT pk_employees_id PRIMARY KEY (id),
        CONSTRAINT fk_job_titles_id FOREIGN KEY (job_titles_id) REFERENCES job_titles(id),
        CONSTRAINT fk_departments_id FOREIGN KEY (departments_id) REFERENCES departments(id)
);

-- Create a projects table, with id, name, employee_id, startdate

CREATE TABLE projects (
        id              serial,
        name            varchar(255) NOT NULL UNIQUE,
        employees_id    integer NOT NULL,
        startdate       date NOT NULL,
        CONSTRAINT pk_projects_id PRIMARY KEY (id),
        CONSTRAINT fk_employees_id FOREIGN KEY (employees_id) REFERENCES employees(id)
);

-- Insert the different job titles and departments into our database

 INSERT INTO departments (name) VALUES ('Human Resources');
 INSERT INTO departments (name) VALUES ('Finance'); 
 INSERT INTO departments (name) VALUES ('Project Management');
 INSERT INTO departments (name) VALUES ('Reasearch and Development');
 INSERT INTO job_titles (title) VALUES ('Director');
 INSERT INTO job_titles (title) VALUES ('Manager');
 INSERT INTO job_titles (title) VALUES ('Associate');
 INSERT INTO job_titles (title) VALUES ('Developer');
 
-- Insert employees 

INSERT INTO employees (first_name,last_name,hireday,departments_id,job_titles_id) VALUES ('Brendan','Glancy','2020-01-01',1,3);
INSERT INTO employees (first_name,last_name,hireday,departments_id,job_titles_id) VALUES ('Walt','Disney','1999-09-20',2,4);
INSERT INTO employees (first_name,last_name,hireday,departments_id,job_titles_id) VALUES ('Mickey','Mouse','2002-03-01',3,1);
INSERT INTO employees (first_name,last_name,hireday,departments_id,job_titles_id) VALUES ('Donald','Duck','2019-01-02',4,1);
INSERT INTO employees (first_name,last_name,hireday,departments_id,job_titles_id) VALUES ('Daffy','Duck','2001-01-05',2,1);
INSERT INTO employees (first_name,last_name,hireday,departments_id,job_titles_id) VALUES ('Jeff','Bezos','2007-01-01',1,2);
INSERT INTO employees (first_name,last_name,hireday,departments_id,job_titles_id) VALUES ('Steven','Jobs','2015-01-10',1,3);
INSERT INTO employees (first_name,last_name,hireday,departments_id,job_titles_id) VALUES ('Tim','Cook','2016-01-10',3,4);
INSERT INTO employees (first_name,last_name,hireday,departments_id,job_titles_id) VALUES ('William','Gates','2011-02-01',1,1);
INSERT INTO employees (first_name,last_name,hireday,departments_id,job_titles_id) VALUES ('Elon','Musk','2009-09-20',1,4);
INSERT INTO employees (first_name,last_name,hireday,departments_id,job_titles_id) VALUES ('Mark','Zuckerburg','2009-09-20',1,1);
INSERT INTO employees (first_name,last_name,hireday,departments_id,job_titles_id) VALUES ('George','Hotz','2009-09-20',3,1);


-- Insert projects (named after my featured github projects)


INSERT INTO projects (name,employees_id,startdate) VALUES ('SLAM',6,'2020-06-10');
INSERT INTO projects (name,employees_id,startdate) VALUES ('SudokuSolver',9,'2013-09-10');
INSERT INTO projects (name,employees_id,startdate) VALUES ('FooBar',7,'2010-06-11');
INSERT INTO projects (name,employees_id,startdate) VALUES ('Covid-19',8,'2018-08-10');

-- check our database
/*
I commented this out because it was giving me problems when I went to create the db
SELECT * FROM job_titles
SELECT * FROM departments
SELECT * FROM employees
SELECT * FROM projects

 ROLLBACK;
*/


COMMIT;



