create table customers(id serial primary key ,name varchar ,numberid varchar ,emp_id int references employees(id));

