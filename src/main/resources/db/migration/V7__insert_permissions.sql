-- ---------------------------------------------------------------
-- PERMISSION tablosu başlangıç verileri
-- ---------------------------------------------------------------

-- USER
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'USER_READ',          'Kullanıcı görüntüleme yetkisi',   'USER',        'READ',   'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'USER_CREATE',        'Kullanıcı oluşturma yetkisi',     'USER',        'CREATE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'USER_UPDATE',        'Kullanıcı güncelleme yetkisi',    'USER',        'UPDATE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'USER_DELETE',        'Kullanıcı silme yetkisi',         'USER',        'DELETE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');

-- ROLES
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'ROLES_READ',         'Rol görüntüleme yetkisi',         'ROLES',       'READ',   'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'ROLES_CREATE',       'Rol oluşturma yetkisi',           'ROLES',       'CREATE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'ROLES_UPDATE',       'Rol güncelleme yetkisi',          'ROLES',       'UPDATE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'ROLES_DELETE',       'Rol silme yetkisi',               'ROLES',       'DELETE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');

-- PERMISSION
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'PERMISSION_READ',    'Yetki görüntüleme yetkisi',       'PERMISSION',  'READ',   'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'PERMISSION_CREATE',  'Yetki oluşturma yetkisi',         'PERMISSION',  'CREATE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'PERMISSION_UPDATE',  'Yetki güncelleme yetkisi',        'PERMISSION',  'UPDATE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'PERMISSION_DELETE',  'Yetki silme yetkisi',             'PERMISSION',  'DELETE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');

-- REAL_ESTATE
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'REAL_ESTATE_READ',   'Gayrimenkul görüntüleme yetkisi', 'REAL_ESTATE', 'READ',   'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'REAL_ESTATE_CREATE', 'Gayrimenkul oluşturma yetkisi',   'REAL_ESTATE', 'CREATE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'REAL_ESTATE_UPDATE', 'Gayrimenkul güncelleme yetkisi',  'REAL_ESTATE', 'UPDATE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'REAL_ESTATE_DELETE', 'Gayrimenkul silme yetkisi',       'REAL_ESTATE', 'DELETE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');

-- RENT
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'RENT_READ',          'Kira görüntüleme yetkisi',        'RENT',        'READ',   'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'RENT_CREATE',        'Kira oluşturma yetkisi',          'RENT',        'CREATE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'RENT_UPDATE',        'Kira güncelleme yetkisi',         'RENT',        'UPDATE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'RENT_DELETE',        'Kira silme yetkisi',              'RENT',        'DELETE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');

-- PAYMENT
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'PAYMENT_READ',       'Ödeme görüntüleme yetkisi',       'PAYMENT',     'READ',   'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'PAYMENT_CREATE',     'Ödeme oluşturma yetkisi',         'PAYMENT',     'CREATE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'PAYMENT_UPDATE',     'Ödeme güncelleme yetkisi',        'PAYMENT',     'UPDATE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'PAYMENT_DELETE',     'Ödeme silme yetkisi',             'PAYMENT',     'DELETE', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');

-- TENANT
INSERT INTO tenant_hub.PERMISSION (id, name, description, module, action, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_PERMISSION'), 'TENANT_READ',        'Kiracı görüntüleme yetkisi',      'TENANT',      'READ',   'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');

-- ---------------------------------------------------------------
-- ROLE tablosu başlangıç verileri
-- ---------------------------------------------------------------
INSERT INTO tenant_hub.ROLE (id, name, description, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_ROLE'), 'ADMIN',  'Tüm yetkilere sahip yönetici rolü',     'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.ROLE (id, name, description, status, created_by, created_date, created_ip) VALUES (nextval('tenant_hub.SEQ_ROLE'), 'VIEWER', 'Sadece görüntüleme yetkisine sahip rol', 'ACTIVE', 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');

-- ---------------------------------------------------------------
-- ROLE_PERMISSION tablosu başlangıç verileri
-- ---------------------------------------------------------------

-- ADMIN: tüm yetkiler
INSERT INTO tenant_hub.ROLE_PERMISSION (id, role_id, permission_id, created_by, created_date, created_ip)
SELECT nextval('tenant_hub.SEQ_ROLE_PERMISSION'), r.id, p.id, 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1'
FROM tenant_hub.ROLE r, tenant_hub.PERMISSION p
WHERE r.name = 'ADMIN';

-- VIEWER: sadece READ yetkileri
INSERT INTO tenant_hub.ROLE_PERMISSION (id, role_id, permission_id, created_by, created_date, created_ip)
SELECT nextval('tenant_hub.SEQ_ROLE_PERMISSION'), r.id, p.id, 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1'
FROM tenant_hub.ROLE r, tenant_hub.PERMISSION p
WHERE r.name = 'VIEWER'
  AND p.action = 'READ';

-- ---------------------------------------------------------------
-- USERS tablosu başlangıç verileri
-- ---------------------------------------------------------------
INSERT INTO tenant_hub.USERS (id, username, email, password_hash, first_name, last_name, phone, status, error_login_count, created_by, created_date, created_ip)
VALUES (nextval('tenant_hub.SEQ_USERS'), 'admin',      'admin@tenanthub.com',       '$2y$10$WU2BhSB7dGM7yXOC1kJQ0e1vu/vKvX1kbP1GdTD4PPh0ctdxrp4ki', 'Admin',  'User',   '+905551112233', 'ACTIVE', 0, 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.USERS (id, username, email, password_hash, first_name, last_name, phone, status, error_login_count, created_by, created_date, created_ip)
VALUES (nextval('tenant_hub.SEQ_USERS'), 'ozanemrah',  'ozanemrah@tenanthub.com',   '$2y$10$5gJq5YP7OvJLxuisd.Qca.KD5BsrzJ7KPXV0MFduijbPtYpSWiGs6', 'Ozan',   'Emrah',  '+905552223344', 'ACTIVE', 0, 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');
INSERT INTO tenant_hub.USERS (id, username, email, password_hash, first_name, last_name, phone, status, error_login_count, created_by, created_date, created_ip)
VALUES (nextval('tenant_hub.SEQ_USERS'), 'eminebusra', 'eminebusra@tenanthub.com',  '$2y$10$ag7D.CC03TX6Jy0B7nL8u.uyyYCBrDf9jg3wt4DdASE2kPtn9pP0G', 'Emine',  'Büşra',  '+905553334455', 'ACTIVE', 0, 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1');

-- ---------------------------------------------------------------
-- USERS_ROLE tablosu başlangıç verileri
-- ---------------------------------------------------------------

-- admin -> ADMIN rolü
INSERT INTO tenant_hub.USERS_ROLE (id, users_id, role_id, assigned_by, assigned_date, created_by, created_date, created_ip)
SELECT nextval('tenant_hub.SEQ_USERS_ROLE'), u.id, r.id, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1'
FROM tenant_hub.USERS u, tenant_hub.ROLE r
WHERE u.username = 'admin' AND r.name = 'ADMIN';

-- ozanemrah -> VIEWER rolü
INSERT INTO tenant_hub.USERS_ROLE (id, users_id, role_id, assigned_by, assigned_date, created_by, created_date, created_ip)
SELECT nextval('tenant_hub.SEQ_USERS_ROLE'), u.id, r.id, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1'
FROM tenant_hub.USERS u, tenant_hub.ROLE r
WHERE u.username = 'ozanemrah' AND r.name = 'VIEWER';

-- eminebusra -> VIEWER rolü
INSERT INTO tenant_hub.USERS_ROLE (id, users_id, role_id, assigned_by, assigned_date, created_by, created_date, created_ip)
SELECT nextval('tenant_hub.SEQ_USERS_ROLE'), u.id, r.id, 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '127.0.0.1'
FROM tenant_hub.USERS u, tenant_hub.ROLE r
WHERE u.username = 'eminebusra' AND r.name = 'VIEWER';
