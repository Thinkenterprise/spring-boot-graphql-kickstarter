
insert into route(id, parent_id, flight_Number, departure, destination, disabled) values(1, 1, 'LH7902','MUC','IAH','TRUE');
insert into route(id, parent_id, flight_Number, departure, destination, disabled) values(2, 1, 'LH1602','MUC','IBZ','FALSE');
insert into route(id, parent_id, flight_Number, departure, destination, disabled) values(3, 2, 'LH401','FRA','NYC','TRUE');

insert into flight(id, route_id, price, date) values(1, 1, '120.45', '2018-06-17');
insert into flight(id, route_id, price, date) values(2, 2, '111.45', '2018-07-17');
insert into flight(id, route_id, price, date) values(3, 3, '60.45', '2018-08-17');