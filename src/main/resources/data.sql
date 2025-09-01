
-- Seed: default board + lanes
INSERT INTO boards (id, name) VALUES (1, 'Projeto DIO'), (2, 'Exemplo 2');

INSERT INTO lanes (id, board_id, name, wip_limit, order_index) VALUES
 (1, 1, 'To Do', 5, 0),
 (2, 1, 'Doing', 3, 1),
 (3, 1, 'Done', 0, 2);

INSERT INTO cards (id, lane_id, title, description, due_date, order_index, priority, created_at) VALUES
 (1, 1, 'Configurar projeto', 'Criar projeto Spring Boot', NULL, 0, 'HIGH', CURRENT_TIMESTAMP()),
 (2, 2, 'Implementar API', 'CRUD de cards', NULL, 0, 'MEDIUM', CURRENT_TIMESTAMP()),
 (3, 3, 'Docs README', 'Escrever instruções', NULL, 0, 'LOW', CURRENT_TIMESTAMP());
