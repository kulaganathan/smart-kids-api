INSERT INTO subjects(subject_id, name, description)
	VALUES ('5f05d0f6-d409-4107-99a2-3b99b0ed43fd', 'math', 'Math');
INSERT INTO subjects(subject_id, name, description)
	VALUES ('e2754682-c38f-4638-a8d4-79f8b93e618b', 'science', 'Science');

INSERT INTO programs(program_id, name, description)
	VALUES ('aab160b4-a782-4ccd-80c7-c04841591e36', 'k', 'Kindergarten');
INSERT INTO programs(program_id, name, description)
	VALUES ('77fcd9d2-6bb8-431b-82e5-228a1283f029', 'grade-1', 'First Grade');
INSERT INTO programs(program_id, name, description)
	VALUES ('0fbf7060-5861-4f2e-9a99-cd42dcf270eb', 'grade-2', 'Second Grade');
INSERT INTO programs(program_id, name, description)
    VALUES ('5d574f57-0efd-4cbd-9e1f-2971f0cfab6c', 'grade-3', 'Third Grade');
INSERT INTO programs(program_id, name, description)
	VALUES ('bf085357-20d7-48dd-bbd2-21e752f0a92b', 'grade-4', 'Fourth Grade');
INSERT INTO programs(program_id, name, description)
	VALUES ('3fa2c7ee-4e08-4cfa-8c02-36eed70ae310', 'grade-5', 'Fifth Grade');
	
INSERT INTO courses(course_id, name, description, subject_id, program_id)
	VALUES ('b8686e0d-b469-4679-b69b-1dc0f8776378', 'addition', 'Addition', '5f05d0f6-d409-4107-99a2-3b99b0ed43fd', '77fcd9d2-6bb8-431b-82e5-228a1283f029');
INSERT INTO courses(course_id, name, description, subject_id, program_id)
	VALUES ('d20d3a1a-2514-4fa4-8186-e5267c174ecb', 'subtraction', 'Subtraction', '5f05d0f6-d409-4107-99a2-3b99b0ed43fd', '77fcd9d2-6bb8-431b-82e5-228a1283f029');
INSERT INTO courses(course_id, name, description, subject_id, program_id)
	VALUES ('0f76273e-a120-4e22-b96a-a61a71610a9d', 'multiplication', 'Multiplication', '5f05d0f6-d409-4107-99a2-3b99b0ed43fd', '77fcd9d2-6bb8-431b-82e5-228a1283f029');
