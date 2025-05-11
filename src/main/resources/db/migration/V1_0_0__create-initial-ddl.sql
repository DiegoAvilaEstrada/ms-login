USE `session-microservice` ;

create table if not exists `verification_code`(
    code VARCHAR(4) not null,
    user_id INTEGER NOT NULL,
    expiration_time DATETIME NOT NULL,
    PRIMARY KEY (code)
);

create table if not exists `session` (
    id INTEGER AUTO_INCREMENT,
    user_id INTEGER NOT NULL,
    session_expiration_time DATETIME NOT NULL,
    recent_activity DATETIME NOT NULL,
    PRIMARY KEY (id)
);

create table if not exists `session_token` (
    token VARCHAR(50) NOT NULL,
    session_id INTEGER NOT NULL,
    token_expiration_time DATETIME NOT NULL,
    PRIMARY KEY (token),
    FOREIGN KEY (session_id) REFERENCES session(id)
);