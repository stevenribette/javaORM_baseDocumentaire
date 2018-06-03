create table article(
	art_id int primary key auto_increment,
	art_titre varchar(256),
	art_contenu varchar(256)
);
create table art_aut(
	art_id int,
	aut_id int
);
create table art_art(
	art_id int,
	art_id int
);
create table auteur(
	aut_id int primary key auto_increment,
	aut_nom varchar(256),
	aut_domaine varchar(256),
	cen_id int
);
create table centre(
	cen_id int primary key auto_increment,
	cen_nom varchar(256),
	cen_pays varchar(256)
);