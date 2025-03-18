ALTER TABLE beta.users ADD COLUMN IF NOT EXISTS email VARCHAR(255) NOT NULL DEFAULT 'user_before_v1_1@example.com';
