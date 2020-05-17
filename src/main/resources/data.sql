DROP TABLE IF EXISTS items;

CREATE TABLE items (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  item_name VARCHAR(250) NOT NULL,
  item_price INT NOT NULL
);

INSERT INTO items (item_name, item_price) VALUES
    ('Samosa', 10),
    ('Kachori', 10),
    ('Veg Puff', 20),
    ('Egg Puff', 20),
    ('Chicken Puff', 30);