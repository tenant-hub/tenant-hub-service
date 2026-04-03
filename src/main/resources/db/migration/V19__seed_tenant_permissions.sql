-- ---------------------------------------------------------------
-- TENANT modülü eksik permission'larının eklenmesi (TH-62)
-- TENANT_CREATE, TENANT_UPDATE, TENANT_DELETE permission'ları
-- V7'de yalnızca TENANT_READ seed edilmişti; bu migration eksikleri tamamlar.
-- ---------------------------------------------------------------

INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'TENANT_CREATE', 'Kiracı oluşturma yetkisi',   'TENANT', 'CREATE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'TENANT_UPDATE', 'Kiracı güncelleme yetkisi',  'TENANT', 'UPDATE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'TENANT_DELETE', 'Kiracı silme yetkisi',       'TENANT', 'DELETE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');

-- ADMIN rolüne yeni permission'ları ata
INSERT INTO tenant_hub.ROLE_PERMISSION (id, role_id, permission_id, created_by, created_date, created_ip)
SELECT nextval('tenant_hub.SEQ_ROLE_PERMISSION'), r.id, p.id, 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1'
FROM tenant_hub.ROLE r, tenant_hub.PERMISSION p
WHERE r.name = 'ADMIN'
  AND p.name IN ('TENANT_CREATE', 'TENANT_UPDATE', 'TENANT_DELETE');
