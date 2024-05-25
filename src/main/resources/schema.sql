create table if not exists digit_intervals(
    id   integer primary key auto_increment,
    start integer not null,
    end integer not null,
    primary key(id)
);
create table if not exists letter_intervals(
    id   integer primary key auto_increment,
    start character not null,
    end character not null,
    primary key(id)
);