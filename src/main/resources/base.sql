INSERT INTO film(id) VALUES (1);


INSERT INTO scene(DTYPE, id, description, theaterCode, film_id, location_id) VALUES ("InteriorScene", 1, "première scéne", 49, 1, null);
INSERT INTO scene(DTYPE, id, description, theaterCode, film_id, location_id) VALUES ("ExteriorScene", 2, "scéne de la mort des parents", null, 1, 1);
INSERT INTO scene(DTYPE, id, description, theaterCode, film_id, location_id) VALUES ("ExteriorScene", 3, "scéne de dévcouverte du meutrier", null, 1, 1);
INSERT INTO scene(DTYPE, id, description, theaterCode, film_id, location_id) VALUES ("InteriorScene", 4, "dernière scéne", 49, 1, null);


INSERT INTO location(id, city, country, postCode, street) VALUES (1, "Tours", "CountryRaod", "666420", "Avenue Street");


INSERT INTO setup(id, description, scene_id) VALUES (1, "Angle en perspective", 1);
INSERT INTO setup(id, description, scene_id) VALUES (2, "Angle en plongé", 1);
INSERT INTO setup(id, description, scene_id) VALUES (3, "Angle en contre plongé", 1);

INSERT INTO setup(id, description, scene_id) VALUES (4, "Angle de coté", 2);

INSERT INTO setup(id, description, scene_id) VALUES (5, "Angle en superposition cadré", 3);

INSERT INTO setup(id, description, scene_id) VALUES (6, "Angle en perspective", 4);
INSERT INTO setup(id, description, scene_id) VALUES (7, "Angle en contre plongé", 4);


INSERT INTO clap(id, rollFilmId, timeInMs, setup_id) VALUES (1, 69, 47895, 1);
INSERT INTO clap(id, rollFilmId, timeInMs, setup_id) VALUES (2, 69, 489654, 1);
INSERT INTO clap(id, rollFilmId, timeInMs, setup_id) VALUES (3, 69, 13581, 1);
INSERT INTO clap(id, rollFilmId, timeInMs, setup_id) VALUES (4, 69, 98566, 2);
INSERT INTO clap(id, rollFilmId, timeInMs, setup_id) VALUES (5, 420, 158645, 3);
INSERT INTO clap(id, rollFilmId, timeInMs, setup_id) VALUES (6, 420, 548946, 3);
INSERT INTO clap(id, rollFilmId, timeInMs, setup_id) VALUES (7, 420, 56841, 4);
INSERT INTO clap(id, rollFilmId, timeInMs, setup_id) VALUES (8, 666, 6584132, 6);
INSERT INTO clap(id, rollFilmId, timeInMs, setup_id) VALUES (9, 666, 5424554, 7);
INSERT INTO clap(id, rollFilmId, timeInMs, setup_id) VALUES (10, 666, 845123, 7);