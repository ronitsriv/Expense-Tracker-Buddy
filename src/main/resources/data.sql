-- Insert data into the category table with custom IDs
INSERT INTO category (category_id, category_name, username) VALUES (1, 'Food', 'JohnDoe');
INSERT INTO category (category_id, category_name, username) VALUES (2, 'Utilities', 'JaneDoe');

-- Insert data into the reminder table with custom IDs
INSERT INTO reminder (amount, category_id, done, reminder_date, reason, username) VALUES (50, 1, false, CURRENT_DATE(), 'Buy groceries', 'John Doe');
INSERT INTO reminder (amount, category_id, done, reminder_date, reason, username) VALUES (100, 1, false, CURRENT_DATE(), 'Pay electricity bill', 'John Doe');
INSERT INTO reminder (amount, category_id, done, reminder_date, reason, username) VALUES (150, 2, false, CURRENT_DATE(), 'Pay A bill', 'John Doe');
INSERT INTO reminder (amount, category_id, done, reminder_date, reason, username) VALUES (25, 2, false, CURRENT_DATE(), 'Pay B bill', 'John Doe');
