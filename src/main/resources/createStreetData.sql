create database DB_testautomation;

USE DB_testautomation;

create table StreetCases (
   id int IDENTITY(1,1) PRIMARY KEY,
   city NVARCHAR(100) NOT NULL,
   street NVARCHAR(100) NOT NULL,
   expected_result_count int NOT NULL
);

INSERT INTO StreetCases (city, street, expected_result_count) VALUES
(N'ბათუმი', N'ბაგრატიონი', 6),
(N'ბათუმი', N'ჯავახიშვილი', 2),
(N'ბათუმი', N'ჭავჭავაძე', 2),
(N'ბათუმი', N'რუსთაველი', 1),
(N'ბათუმი', N'გორგილაძე', 9),
(N'ბათუმი', N'ხიმშიაშვილი', 15),
(N'ბათუმი', N'აბაშიძე', 6);

select * from StreetCases;

USE DB_testautomation;

CREATE LOGIN TA_User WITH PASSWORD = 'P@ssw0rd';

ALTER SERVER ROLE sysadmin ADD MEMBER TA_User;

SELECT IS_SRVROLEMEMBER('sysadmin', 'TA_User') AS IsSysAdmin;