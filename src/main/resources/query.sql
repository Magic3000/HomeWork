-- CREATE TABLE [имя таблицы] (
-- [имя колонки] [тип данных],
-- [имя колонки] [тип данных],
-- ...
-- );
CREATE TABLE IF NOT EXISTS Games (
    ID     INTEGER PRIMARY KEY AUTOINCREMENT
                       NOT NULL,
        Name   TEXT    NOT NULL,
        Year   INTEGER NOT NULL,
        Rating INTEGER
);


 --SELECT [список полей] FROM [имя таблицы] WHERE [условие];
 SELECT * FROM Games;
 SELECT * FROM Games WHERE Year > 2005
 SELECT Name FROM Games WHERE Rating = 10


 --INSERT INTO [имя таблицы] ([список полей через запятую]) VALUES ([список
 -- значений через запятую]);
 INSERT INTO Games (Name, Year, Rating) VALUES ("Portal", 2007, 9);

 UPDATE Games SET Rating = 10 WHERE Name = "Portal";


 --DELETE FROM [имя таблицы] WHERE [условие];
 DELETE FROM Games WHERE Rating < 5;