-- Insert data into the category table with custom IDs
INSERT INTO category (category_id, category_name, username) VALUES (1, 'Food', 'JohnDoe');
INSERT INTO category (category_id, category_name, username) VALUES (2, 'Utilities', 'JaneDoe');

-- Insert data into the reminder table with custom IDs
INSERT INTO reminder (reminder_id, amount, category_id, done, reminder_date, reason, username) VALUES (1, 50, 1, false, CURRENT_DATE(), 'Buy groceries', 'JohnDoe');
INSERT INTO reminder (reminder_id, amount, category_id, done, reminder_date, reason, username) VALUES (2, 100, 1, false, CURRENT_DATE(), 'Pay electricity bill', 'JohnDoe');
INSERT INTO reminder (reminder_id, amount, category_id, done, reminder_date, reason, username) VALUES (3, 150, 2, false, CURRENT_DATE(), 'Pay A bill', 'JohnDoe');
INSERT INTO reminder (reminder_id, amount, category_id, done, reminder_date, reason, username) VALUES (4, 25, 2, false, CURRENT_DATE(), 'Pay B bill', 'JohnDoe');
