insert into client (id, name) values (1, 'Eletrônicos Eletro');
insert into client (id, name) values (2, 'Smart Compras');

insert into product (id, name, amount) values (1, 'Notebook', 2550.0);
insert into product (id, name, amount) values (2, 'Smartphone', 1100.0);
insert into product (id, name, amount) values (3, 'Tablet', 599.0);
insert into product (id, name, amount) values (4, 'Mouse', 79.0);

insert into sale (id, client_id, freight, total, register) values (1, 1, 10.0, 2965.0, sysdate());

insert into item (id, sale_id, product_id, quatity) values (1, 1, 1, 1);