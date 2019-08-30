CREATE TABLE parkingBoy (
  employeeID  VARCHAR(64) PRIMARY KEY NOT NULL,
  name VARCHAR(64) NOT NULL
);

CREATE TABLE parkingLot (
  parkingLotID  VARCHAR(64) PRIMARY KEY NOT NULL,
  capacity INTEGER NOT NULL,
  availablePositionCount INT NOT NULL
);

CREATE TABLE parkingRela (
  employeeID  VARCHAR(64) NOT NULL,
  parkingLotID  VARCHAR(64) NOT NULL
);
