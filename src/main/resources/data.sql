-- Insert data into the category table with custom IDs
INSERT INTO category (category_id, category_name, username) VALUES (1, 'Food', 'JohnDoe');
INSERT INTO category (category_id, category_name, username) VALUES (2, 'Utilities', 'JaneDoe');

-- Insert data into the reminder table with custom IDs
INSERT INTO reminder (reminder_id, amount, category_id, done, reminder_date, reason, username) VALUES (1, 50, 1, false, '2024-04-15 08:00:00', 'Buy groceries', 'JohnDoe');
INSERT INTO reminder (reminder_id, amount, category_id, done, reminder_date, reason, username) VALUES (2, 100, 2, false, '2024-04-20 12:00:00', 'Pay electricity bill', 'JaneDoe');
