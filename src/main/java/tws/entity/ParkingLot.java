package tws.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class ParkingLot implements Serializable {
	
	@NotNull(message = "停车场id不能为空")
	private String parkingLotID;
	
	@NotNull(message = "停车场容量必填")
	private int capacity;
	
	private int availablePositionCount;
	
	@NotNull(message = "停车场管理者的id必填")
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
