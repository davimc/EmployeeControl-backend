INSERT INTO tb_store(name, type) VALUES ('Cohama',1);
INSERT INTO tb_store(name, type) VALUES ('Cohafuma',1);
INSERT INTO tb_store(name, type) VALUES ('São Luís Shopping',1);
INSERT INTO tb_store(name, type) VALUES ('Olho Dágua',1);

INSERT INTO tb_employee(name, gender, email, cpf, dt_Admission, birth_Date, store_id) VALUES ('Chiara','F', 'chiara@gmail', '000.000.000-00', TIMESTAMP '2020-07-13T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '1989-06-1T20:50:07.12345Z', 2);
INSERT INTO tb_employee(name, gender, email, cpf, dt_Admission, birth_Date, store_id) VALUES ('Bruno','M', 'bruno@gmail', '000.000.000-00', TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '1989-06-1T20:50:07.12345Z', 3);
INSERT INTO tb_employee(name, gender, email, cpf, dt_Admission, dt_resignation, birth_Date, store_id) VALUES ('Micaele','F', 'mica@gmail', '000.000.000-00', TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '2022-10-1T20:50:07.12345Z',TIMESTAMP WITH TIME ZONE '1989-06-1T20:50:07.12345Z', 4);