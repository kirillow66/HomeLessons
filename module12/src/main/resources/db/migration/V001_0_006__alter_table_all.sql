ALTER TABLE department
ADD FOREIGN KEY (manager_id) REFERENCES employee(id);

ALTER TABLE department_project
ADD FOREIGN KEY (department_id) REFERENCES department(id);
ALTER TABLE department_project
ADD FOREIGN KEY (project_id) REFERENCES project(id);

ALTER TABLE employee
ADD FOREIGN KEY (department_id) REFERENCES department(id);

ALTER TABLE employee_project
ADD FOREIGN KEY (employee_id) REFERENCES employee(id);
ALTER TABLE employee_project
ADD FOREIGN KEY (project_id) REFERENCES project(id);