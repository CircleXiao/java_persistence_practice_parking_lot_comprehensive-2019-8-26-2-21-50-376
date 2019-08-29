package tws.entity;

import java.io.Serializable;

public class ParkingLot implements Serializable {
	private String parkingLotID;
	private int capacity;
	private int availablePositionCount;
	
	public ParkingLot() {
		
	}

	public ParkingLot(String parkingLotID, int capacity, int availablePositionCount) {
		this.setParkingLotID(parkingLotID);
		this.setCapacity(capacity);
		this.setAvailablePositionCount(availablePositionCount);
	}

	public String getParkingLotID() {
		return parkingLotID;
	}

	public void setParkingLotID(String parkingLotID) {
		this.parkingLotID = parkingLotID;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getAvailablePositionCount() {
		return availablePositionCount;
	}

	public void setAvailablePositionCount(int availablePositionCount) {
		this.availablePositionCount = availablePositionCount;
	}
}
