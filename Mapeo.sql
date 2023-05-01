CREATE DATABASE data_consultorio;
USE data_consultorio;

CREATE TABLE USUARIO(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(150) NOT NULL,
nombre_usuario VARCHAR(150) NOT NULL UNIQUE,
contraseña VARCHAR(150) NOT NULL,
correo VARCHAR(150) NOT NULL UNIQUE,
fecha DATE NOT NULL,
tipo VARCHAR(50) NOT NULL, 
saldo DECIMAL(9,2),
PRIMARY KEY(id,nombre_usuario)
);

CREATE TABLE  INFORMACION_USUARIOS(
id_usuario INT NOT NULL AUTO_INCREMENT,
direccion VARCHAR(150) NOT NULL,
telefono LONG NOT NULL,
cui LONG NOT NULL,
PRIMARY KEY(id_usuario),
FOREIGN KEY (id_usuario) REFERENCES USUARIO(id) ON UPDATE CASCADE
);

CREATE TABLE ESPECIALIDADES(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(150),
descriptcion TEXT,
PRIMARY KEY(id)
);

CREATE TABLE TIPOS_EXAMENES(
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(150),
descriptcion TEXT,
PRIMARY KEY(id)
);

CREATE TABLE SOLICITUD_ESPECIALIDAD(
id INT NOT NULL AUTO_INCREMENT,
id_medico INT NOT NULL,
nombre VARCHAR(150) NOT NULL,
descriptcion TEXT,
estado VARCHAR(50) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (id_medico) REFERENCES USUARIO(id) ON UPDATE CASCADE
);

CREATE TABLE SOLICITUD_TIPOS_EXAMENES(
id INT NOT NULL AUTO_INCREMENT,
id_lab INT NOT NULL,
nombre VARCHAR(150) NOT NULL,
descriptcion TEXT,
estado VARCHAR(50) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY(id_lab) REFERENCES USUARIO(id) ON UPDATE CASCADE
);

CREATE TABLE PORCENTAJE(
id  INT NOT NULL AUTO_INCREMENT,
porcentaje INT NOT NULL,
fecha_inicio DATE,
fecha_final DATE,
estado VARCHAR(50),
PRIMARY KEY(Id)
);

CREATE TABLE LISTA_ESPECIALIDAD(
id_medico INT NOT NULL,
id_especialidad INT NOT NULL,
precio_consulta DECIMAL(9,2),
PRIMARY KEY(id_medico, id_especialidad),
FOREIGN KEY (id_especialidad) REFERENCES ESPECIALIDADES(id) ON UPDATE CASCADE,
FOREIGN KEY (id_medico) REFERENCES USUARIO(id) ON UPDATE CASCADE
);

CREATE TABLE LISTA_HORARIOS(
id_medico INT NOT NULL,
horario_inicial TIME NOT NULL,
horario_final TIME NOT NULL,
PRIMARY KEY (id_medico,horario_inicial,horario_final),
FOREIGN KEY (id_medico) REFERENCES USUARIO(id) ON UPDATE CASCADE
);

CREATE TABLE CONSULTA(
id INT NOT NULL AUTO_INCREMENT,
id_paciente INT NOT NULL,
id_medico INT NOT  NULL,
id_especialidad INT NOT NULL,
porcentaje DECIMAL(9.2) NOT NULL,
fecha_incial DATE NOT NULL,
fecha_final DATE,
precio DECIMAL(9,2) NOT NULL,
informe TEXT,
estado VARCHAR(50) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (id_medico) REFERENCES USUARIO(id) ON UPDATE CASCADE,
FOREIGN KEY (id_paciente) REFERENCES USUARIO(id) ON UPDATE CASCADE,
FOREIGN KEY (id_especialidad) REFERENCES ESPECIALIDADES(id) ON UPDATE CASCADE
);

CREATE TABLE LISTA_EXAMENES_CONSULTA(
id_consulta INT NOT NULL,
id_examen INT NOT NULL,
PRIMARY KEY(id_consulta,id_examen),
FOREIGN KEY(id_consulta) REFERENCES CONSULTA(id) ON UPDATE CASCADE,
FOREIGN KEY(id_examen) REFERENCES TIPOS_EXAMENES(id) ON UPDATE CASCADE
);

CREATE TABLE RECARGA(
id INT NOT NULL AUTO_INCREMENT,
monto DECIMAL(9,2) NOT NULL,
fecha DATETIME NOT NULL,
id_usuario INT NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (id_usuario) REFERENCES USUARIO(id) ON UPDATE CASCADE
);

CREATE TABLE SOLICITUD_EXAMENES(
id INT NOT NULL AUTO_INCREMENT,
id_paciente INT NOT NULL,
id_lab INT NOT NULL,
porcentaje DECIMAL(9.2) NOT NULL,
fecha_solicitada DATE NOT NULL,
fecha_finalizada DATE,
estado VARCHAR(50) NOT NULL,
PRIMARY KEY(id),
FOREIGN KEY (id_paciente) REFERENCES USUARIO(id) ON UPDATE CASCADE,
FOREIGN KEY (id_lab) REFERENCES USUARIO(id) ON UPDATE CASCADE
);

CREATE TABLE LISTA_EXAMENES_SOLICITUD(
id_solicitud INT NOT NULL,
id_examen INT NOT NULL,
PRIMARY KEY(id_solicitud,id_examen),
FOREIGN KEY(id_solicitud) REFERENCES SOLICITUD_EXAMENES(id) ON UPDATE CASCADE,
FOREIGN KEY(id_examen) REFERENCES TIPOS_EXAMENES(id) ON UPDATE CASCADE
);

CREATE TABLE RESULTADO(
id INT AUTO_INCREMENT,
id_consulta INT NOT NULL,
PRIMARY KEY(id,id_consulta),
FOREIGN KEY(id_consulta) REFERENCES CONSULTA(id) ON UPDATE CASCADE
);

CREATE TABLE LISTA_EXAMENES_RESULTADO(
id_resulado INT NOT NULL,
direccion TEXT,
FOREIGN KEY(id_resulado) REFERENCES RESULTADO(id) ON UPDATE CASCADE
);

CREATE TABLE LISTA_EXAMENES_LAB(
id_lab INT NOT NULL,
id_examen INT NOT NULL,
PRIMARY KEY(id_lab,id_examen),
FOREIGN KEY(id_lab) REFERENCES USUARIO(id) ON UPDATE CASCADE,
FOREIGN KEY(id_examen) REFERENCES TIPOS_EXAMENES(id) ON UPDATE CASCADE
);


