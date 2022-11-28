INSERT INTO tb_store (name, type) VALUES ('Italy', 1);
INSERT INTO tb_store (name, type) VALUES ('Russian',1);
INSERT INTO tb_store (name, type) VALUES ('United States',1);
INSERT INTO tb_store (name, type) VALUES ('Vietnam',1);
INSERT INTO tb_store (name, type) VALUES ('Brazil',1);

INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission, dt_resignation) VALUES ('Sandra de Fatima','sollicitudin@icloud.org','M',2,'248.686-73','1988-10-25','2014-08-01','2018-04-20');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission, dt_resignation) VALUES ('Astra Brandao','massa.vestibulum@hotmail.net','M',2,'286.566-61','1999-01-27','2018-04-20','2020-11-08');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission, dt_resignation) VALUES ('Anthony Chaves','dis.parturient@grupotsm.com','M',3,'266.349-16','1975-10-14','2016-02-06','2018-12-01');

INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission) VALUES ('Slade Santana','hendrerit@google.edu','M',1,'591.252-64','1975-04-16','2019-01-30');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission) VALUES ('Randall Candido','feugiat.sed@icloud.edu','M',3,'718.348-26','1976-03-26','2014-12-23');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission) VALUES ('Cheyenne Carneiro','nunc@outlook.org','M',5,'732.962-74','1979-06-15','2020-11-08');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission) VALUES ('Alfreda Guimaraes','sapien@grupotsm.net','F',4,'176.388-75','1975-12-09','2017-12-02');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission) VALUES ('Shea Paiva','cum.sociis.natoque@yahoo.couk','F',2,'792.864-48','1993-05-21','2017-10-11');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission) VALUES ('Clark Messias','gravida.molestie@aol.net','M',3,'695.247-67','1977-05-05','2015-11-28');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission) VALUES ('Jeanette Sántos','luctus@grupotsm.org','M',2,'254.575-37','1993-06-14','2016-08-08');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission) VALUES ('Chava de Brito','molestie.dapibus@aol.org','F',1,'882.559-94','1990-04-13','2018-09-15');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission) VALUES ('Bryar Mariano','ante.ipsum@google.ca','F',4,'625.192-67','1981-09-15','2019-04-01');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission) VALUES ('Murphy Trindade','in@aol.net','M',5,'071.132-89','1984-07-17','2015-12-15');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission) VALUES ('Sigourney de Lourdes','molestie.sed.id@protonmail.org','M',1,'853.628-64','1987-11-05','2021-01-26');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission) VALUES ('Harlan Guimaraes','dolor.dapibus@outlook.ca','M',2,'358.428-63','1991-06-19','2014-01-12');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission) VALUES ('Sandra de Fatima','sollicitudin@icloud.org','M',2,'248.686-73','1988-10-25','2014-08-01');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission) VALUES ('Astra Brandao','massa.vestibulum@hotmail.net','M',2,'286.566-61','1999-01-27','2018-04-20');
INSERT INTO tb_employee (name,email,gender,store_id,cpf,birth_date,dt_admission) VALUES ('Anthony Chaves','dis.parturient@grupotsm.com','M',3,'266.349-16','1975-10-14','2016-02-06');


INSERT INTO tb_license(dt_Start, dt_expected, dt_End, reason, employee_id) VALUES ('2021-07-13', '2021-08-13', '2021-08-13', 30, 1);
INSERT INTO tb_license(dt_Start, dt_expected, dt_End, reason, employee_id) VALUES ('2021-09-13', '2021-10-13', '2021-10-28', 30, 2);
INSERT INTO tb_license(dt_Start, dt_expected, dt_End, reason, employee_id) VALUES ('2022-10-13', '2022-10-14', '2022-10-14', 1, 3);
INSERT INTO tb_license(dt_Start, dt_expected, reason, employee_id) VALUES ('2021-01-13', '2023-01-13', 30, 10);
INSERT INTO tb_license(dt_Start, dt_expected, reason, employee_id) VALUES ('2021-01-13', '2023-01-13', 30, 11);
INSERT INTO tb_license(dt_Start, dt_expected, reason, employee_id) VALUES ('2021-01-13', '2023-01-13', 30, 12);


INSERT INTO tb_exchange(dt_start, dt_expected, generator_Employee_id, exchanged_employee_id, generator_store_id, exchanged_store_id) VALUES (TIMESTAMP '2021-07-13T20:50:07.12345Z', TIMESTAMP '2021-08-13T20:50:07.12345Z',1,2,1,2)
INSERT INTO tb_exchange(dt_start, dt_expected, generator_Employee_id, exchanged_employee_id, generator_store_id, exchanged_store_id) VALUES (TIMESTAMP '2022-01-13T20:50:07.12345Z', TIMESTAMP '2022-08-13T20:50:07.12345Z',3,2,4,2)