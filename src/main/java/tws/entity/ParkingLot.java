package tws.entity;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class ParkingLot implements Serializable {
	private String parkingLotID;
	private int capacity;
	private int availablePositionCount;
	private String parkingBoyId;
	
	public ParkingLot() {
		
	}

	public ParkingLot(String parkingLotID, int capacity, int availablePositionCount, String parkingBoyId) {
		this.setParkingLotID(parkingLotID);
		this.setCapacity(capacity);
		this.setAvailablePositionCount(availablePositionCount);
		this.setParkingBoyId(parkingBoyId);
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

	public String getParkingBoyId() {
		return parkingBoyId;
	}

	public void setParkingBoyId(String parkingBoyId) {
		this.parkingBoyId = parkingBoyId;
	}
}
