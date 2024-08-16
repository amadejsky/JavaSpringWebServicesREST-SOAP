INSERT INTO user_details(id,birth_date,name)
values(10001,current_date(),'Test');
INSERT INTO user_details (id, birth_date, name)
VALUES (1, DATEADD('YEAR', -32, CURRENT_DATE()), 'Neo');
INSERT INTO user_details (id, birth_date, name)
VALUES (2, DATEADD('YEAR', -30, CURRENT_DATE()), 'Trinity');
INSERT INTO user_details (id, birth_date, name)
VALUES (3, DATEADD('YEAR', -40, CURRENT_DATE()), 'Morpheus');
INSERT INTO user_details (id, birth_date, name)
VALUES (4, DATEADD('YEAR', -35, CURRENT_DATE()), 'Smith');
-- INSERT INTO posts (id,user_id,description,title)
-- VALUES (1,2,'The Matrix Has You','Wake up!');
-- INSERT INTO posts (id,user_id,description,title)
-- VALUES (2,3,'Open the door','Knock knock');
