insert into tipo_usuario (descripcion, nombre_tipo_usuario) values 
	("Rol para superusuario", "ADMINISTRADOR"),
	("Rol para editor", "EDITOR"),
	("Rol para usuario", "USUARIO");
	
insert into paises (abreviatura, pais) values ("MX", "Mexico"), ("US", "Estados Unidos");

insert into estado (nombre, pais) values ("Guanajuato", 1), ("Queretaro", 1), ("New York", 2);

insert into usuario (email, estado, pais, id_tipo_usuario, idioma, password) values ('admin@mail.com', 1, 1, 1, 1, '$2a$10$QRPYAo0t/YTvh.lQpuNeYOehVzWd1E4znI5bvtyas/my5Zm3agcey');

insert into idioma (abreviatura, nombre) values ("ES"," Español"),("EN", "Ingles"), ("FR", "Frances");

insert into categoria (nombre) values ("Saludos"),("Presentaciones"),("Hogar"),("Trabajo"),( "Turismo"),("Direcciones"),( "Preposiciones");

insert into lenguas (abreviatura, nombre) values ("LSA","Lengua de señas argentina"),("LSM","Lengua de señas mexicana"),("LSPE","Lengua de señas peruana"),("LSV","Lengua de señas venezolana "),("LSCh","Lengua de señas chilena");