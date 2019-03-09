
insert into route(id, flight_Number, departure, destination, disabled) values(101, 'LH7902','MUC','IAH','TRUE');
insert into route(id, flight_Number, departure, destination, disabled) values(102, 'LH1602','MUC','IBZ','FALSE');
insert into route(id, flight_Number, departure, destination, disabled) values(103, 'LH401','FRA','NYC','TRUE');

insert into flight(id, route_id, price, date) values(1, 101, '120.45', '2018-06-17');
insert into flight(id, route_id, price, date) values(2, 102, '111.45', '2018-07-17');
insert into flight(id, route_id, price, date) values(3, 103, '60.45', '2018-08-17');