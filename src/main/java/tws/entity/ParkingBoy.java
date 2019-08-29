package tws.entity;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class ParkingBoy implements Serializable {
	private String employeeID;
	
	public ParkingBoy() {
		
	}
	
	public ParkingBoy(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	
}
