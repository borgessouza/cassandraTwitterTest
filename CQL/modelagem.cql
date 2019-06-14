CQL:
CREATE KEYSPACE twitter_keyspace
 WITH
 REPLICATION = {
   'class': 'SimpleStrategy',
   'replication_factor' : 1
 };

   CREATE TABLE twitter_posts (
    id UUID,
    userName varchar,
    tagName varchar,
    text varchar,
    followerscount double,
    friendscount double,
    listedcount double,
    favouritescount double,
    lang varchar,
    created timestamp,
    PRIMARY KEY (tagName));

   CREATE TABLE twitter_users_by_followers (
    id UUID,
    name varchar,
    tagName varchar,
    followerscount double,
    friendscount double,
    listedcount double,
    favouritescount double,
    PRIMARY KEY (tagName, followerscount))
    WITH CLUSTERING ORDER BY (followerscount DESC);


CREATE TABLE twitter_posts_by_lang (
    id UUID,
    lang varchar,
    tagName varchar,
    text text,
    PRIMARY KEY (lang ,tagName, text))
    WITH CLUSTERING ORDER BY (tagName ASC, text desc);

 CREATE TABLE twitter_posts_by_date (
   id UUID,
    tagName varchar,
    text text,
    created timestamp,
    dia int,
    hora int,
    PRIMARY KEY (hora, dia, text))
    WITH CLUSTERING ORDER BY (dia ASC, text desc);
