CREATE TABLE department_project (
    department_id BIGINT NOT NULL,
    project_id BIGINT NOT NULL,
    PRIMARY KEY (department_id, project_id)
);