create table mensajito(id integer primary key auto_increment, 
                        titulo varchar(50), 
                        cuerpo varchar(250));
select * from mensajito; 

create table usuario(cuenta integer primary key, nombre varchar(40), email varchar(40)); 
create table direccion(id integer primary key auto_increment, cuenta integer , calle varchar(100), cp integer, 
municipio varchar(40),constraint foreign key (cuenta) references usuario(cuenta)); 
 
select * from usuario;
select * from direccion;
