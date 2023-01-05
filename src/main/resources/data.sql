use waffle;

insert into member(member_id, password, nickname, part)
values ('bang', '1234', '방예혁', 'Backend'),
       ('kim', '5678', '김유진', 'Mobile');

insert into member_roles(member_member_id, roles)
values ('bang', 'ADMIN'),
       ('kim', 'MEMBER');

insert into fine(member_id, date, type)
values ('bang', '2023-01-02', '10'),
       ('kim', '2023-01-03', '00');