INSERT INTO users (id, full_name, email, role, is_active, created_at, updated_at) VALUES
(1, 'Ahmed Hassan', 'ahmed@example.com', 'ADMIN', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Sara Ali', 'sara@example.com', 'MEMBER', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Omar Khaled', 'omar@example.com', 'MEMBER', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'Mona Adel', 'mona@example.com', 'MEMBER', false, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 'Youssef Tarek', 'youssef@example.com', 'MEMBER', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);



INSERT INTO project (id, name, description, status, created_at, updated_at) VALUES
(1, 'Task Management System', 'Backend system for managing tasks', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'E-commerce Platform', 'Online shopping system', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Old CRM System', 'Legacy system', 'ARCHIVED', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO task (id, title, description, priority, status, due_date, project_id, assignee_user_id, created_at, updated_at) VALUES

-- Project 1
(1, 'Design DB', 'Design database schema', 'HIGH', 'TODO', NULL, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(2, 'Build API', 'Create REST endpoints', 'HIGH', 'IN_PROGRESS', '2026-05-10', 1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(3, 'Write Docs', 'Swagger documentation', 'MEDIUM', 'TODO', NULL, 1, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(4, 'Testing', 'Unit testing', 'MEDIUM', 'TODO', '2026-05-15', 1, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(5, 'Fix Bugs', 'Fix reported issues', 'HIGH', 'DONE', NULL, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Project 2
(6, 'Setup Payment', 'Integrate payment gateway', 'HIGH', 'TODO', NULL, 2, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(7, 'Cart Feature', 'Add shopping cart', 'MEDIUM', 'IN_PROGRESS', '2026-05-20', 2, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(8, 'User Auth', 'Login & Register', 'HIGH', 'DONE', NULL, 2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(9, 'Product Page', 'Display products', 'LOW', 'TODO', NULL, 2, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(10, 'Order System', 'Handle orders', 'HIGH', 'TODO', '2026-05-25', 2, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

-- Project 3
(11, 'Fix legacy bug', 'Old issue', 'LOW', 'DONE', NULL, 3, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(12, 'Refactor code', 'Improve structure', 'MEDIUM', 'IN_PROGRESS', NULL, 3, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(13, 'Update docs', 'Update documentation', 'LOW', 'TODO', NULL, 3, NULL, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(14, 'Optimize queries', 'Improve DB queries', 'HIGH', 'TODO', '2026-05-30', 3, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(15, 'Archive system', 'Final step', 'LOW', 'DONE', NULL, 3, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);



