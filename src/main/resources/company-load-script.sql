insert into company ("id", companyname, nacecode, gva, scope1emissions, scope2emissions, scope3emissions)
values (1, 'Company 1', 'A1.1.2', 1.5, 2, 3, 4);

insert into company ("id", companyname, nacecode, gva, scope1emissions, scope2emissions, scope3emissions)
values (2, 'Company 2', 'A1.1.3', 1.6, 1, 2, 3);

insert into company ("id", companyname, nacecode, gva, scope1emissions, scope2emissions, scope3emissions)
values (3, 'Company 3', 'A1.1.4', 1.5, 2, 2, 2);

insert into company ("id", companyname, nacecode, gva, scope1emissions, scope2emissions, scope3emissions)
values (4, 'Company 4', 'A1.1.5', 4.5, 2, 3, 1);

insert into company ("id", companyname, nacecode, gva, scope1emissions, scope2emissions, scope3emissions)
values (5, 'Company 5', 'A1.1.6', 2.5, 2, 3, 5);

select setval('hibernate_sequence', 5, true);