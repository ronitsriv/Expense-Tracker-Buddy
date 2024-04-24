-- Insert data into the category table with custom IDs
INSERT INTO category (category_id, category_name, username) VALUES (1, 'Food', 'John Doe');
INSERT INTO category (category_id, category_name, username) VALUES (2, 'Utilities', 'John Doe');

-- Insert data into the reminder table with custom IDs
INSERT INTO reminder (amount, category_id, done, reminder_date, reason, username) VALUES (50, 1, false, CURRENT_DATE(), 'Buy groceries', 'John Doe');
INSERT INTO reminder (amount, category_id, done, reminder_date, reason, username) VALUES (100, 1, false, CURRENT_DATE(), 'Pay electricity bill', 'John Doe');
INSERT INTO reminder (amount, category_id, done, reminder_date, reason, username) VALUES (150, 1, false, CURRENT_DATE(), 'Pay A bill', 'John Doe');
INSERT INTO reminder (amount, category_id, done, reminder_date, reason, username) VALUES (25, 1, false, CURRENT_DATE(), 'Pay B bill', 'John Doe');

-- Insert data into the amount table
INSERT INTO amount (amount_id, amount, entry_date, reason, username, category_id) VALUES (1, 50, CURRENT_DATE(), 'Groceries', 'John Doe', 1);
INSERT INTO amount (amount_id, amount, entry_date, reason, username, category_id) VALUES (2, 100, CURRENT_DATE(), 'Electricity Bill', 'John Doe', 1);
INSERT INTO amount (amount_id, amount, entry_date, reason, username, category_id) VALUES (3, 150, CURRENT_DATE(), 'A Bill', 'John Doe', 2);
INSERT INTO amount (amount_id, amount, entry_date, reason, username, category_id) VALUES (4, 25, CURRENT_DATE(), 'B Bill', 'John Doe', 2);

-- Insert data into the category_wise_budget table
INSERT INTO category_wise_budget (cat_wiseid, budget, username, category_id) VALUES (1, 500, 'John Doe', 1);
-- INSERT INTO category_wise_budget (cat_wiseid, budget, username, category_id) VALUES (1, 300, 'John Doe', 2);
