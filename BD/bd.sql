CREATE TABLE cat_user (
	id_usr INTEGER NOT NULL,
	nombres VARCHAR(45) NOT NULL,
	paterno VARCHAR(20) NOT NULL,
	materno VARCHAR(20) NOT NULL,
	login_usr VARCHAR(15) NOT NULL,
	passwd VARCHAR(35) NOT NULL,
	email VARCHAR(35) NOT NULL,
	telefono VARCHAR(20) NOT NULL,
	id_perfil INTEGER NOT NULL,
	desc_perfil VARCHAR(10) NOT NULL,
	perfil_nomina VARCHAR(10) NULL,
	id_depto INTEGER NOT NULL,
	desc_depto VARCHAR(25) NOT NULL,
	id_puesto INTEGER NOT NULL,
	desc_puesto VARCHAR(10) NOT NULL,
	id_tienda INTEGER NOT NULL,
	id_distrito INTEGER NOT NULL,
	num_empleado INTEGER NOT NULL,
	fecha_alta DATE NOT NULL,
	fecha_modi DATE NULL,
	fecha_baja DATE NULL,
	fecha_cam_pass DATE NULL,
	estatus INTEGER NOT NULL,
	version DATETIME NULL,
	fecha_mod DATETIME NULL,
	id_usr_mod INTEGER NULL,
	id_usr_alta INTEGER NOT NULL,
	id_usr_del INTEGER NULL,
	fecha_del DATETIME NULL,
	PRIMARY KEY ( id_usr ASC )
) ENGINE=InnoDB DEFAULT CHARSET=latin1;






CREATE TABLE cat_sistemas (
	id INTEGER NOT NULL,
	sistemadesc VARCHAR(255) NOT NULL,
	id_usr_alta INTEGER NOT NULL,
	fecha_alta datetime NOT NULL,
	id_usr_mod INTEGER NULL,
	fecha_mod datetime NULL,
	id_usr_del INTEGER NULL,
	fecha_del datetime NULL,
	estatus TINYINT NOT NULL,
	PRIMARY KEY ( id ASC )
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE cat_sistema_modulo (
	id INTEGER NOT NULL,
	id_sistema INTEGER NOT NULL,
	id_modulo INTEGER NOT NULL,
	id_usr_alta INTEGER NOT NULL,
	fecha_alta datetime NOT NULL,
	id_usr_mod INTEGER NULL,
	fecha_mod datetime NULL,
	id_usr_del INTEGER NULL,
	fecha_del datetime NULL,
	status TINYINT NOT NULL,
	PRIMARY KEY ( id ASC, id_sistema ASC, id_modulo ASC )
)  ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE cat_modulos (
	id INTEGER NOT NULL,
	modulodesc VARCHAR(255) NOT NULL,
	id_usr_alta INTEGER NOT NULL,
	fecha_alta datetime NOT NULL,
	id_usr_mod INTEGER NULL,
	fecha_mod datetime NULL,
	id_usr_del INTEGER NULL,
	fecha_del datetime NULL,
	status TINYINT NOT NULL,
	paquete VARCHAR(255) NULL,
	clase VARCHAR(255) NULL,
	PRIMARY KEY ( id ASC )
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE cat_perfil (
	id_perfil INTEGER NOT NULL,
	desc_perfil VARCHAR(40) NOT NULL,
	alias_perfil VARCHAR(5) NOT NULL,
	estatus TINYINT NOT NULL,
	fecha_alta DATE NOT NULL,
	fecha_modi DATE NULL,
	fecha_mod datetime NULL,
	id_usr_mod INTEGER NULL,
	id_usr_alta INTEGER NOT NULL,
	id_usr_del INTEGER NULL,
	fecha_del datetime NULL,
	CONSTRAINT PK_CAT_PERFIL PRIMARY KEY ( id_perfil ASC )
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE cat_prm_prf (
	id_permiso INTEGER NOT NULL,
	id_perfil INTEGER NOT NULL,
	acceso INTEGER NOT NULL,
	fecha_alta DATE NOT NULL,
	fecha_modi DATE NULL,
	fecha_mod datetime NULL,
	id_usr_mod INTEGER NULL,
	id_usr_alta INTEGER NOT NULL,
	id_usr_del INTEGER NULL,
	fecha_del datetime NULL,
	status TINYINT NULL,
	CONSTRAINT PK_CAT_PRFIL PRIMARY KEY ( id_permiso ASC, id_perfil ASC )
)ENGINE=InnoDB DEFAULT CHARSET=latin1;




CREATE TABLE cat_permiso (
	id_permiso INTEGER NOT NULL,
	desc_permiso VARCHAR(40) NOT NULL,
	alias_permiso VARCHAR(5) NOT NULL,
	estatus TINYINT NOT NULL,
	fecha_alta DATE NOT NULL,
	fecha_modi DATE NULL,
	fecha_mod datetime NULL,
	id_usr_mod INTEGER NULL,
	id_usr_alta INTEGER NOT NULL,
	id_usr_del datetime NULL,
	fecha_del INTEGER NULL,
	id_sistema INTEGER NULL,
	id_accion_modulo INTEGER NULL,
	CONSTRAINT PK_CAT_ACCESO PRIMARY KEY ( id_permiso ASC )
)ENGINE=InnoDB DEFAULT CHARSET=latin1;




CREATE TABLE cat_acciones_modulo (
	id INTEGER NOT NULL,
	id_modulo INTEGER NOT NULL,
	accion VARCHAR(255) NOT NULL,
	id_usr_alta INTEGER NOT NULL,
	fecha_alta datetime NOT NULL,
	id_usr_mod INTEGER NULL,
	fecha_mod datetime NULL,
	id_usr_del INTEGER NULL,
	fecha_del datetime NULL,
	status TINYINT NOT NULL,
	verificar TINYINT NULL,
	PRIMARY KEY ( id ASC )
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO cat_acciones_modulo (id,id_modulo,accion,id_usr_alta,fecha_alta,id_usr_mod,fecha_mod,id_usr_del,fecha_del,status,verificar) VALUES(1,1,'showLogin',1,'2017-02-24 15:31:03.604',NULL,NULL,NULL,NULL,1,0);
INSERT INTO cat_acciones_modulo (id,id_modulo,accion,id_usr_alta,fecha_alta,id_usr_mod,fecha_mod,id_usr_del,fecha_del,status,verificar) VALUES(2,1,'close',1,'2017-02-24 15:37:17.032',NULL,NULL,NULL,NULL,1,0);
INSERT INTO cat_acciones_modulo (id,id_modulo,accion,id_usr_alta,fecha_alta,id_usr_mod,fecha_mod,id_usr_del,fecha_del,status,verificar) VALUES(3,1,'validaLogin',1,'2017-02-24 15:37:33.728',NULL,NULL,NULL,NULL,1,0);




INSERT INTO cat_modulos (id,modulodesc,id_usr_alta,fecha_alta,id_usr_mod,fecha_mod,id_usr_del,fecha_del,status,paquete,clase) VALUES(1,'Login',1,'2017-02-24 15:22:00.281',NULL,NULL,NULL,NULL,1,'T3BLogin.jar','login');

INSERT INTO cat_perfil (id_perfil,desc_perfil,alias_perfil,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del) VALUES(1,'Sistemas','sis',1,'2017-02-24',NULL,NULL,NULL,1,NULL,NULL);
INSERT INTO cat_perfil (id_perfil,desc_perfil,alias_perfil,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del) VALUES(2,'Asociado de Ventas','av',1,'2017-02-24',NULL,NULL,NULL,1,NULL,NULL);
INSERT INTO cat_perfil (id_perfil,desc_perfil,alias_perfil,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del) VALUES(3,'Trainee Tienda','trt',1,'2017-02-24',NULL,NULL,NULL,1,NULL,NULL);
INSERT INTO cat_perfil (id_perfil,desc_perfil,alias_perfil,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del) VALUES(4,'Gerente Tienda','gt',1,'2017-02-24',NULL,NULL,NULL,1,NULL,NULL);





INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(2,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,1);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(3,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,2);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(4,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,3);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(5,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,4);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(6,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,5);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(7,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,6);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(8,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,7);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(9,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,8);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(10,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,9);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(11,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,10);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(12,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,11);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(13,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,12);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(14,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,13);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(15,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,14);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(16,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,15);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(17,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,16);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(18,'muestra','m',1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,2,17);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(19,'muestra','m',1,'2017-03-03',NULL,NULL,NULL,1,NULL,NULL,2,18);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(20,'muestra','m',1,'2017-03-06',NULL,NULL,NULL,1,NULL,NULL,2,1);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(21,'muestra','m',1,'2017-03-06',NULL,NULL,NULL,1,NULL,NULL,2,2);
INSERT INTO cat_permiso (id_permiso,desc_permiso,alias_permiso,estatus,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,id_sistema,id_accion_modulo) VALUES(22,'muestra','m',1,'2017-03-06',NULL,NULL,NULL,1,NULL,NULL,2,3);




INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(2,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(3,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(4,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(5,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(6,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(7,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(8,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(9,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(10,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(11,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(12,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(13,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(14,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(15,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(16,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(17,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(18,1,1,'2017-03-01',NULL,NULL,NULL,1,NULL,NULL,1);
INSERT INTO cat_prm_prf (id_permiso,id_perfil,acceso,fecha_alta,fecha_modi,fecha_mod,id_usr_mod,id_usr_alta,id_usr_del,fecha_del,status) VALUES(19,1,1,'2017-03-03',NULL,NULL,NULL,1,NULL,NULL,1)




INSERT INTO cat_sistemas (id,sistemadesc,id_usr_alta,fecha_alta,id_usr_mod,fecha_mod,id_usr_del,fecha_del,estatus) VALUES(1,'Modulo de Punto de Venta',1,'2017-02-24 15:13:26.274',NULL,NULL,NULL,NULL,1);
INSERT INTO cat_sistemas (id,sistemadesc,id_usr_alta,fecha_alta,id_usr_mod,fecha_mod,id_usr_del,fecha_del,estatus) VALUES(2,'Modulo de Tienda',1,'2017-02-24 15:14:18.454',NULL,NULL,NULL,NULL,1);
INSERT INTO cat_sistemas (id,sistemadesc,id_usr_alta,fecha_alta,id_usr_mod,fecha_mod,id_usr_del,fecha_del,estatus) VALUES(3,'Modulo de Almacen',1,'2017-02-24 15:14:31.270',NULL,NULL,NULL,NULL,1);
INSERT INTO cat_sistemas (id,sistemadesc,id_usr_alta,fecha_alta,id_usr_mod,fecha_mod,id_usr_del,fecha_del,estatus) VALUES(4,'Modulo Central',1,'2017-02-24 15:14:46.148',NULL,NULL,NULL,NULL,1);



INSERT INTO cat_sistema_modulo (id,id_sistema,id_modulo,id_usr_alta,fecha_alta,id_usr_mod,fecha_mod,id_usr_del,fecha_del,status) VALUES(1,2,1,1,'2017-03-01 11:27:42.168',NULL,NULL,NULL,NULL,1);
INSERT INTO cat_sistema_modulo (id,id_sistema,id_modulo,id_usr_alta,fecha_alta,id_usr_mod,fecha_mod,id_usr_del,fecha_del,status) VALUES(2,2,2,1,'2017-03-01 11:28:07.416',NULL,NULL,NULL,NULL,1);
INSERT INTO cat_sistema_modulo (id,id_sistema,id_modulo,id_usr_alta,fecha_alta,id_usr_mod,fecha_mod,id_usr_del,fecha_del,status) VALUES(3,2,1,1,'2017-03-06 10:51:46.319',NULL,NULL,NULL,NULL,1);
INSERT INTO cat_sistema_modulo (id,id_sistema,id_modulo,id_usr_alta,fecha_alta,id_usr_mod,fecha_mod,id_usr_del,fecha_del,status) VALUES(4,2,2,1,'2017-03-06 10:51:46.344',NULL,NULL,NULL,NULL,1);
INSERT INTO cat_sistema_modulo (id,id_sistema,id_modulo,id_usr_alta,fecha_alta,id_usr_mod,fecha_mod,id_usr_del,fecha_del,status) VALUES(5,2,4,1,'2017-03-09 12:00:00.000',NULL,NULL,NULL,NULL,1);




CREATE TABLE menu_tmenubarapp (
	idmenu INTEGER NOT NULL DEFAULT 0,
	orden INTEGER NOT NULL DEFAULT 0,
	texto VARCHAR(255) NULL DEFAULT '-',
	tooltip VARCHAR(255) NULL DEFAULT '-',
	icono text NULL,
	esactivo INTEGER NOT NULL DEFAULT 1,
	fechareg TIMESTAMP NULL DEFAULT CURRENT TIMESTAMP,
	fechamod TIMESTAMP NULL,
	idusrreg INTEGER NULL DEFAULT 0,
	idusrmod INTEGER NULL DEFAULT 0,
	id_sistema INTEGER NULL,
	PRIMARY KEY ( idmenu ASC )
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



CREATE TABLE menu_topcionesmenubarapp (
	idopcion INTEGER NOT NULL DEFAULT 0,
	idmenu INTEGER NOT NULL DEFAULT 0,
	idpadre INTEGER NOT NULL DEFAULT 0,
	orden INTEGER NOT NULL DEFAULT 0,
	texto VARCHAR(255) NULL DEFAULT '-',
	tooltip VARCHAR(255) NULL DEFAULT '-',
	icono text NULL,
	archjar text NULL,
	clase text NULL,
	metodo text NULL,
	parametros text NULL,
	esactivo INTEGER NOT NULL DEFAULT 1,
	fechareg TIMESTAMP NULL,
	fechamod TIMESTAMP NULL,
	idusrreg INTEGER NULL DEFAULT 0,
	idusrmod INTEGER NULL DEFAULT 0,
	id_sistema INTEGER NULL,
	id_modulo INTEGER NULL,
	PRIMARY KEY ( idopcion ASC )
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO menu_tmenubarapp (idmenu,orden,texto,tooltip,icono,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema) VALUES(1,0,'Aplicacion','Menu General de Aplicacion','btn|menu|mapp.png',1,'2017-01-13 11:46:20.432',NULL,1,0,NULL);
INSERT INTO menu_tmenubarapp (idmenu,orden,texto,tooltip,icono,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema) VALUES(2,999,'Acerca De','Menu Acerca de la Aplicacion','btn|menu|macd.png',1,'2017-01-13 11:46:20.432',NULL,1,0,NULL);
INSERT INTO menu_tmenubarapp (idmenu,orden,texto,tooltip,icono,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema) VALUES(3,1,'Configuracion','Menu Configuracion de Almacen','btn|menu|mcnf.png',1,'2017-01-13 11:46:20.432',NULL,1,0,NULL);
INSERT INTO menu_tmenubarapp (idmenu,orden,texto,tooltip,icono,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema) VALUES(4,2,'Lista de Tiendas','Lista de Tiendas de la Region','btn|menu|mlst.png',1,'2017-01-13 11:46:20.432',NULL,1,0,NULL);
INSERT INTO menu_tmenubarapp (idmenu,orden,texto,tooltip,icono,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema) VALUES(5,3,'Estadisticos','Menu Estadisticos del Almacen','btn|menu|mesta.png',1,'2017-01-13 11:46:20.432',NULL,1,0,NULL);




INSERT INTO menu_topcionesmenubarapp (idopcion,idmenu,idpadre,orden,texto,tooltip,icono,archjar,clase,metodo,parametros,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema,id_modulo) VALUES(1,3,0,1,'GENERALES','DATOS GENERALES DEL ALMACEN','btn|menu|mcnf.png','PantallaPrueba.jar','pantallaprueba.Controlador','abrirVentana','',1,'2017-01-13 14:23:23.847',NULL,1,0,NULL,NULL);
INSERT INTO menu_topcionesmenubarapp (idopcion,idmenu,idpadre,orden,texto,tooltip,icono,archjar,clase,metodo,parametros,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema,id_modulo) VALUES(2,4,0,1,'TIENDAS','LISTA DE TIENDAS DEL ALMACEN','btn|menu|mcnf.png','T3BAlmacenTiendas.jar','t3b.almacentiendas.control.Controlador','abrirVentana','',1,'2017-01-13 14:23:23.847',NULL,1,0,NULL,NULL);
INSERT INTO menu_topcionesmenubarapp (idopcion,idmenu,idpadre,orden,texto,tooltip,icono,archjar,clase,metodo,parametros,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema,id_modulo) VALUES(3,5,0,2,'PICKING','REPORTE DE PICKING','btn|menu|mcnf.png','T3BModuloReportesMCA.jar','t3b.moduloreportesmca.control.Controlador','cargaPicking','2',1,'2017-01-18 18:16:25.293',NULL,1,0,NULL,NULL);
INSERT INTO menu_topcionesmenubarapp (idopcion,idmenu,idpadre,orden,texto,tooltip,icono,archjar,clase,metodo,parametros,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema,id_modulo) VALUES(4,5,0,11,'TRANSFERENCIAS','ESTADISTICOS DE TRANSFERENCIAS','btn|menu|mcnf.png','T3BAlmacenTiendas.jar','t3b.almacentiendas.control.Controlador','abrirTransfer',NULL,1,'2017-01-19 16:54:54.922',NULL,1,0,NULL,NULL);
INSERT INTO menu_topcionesmenubarapp (idopcion,idmenu,idpadre,orden,texto,tooltip,icono,archjar,clase,metodo,parametros,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema,id_modulo) VALUES(5,5,0,12,'FILL RATE','ESTADISTICOS DE FILL RATE','btn|menu|mcnf.png','T3BAlmacenTiendas.jar','t3b.almacentiendas.control.Controlador','abrirFillRate',NULL,1,'2017-01-19 16:54:54.937',NULL,1,0,NULL,NULL);
INSERT INTO menu_topcionesmenubarapp (idopcion,idmenu,idpadre,orden,texto,tooltip,icono,archjar,clase,metodo,parametros,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema,id_modulo) VALUES(6,5,0,4,'DIAS INVENTARIO','REPORTE DIAS INVENTARIO','btn|menu|mcnf.png','T3BModuloReportesMCA.jar','t3b.moduloreportesmca.control.Controlador','cargaDiasInv','0',1,'2017-01-19 16:54:54.937',NULL,1,0,NULL,NULL);
INSERT INTO menu_topcionesmenubarapp (idopcion,idmenu,idpadre,orden,texto,tooltip,icono,archjar,clase,metodo,parametros,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema,id_modulo) VALUES(7,5,0,5,'MERMA','REPORTE DE MERMA','btn|menu|mcnf.png','T3BModuloReportesMCA.jar','t3b.moduloreportesmca.control.Controlador','cargaMerma','5',1,'2017-01-19 16:54:54.937',NULL,1,0,NULL,NULL);
INSERT INTO menu_topcionesmenubarapp (idopcion,idmenu,idpadre,orden,texto,tooltip,icono,archjar,clase,metodo,parametros,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema,id_modulo) VALUES(8,5,0,8,'PENDIENTES','REPORTE DOCUMENTOS PENDIENTES','btn|menu|mcnf.png','T3BModuloReportesMCA.jar','t3b.moduloreportesmca.control.Controlador','cargaPendientes','0',1,'2017-01-19 16:54:54.937',NULL,1,0,NULL,NULL);
INSERT INTO menu_topcionesmenubarapp (idopcion,idmenu,idpadre,orden,texto,tooltip,icono,archjar,clase,metodo,parametros,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema,id_modulo) VALUES(9,5,0,9,'QUEJAS','REPORTE QUEJAS','btn|menu|mcnf.png','T3BModuloReportesMCA.jar','t3b.moduloreportesmca.control.Controlador','cargaQuejas','0',1,'2017-01-19 16:54:54.953',NULL,1,0,NULL,NULL);
INSERT INTO menu_topcionesmenubarapp (idopcion,idmenu,idpadre,orden,texto,tooltip,icono,archjar,clase,metodo,parametros,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema,id_modulo) VALUES(10,5,0,10,'CRONOGRAMA DE EMBARQUE','CRONOGRAMA DE EMBARQUE','btn|menu|mcnf.png','T3BModuloReportesMCA.jar','t3b.moduloreportesmca.control.Controlador','cargaCronoEmb','0',1,'2017-01-19 16:54:54.968',NULL,1,0,NULL,NULL);
INSERT INTO menu_topcionesmenubarapp (idopcion,idmenu,idpadre,orden,texto,tooltip,icono,archjar,clase,metodo,parametros,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema,id_modulo) VALUES(11,1,0,1,'INICIO DE SESION','INICIO DE SESION','btn|menu|mcnf.png','T3BLogin.jar','t3b.login.control.Controlador','muestraLogin',NULL,1,'2017-01-20 15:02:50.314',NULL,1,0,NULL,NULL);
INSERT INTO menu_topcionesmenubarapp (idopcion,idmenu,idpadre,orden,texto,tooltip,icono,archjar,clase,metodo,parametros,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema,id_modulo) VALUES(12,5,0,1,'RECIBO','REPORTE DE RECIBO','btn|menu|mcnf.png','T3BModuloReportesMCA.jar','t3b.moduloreportesmca.control.Controlador','cargaVentana','1',1,'2017-02-01 16:29:32.093',NULL,1,0,NULL,NULL);
INSERT INTO menu_topcionesmenubarapp (idopcion,idmenu,idpadre,orden,texto,tooltip,icono,archjar,clase,metodo,parametros,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema,id_modulo) VALUES(13,5,0,3,'EMBARQUE','REPORTE DE EMBARQUE','btn|menu|mcnf.png','T3BModuloReportesMCA.jar','t3b.moduloreportesmca.control.Controlador','cargaEmbarque','3',1,'2017-02-01 16:29:32.140',NULL,1,0,NULL,NULL);
INSERT INTO menu_topcionesmenubarapp (idopcion,idmenu,idpadre,orden,texto,tooltip,icono,archjar,clase,metodo,parametros,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema,id_modulo) VALUES(14,5,0,6,'TOP MERMA','REPORTE DE TOP MERMA','btn|menu|mcnf.png','T3BModuloReportesMCA.jar','t3b.moduloreportesmca.control.Controlador','cargaMermaTop','3',1,'2017-02-03 16:54:09.858',NULL,1,0,NULL,NULL);
INSERT INTO menu_topcionesmenubarapp (idopcion,idmenu,idpadre,orden,texto,tooltip,icono,archjar,clase,metodo,parametros,esactivo,fechareg,fechamod,idusrreg,idusrmod,id_sistema,id_modulo) VALUES(15,5,0,7,'AJUSTE DE INVENTARIO','REPORTE DE AJUSTE DE INVENTARIO','btn|menu|mcnf.png','T3BModuloReportesMCA.jar','t3b.moduloreportesmca.control.Controlador','cargaAjusteInv','1',1,'2017-02-07 12:16:36.045',NULL,1,0,NULL,NULL);



