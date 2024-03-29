CREATE TABLE IF NOT EXISTS BIKE
(
   bikeId bigint  NOT NULL,
   bikeName varchar(255) NOT NULL,
   creationDate timestamp NOT NULL,
   creationUser varchar(255) NOT NULL,
   modificationDate timestamp,
   modificationUser varchar(255),
   deleteDate timestamp,
   deleteUser varchar(255),
   PRIMARY KEY(bikeId)
);

CREATE TABLE IF NOT EXISTS BIKEPART
(
   bikePartId bigint  NOT NULL,
   bikePartName varchar(255) NOT NULL,
   creationDate timestamp NOT NULL,
   creationUser varchar(255) NOT NULL,
   modificationDate timestamp,
   modificationUser varchar(255),
   deleteDate timestamp,
   deleteUser varchar(255),
   PRIMARY KEY(bikePartId)
);

CREATE TABLE IF NOT EXISTS BIKESPECS
(
   bikeSpecsId bigint  NOT NULL,
   bikeId bigint  NOT NULL,
   bikePartId bigint NOT NULL,
   creationDate timestamp NOT NULL,
   creationUser varchar(255) NOT NULL,
   modificationDate timestamp,
   modificationUser varchar(255),
   deleteDate timestamp,
   deleteUser varchar(255),
   PRIMARY KEY(bikeSpecsId),
   FOREIGN KEY (bikeId) REFERENCES BIKE,
   FOREIGN KEY (bikePartId) REFERENCES BIKEPART(bikePartId)
);