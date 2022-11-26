INSERT INTO tb_store(name, type) VALUES ('Cohama',1);
INSERT INTO tb_store(name, type) VALUES ('Cohafuma',1);
INSERT INTO tb_store(name, type) VALUES ('São Luís Shopping',1);
INSERT INTO tb_store(name, type) VALUES ('Olho Dágua',1);

INSERT INTO tb_employee(name, gender, email, cpf, dt_Admission, birth_Date, store_id) VALUES ('Chiara','F', 'chiara@gmail', '000.000.000-00', TIMESTAMP '2020-07-13T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '1989-06-1T20:50:07.12345Z', 1);
INSERT INTO tb_employee(name, gender, email, cpf, dt_Admission, birth_Date, store_id) VALUES ('Bruno','M', 'bruno@gmail', '000.000.000-00', TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '1989-06-1T20:50:07.12345Z', 2);
INSERT INTO tb_employee(name, gender, email, cpf, dt_Admission, dt_resignation, birth_Date, store_id) VALUES ('Micaele','F', 'mica@gmail', '000.000.000-00', TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '2022-10-1T20:50:07.12345Z',TIMESTAMP WITH TIME ZONE '1989-06-1T20:50:07.12345Z', 4);


INSERT INTO tb_license(dt_Start, dt_End, reason, employee_id) VALUES (TIMESTAMP '2021-07-13T20:50:07.12345Z', TIMESTAMP '2021-08-13T20:50:07.12345Z', 30, 1);
INSERT INTO tb_license(dt_Start, dt_End, reason, employee_id) VALUES (TIMESTAMP '2021-09-13T20:50:07.12345Z', TIMESTAMP '2021-10-13T20:50:07.12345Z', 30, 2);
INSERT INTO tb_license(dt_Start, dt_End, reason, employee_id) VALUES (TIMESTAMP '2022-10-13T20:50:07.12345Z', TIMESTAMP '2022-10-14T20:50:07.12345Z', 1, 3);

INSERT INTO tb_exchange(dt_start, dt_expected, generator_Employee_id, exchanged_employee_id, generator_store_id, exchanged_store_id,active) VALUES (TIMESTAMP '2021-07-13T20:50:07.12345Z', TIMESTAMP '2021-08-13T20:50:07.12345Z',1,2,1,2, false)
INSERT INTO tb_exchange(dt_start, dt_expected, generator_Employee_id, exchanged_employee_id, generator_store_id, exchanged_store_id,active) VALUES (TIMESTAMP '2022-01-13T20:50:07.12345Z', TIMESTAMP '2022-08-13T20:50:07.12345Z',3,2,4,2, true)