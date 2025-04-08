CREATE DATABASE otus_hw25
 WITH OWNER = postgres
      ENCODING = 'UTF8'
      CONNECTION LIMIT = -1;



-- public.tests definition
CREATE TABLE public.tests (
	id serial4 NOT NULL,
	title varchar NOT NULL,
	CONSTRAINT tests_pk PRIMARY KEY (id),
	CONSTRAINT tests_unique UNIQUE (title)
);

INSERT INTO public.tests
(id, title)
VALUES(nextval('tests_id_seq'::regclass), 'Первый тест'),
	  (nextval('tests_id_seq'::regclass), 'Второй тест'),
	  (nextval('tests_id_seq'::regclass), 'Третий тест');



-- public.questions definition
CREATE TABLE public.questions (
	id serial4 NOT NULL,
	title varchar NOT NULL,
	description varchar NULL,
	test_id int4 NOT NULL,
	CONSTRAINT questions_pk PRIMARY KEY (id),
	CONSTRAINT questions_unique UNIQUE (title)
);

-- public.questions foreign keys
ALTER TABLE public.questions ADD CONSTRAINT questions_tests_fk FOREIGN KEY (test_id) REFERENCES public.tests(id) ON DELETE RESTRICT ON UPDATE CASCADE;

CREATE INDEX questions_test_id_idx ON public.questions USING btree (test_id);

INSERT INTO public.questions
(id, title, description, test_id)
VALUES(nextval('questions_id_seq'::regclass), 'Первый вопрос','Описание вопроса 1', 1),
	  (nextval('questions_id_seq'::regclass), 'Второй вопрос','Описание вопроса 2', 1),
	  (nextval('questions_id_seq'::regclass), 'Третий вопрос','Описание вопроса 3', 2),
	  (nextval('questions_id_seq'::regclass), 'Четвертый вопрос','Описание вопроса 4',2),
	  (nextval('questions_id_seq'::regclass), 'Пятый вопрос','Описание вопроса 5',3),
	  (nextval('questions_id_seq'::regclass), 'Шестой вопрос','Описание вопроса 6',3),
	  (nextval('questions_id_seq'::regclass), 'Седьмой вопрос','Описание вопроса 7',3);



-- public.answers definition
CREATE TABLE public.answers (
	id serial4 NOT NULL,
	essence varchar NOT NULL,
	iscorrect bool NOT NULL,
	question_id int4 NOT NULL,
	CONSTRAINT answers_pk PRIMARY KEY (id)
);

-- public.answers foreign keys
ALTER TABLE public.answers ADD CONSTRAINT answers_questions_fk FOREIGN KEY (question_id) REFERENCES public.questions(id) ON DELETE RESTRICT ON UPDATE CASCADE;

CREATE INDEX answers_essence_idx ON public.answers USING btree (essence);
CREATE INDEX answers_id_idx ON public.answers USING btree (id);
CREATE INDEX answers_iscorrect_idx ON public.answers USING btree (iscorrect);
CREATE UNIQUE INDEX idx_one_correct_answer_per_question ON public.answers (question_id) WHERE (iscorrect = true);

INSERT INTO public.answers
(id, "essence", iscorrect, question_id)
VALUES (nextval('answers_id_seq'::regclass),'Какой-то ответ 1', true, 1),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 2', false, 1),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 3', false, 2),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 4', true, 2),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 5', false, 2),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 6', false, 3),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 7', false, 3),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 8', true, 3),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 9', false, 3),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 10', true, 4),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 11', false, 4),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 12', false, 5),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 13', true, 5),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 14', false, 5),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 15', false, 6),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 16', true, 6),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 17', false, 6),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 18', false, 6),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 19', false, 7),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 20', true, 7),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 21', false, 7),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 22', false, 7),
	   (nextval('answers_id_seq'::regclass),'Какой-то ответ 23', false, 7);



--- SQL for check:
	select t.title as test, q.title as question, q.description, a.essence as answer, a.iscorrect
	from tests t
	left join questions q on t.id = q.test_id
	left join answers a on q.id = a.question_id
	order by a.id, q.id, t.id