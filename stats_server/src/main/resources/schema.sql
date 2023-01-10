drop table if exists hits;

CREATE TABLE IF NOT EXISTS hits (
   id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   app VARCHAR(50) NOT NULL,
   uri VARCHAR(256),
   ip VARCHAR(50),
   timestamp TIMESTAMP  NOT NULL,
   CONSTRAINT pk_hits PRIMARY KEY (id)
);
