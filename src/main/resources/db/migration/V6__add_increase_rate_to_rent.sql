-- ---------------------------------------------------------------
-- RENT tablosuna INCREASE_RATE kolonu eklenmesi
-- ---------------------------------------------------------------
ALTER TABLE devuser.RENT
    ADD COLUMN INCREASE_RATE NUMERIC(5,2) NULL;

-- ---------------------------------------------------------------
-- RENT_HIS tablosuna INCREASE_RATE kolonu eklenmesi
-- ---------------------------------------------------------------
ALTER TABLE devuser.RENT_HIS
    ADD COLUMN INCREASE_RATE NUMERIC(5,2) NULL;
