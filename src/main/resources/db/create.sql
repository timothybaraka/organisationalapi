SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 description VARCHAR,
 numberofemployees INTEGER

);

CREATE TABLE IF NOT EXISTS news (
 id int PRIMARY KEY auto_increment,
 generalnews VARCHAR,
 departmentalnews VARCHAR
);

CREATE TABLE IF NOT EXISTS users (
 id int PRIMARY KEY auto_increment,
 users VARCHAR,
 details VARCHAR,
 roles VARCHAR,
 departments VARCHAR
);

CREATE TABLE IF NOT EXISTS departments_news (
 id int PRIMARY KEY auto_increment,
 newsid INTEGER,
 deparmentsid INTEGER
);