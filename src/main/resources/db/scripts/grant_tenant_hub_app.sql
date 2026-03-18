-- ---------------------------------------------------------------
-- tenant_hub_app kullanıcısına tenant_hub şeması için yetkiler
-- NOT: Bu script superuser (postgres) tarafından çalıştırılmalıdır.
-- ---------------------------------------------------------------

-- Şema kullanım yetkisi
GRANT USAGE ON SCHEMA tenant_hub TO tenant_hub_app;

-- Mevcut tüm tablolar için yetki
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA tenant_hub TO tenant_hub_app;

-- Mevcut tüm sequence'ler için yetki
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA tenant_hub TO tenant_hub_app;

-- Mevcut tüm fonksiyonlar için yetki (trigger fonksiyonları dahil)
GRANT EXECUTE ON ALL FUNCTIONS IN SCHEMA tenant_hub TO tenant_hub_app;

-- Sonradan eklenen tablolar için varsayılan yetkiler
ALTER DEFAULT PRIVILEGES IN SCHEMA tenant_hub
    GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO tenant_hub_app;

-- Sonradan eklenen sequence'ler için varsayılan yetkiler
ALTER DEFAULT PRIVILEGES IN SCHEMA tenant_hub
    GRANT USAGE, SELECT ON SEQUENCES TO tenant_hub_app;

-- Sonradan eklenen fonksiyonlar için varsayılan yetkiler
ALTER DEFAULT PRIVILEGES IN SCHEMA tenant_hub
    GRANT EXECUTE ON FUNCTIONS TO tenant_hub_app;
