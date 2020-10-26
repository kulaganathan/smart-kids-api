CREATE TABLE subjects
(
    subject_id character varying NOT NULL,
    name character varying NOT NULL,
    description character varying,
    PRIMARY KEY (subject_id),
    CONSTRAINT constr_uniq_subject_name UNIQUE (name)
);

CREATE TABLE programs
(
    program_id character varying NOT NULL,
    name character varying NOT NULL,
    description character varying,
    PRIMARY KEY (program_id),
    CONSTRAINT constr_uniq_program_name UNIQUE (name)
);

CREATE TABLE courses
(
    course_id character varying NOT NULL,
    name character varying NOT NULL,
    description character varying,
    subject_id character varying NOT NULL,
    program_id character varying NOT NULL,
    PRIMARY KEY (course_id),
    CONSTRAINT constr_uniq_course_name UNIQUE (name),
    CONSTRAINT constr_fk_subject_id FOREIGN KEY (course_id)
        REFERENCES courses (course_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fkey_courses_sbjct_id FOREIGN KEY (subject_id)
        REFERENCES subjects (subject_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fkey_courses_pgm_id FOREIGN KEY (program_id)
        REFERENCES programs (program_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE topics
(
    topic_id character varying NOT NULL,
    name character varying NOT NULL,
    description character varying,
    course_id character varying NOT NULL,
    template_name character varying NOT NULL,
    PRIMARY KEY (topic_id),
    CONSTRAINT constr_uniq_topic_name UNIQUE (name),
    CONSTRAINT constr_fk_course_id FOREIGN KEY (course_id)
        REFERENCES courses (course_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE questions
(
    question_id character varying NOT NULL,
    topic_id character varying NOT NULL,
    line_1 character varying NOT NULL,
    line_2 character varying,
    line_3 character varying,
    line_4 character varying,
    image_1 character varying,
    image_2 character varying,
    image_3 character varying,
    image_4 character varying,
    image_1_repeat numeric,
    option_1 character varying NOT NULL,
    option_2 character varying,
    option_3 character varying,
    option_4 character varying,
    answer character varying NOT NULL,
    CONSTRAINT questions_pkey PRIMARY KEY (question_id),
    CONSTRAINT constr_fk_topic_id FOREIGN KEY (topic_id)
            REFERENCES topics (topic_id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
            NOT VALID
);

ALTER TABLE subjects OWNER to kalai;

ALTER TABLE programs OWNER to kalai;

ALTER TABLE courses OWNER to kalai;

ALTER TABLE topics OWNER to kalai;

ALTER TABLE questions OWNER to kalai;



