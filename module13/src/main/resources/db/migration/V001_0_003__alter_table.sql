ALTER TABLE student
ADD CONSTRAINT fk_classroom_id
FOREIGN KEY (classroom_id) REFERENCES classroom(id);

