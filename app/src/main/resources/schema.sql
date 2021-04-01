create table departments (
    did serial primary key,
    dname text unique not null
);

create table employees (
    eid serial primary key,
    dept_id integer not null references departments (did),
    fname text not null,
    surname text not null,
    email text unique,
    salary numeric(10, 2) check (salary > 0),
    constraint employee_name_surname_unique unique(fname, surname)
);

insert into departments (dname) values ('HR');
insert into employees (dept_id, fname, surname, email, salary) values (1, 'Bob', 'Jonson', 'bob.jonson@company.com', 50000);
insert into employees (dept_id, fname, surname, email, salary) values (1, 'Sam', 'Jonson', 'sam.jonson@company.com', 50000);
insert into employees (dept_id, fname, surname, email, salary) values (1, 'Tim', 'Jonson', 'tim.jonson@company.com', 50000);
insert into employees (dept_id, fname, surname, email, salary) values (1, 'Jon', 'Jonson', 'jon.jonson@company.com', 50000);
insert into employees (dept_id, fname, surname, email, salary) values (1, 'Steve', 'Jonson', 'steve.jonson@company.com', 50000);