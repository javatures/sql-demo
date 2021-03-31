create table departments (
    id serial primary key,
    dname text unique not null
);

create table employees (
    id serial primary key,
    dept_id integer not null references departments (id),
    fname text not null,
    surname text not null,
    email text unique,
    salary numeric(10, 2) check (salary > 0),
    constraint employee_name_surname_unique unique(fname, surname)
);

