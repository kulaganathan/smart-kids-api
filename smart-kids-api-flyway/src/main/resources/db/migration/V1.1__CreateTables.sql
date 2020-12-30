-- Drop the tables in reverse order

DROP TABLE IF EXISTS images CASCADE;

DROP TABLE IF EXISTS questions CASCADE;

DROP TABLE IF EXISTS topics CASCADE;

DROP TABLE IF EXISTS courses CASCADE;

DROP TABLE IF EXISTS subjects CASCADE;

DROP TABLE IF EXISTS programs CASCADE;

-- Create the tables in order

CREATE TABLE subjects
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    ref_id character varying NOT NULL,
    name character varying NOT NULL,
    description character varying,
    PRIMARY KEY (id),
    CONSTRAINT uk_subjects_ref_id UNIQUE (ref_id),
    CONSTRAINT uk_subjects_name UNIQUE (name)
);

CREATE TABLE programs
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    ref_id character varying NOT NULL,
    name character varying NOT NULL,
    description character varying,
    PRIMARY KEY (id),
    CONSTRAINT uk_programs_ref_id UNIQUE (ref_id),
    CONSTRAINT uk_programs_name UNIQUE (name)
);

CREATE TABLE courses
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    ref_id character varying NOT NULL,
    name character varying NOT NULL,
    description character varying,
    subject_id bigint NOT NULL,
    program_id bigint NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_courses_ref_id UNIQUE (ref_id),
    CONSTRAINT uk_courses_name UNIQUE (name, program_id, subject_id),
    CONSTRAINT fk_courses_subject_id FOREIGN KEY (subject_id)
        REFERENCES subjects (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_courses_program_id FOREIGN KEY (program_id)
        REFERENCES programs (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE topics
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    ref_id character varying NOT NULL,
    name character varying NOT NULL,
    description character varying ,
    course_id integer NOT NULL,
    template_name character varying NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_topics_ref_id UNIQUE (ref_id),
    CONSTRAINT uk_topics_name UNIQUE (name, course_id),
    CONSTRAINT fk_topics_course_id FOREIGN KEY (course_id)
        REFERENCES courses (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE questions
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    ref_id character varying NOT NULL,
    topic_id bigint NOT NULL,
    line_1 character varying NOT NULL,
    line_2 character varying,
    line_3 character varying,
    line_4 character varying,
    option_1 character varying,
    option_2 character varying,
    option_3 character varying,
    option_4 character varying,
    answer character varying NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_questions_ref_id UNIQUE (ref_id),
    CONSTRAINT fk_topics_topic_id FOREIGN KEY (topic_id)
            REFERENCES topics (id) MATCH SIMPLE
            ON UPDATE NO ACTION
            ON DELETE NO ACTION
            NOT VALID
);

CREATE TABLE images
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    ref_id character varying NOT NULL,
    question_id bigint NOT NULL,
    image_num smallint NOT NULL,
    url character varying NOT NULL,
    description character varying ,
    PRIMARY KEY (id),
    CONSTRAINT uk_images_ref_id UNIQUE (ref_id),
    CONSTRAINT uk_images_image_num UNIQUE (question_id, image_num),
    CONSTRAINT fk_images_question_id FOREIGN KEY (question_id)
        REFERENCES questions (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

-- Assign ownership

ALTER TABLE subjects OWNER to kalai;

ALTER TABLE programs OWNER to kalai;

ALTER TABLE courses OWNER to kalai;

ALTER TABLE topics OWNER to kalai;

ALTER TABLE questions OWNER to kalai;

ALTER TABLE images OWNER to kalai;
