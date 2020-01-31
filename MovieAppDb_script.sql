create schema kayla;

create table movie
(
	movie_id int generated always as identity
		constraint movie_pk
			primary key,
	movie_nm varchar(150) not null,
	overview varchar(255)
);

create table genre
(
	genre_id int generated always as identity
		constraint genre_pk
			primary key,
	description varchar(150) not null
);

create table movie_genre
(
	movie_id int
		constraint movie_genre_MOVIE_MOVIE_ID_fk
			references MOVIE,
	genre_id int
		constraint movie_genre_GENRE_GENRE_ID_fk
			references GENRE,
	constraint movie_genre_pk
		primary key (movie_id, genre_id)
);

create table featuredcrew
(
	featuredcrew_id int generated always as identity
		constraint featuredcrew_pk
			primary key,
	name varchar(150) not null
);

create table movie_featuredcrew
(
	movie_id int
		constraint movie_featuredcrew_MOVIE_MOVIE_ID_fk
			references MOVIE,
	featuredcrew_id int
		constraint movie_featuredcrew_FEATUREDCREW_FEATUREDCREW_ID_fk
			references FEATUREDCREW,
	constraint movie_featuredcrew_pk
		primary key (movie_id, featuredcrew_id)
);

create table position
(
	position_id int generated always as identity
		constraint position_pk
			primary key,
	description varchar(150) not null
);

create table featuredcrew_position
(
	featuredcrew_id int
		constraint featuredcrew_position_FEATUREDCREW_FEATUREDCREW_ID_fk
			references FEATUREDCREW,
	position_id int
		constraint featuredcrew_position_POSITION_POSITION_ID_fk
			references POSITION,
	constraint featuredcrew_position_pk
		primary key (featuredcrew_id, position_id)
);

alter table MOVIE
	add column "Year" int;