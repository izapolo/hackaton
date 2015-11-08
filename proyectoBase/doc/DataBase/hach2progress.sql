--Crear TABLESPACE
CREATE TABLESPACE D_HACK2PROGRESS_DATA DATAFILE 'C:\oraclexe\app\oracle\oradata\XE\D_HACK2PROGRESS_DATA.DBF' SIZE 100M AUTOEXTEND ON NEXT 200K MAXSIZE 500M;
-- Crear usuario
create user hach2progress identified by hach2progress;
-- Dar permisio de dba
grant dba to hach2progress;
-- Asociar TABLESPACE al usuario
alter user hach2progress quota unlimited on D_HACK2PROGRESS_DATA; 
