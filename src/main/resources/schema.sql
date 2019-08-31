CREATE TABLE parkingBoy (
  employeeID  VARCHAR(64) PRIMARY KEY NOT NULL,
  name VARCHAR(64) NOT NULL,
  parkingLotId varchar(64)
);

CREATE TABLE parkingLot (
  parkingLotID  VARCHAR(64) PRIMARY KEY NOT NULL,
  capacity INTEGER NOT NULL,
  availablePositionCount INT NOT NULL
);
