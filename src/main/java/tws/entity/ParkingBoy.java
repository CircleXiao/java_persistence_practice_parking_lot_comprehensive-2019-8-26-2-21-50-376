package tws.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class ParkingBoy implements Serializable {
	
	@NotNull(message = "停车男孩的员工号必填")
	private String employeeID;
	
	@NotNull(message = "姓名必填")
	@Size(max = 64, message = "姓名长度不超过64")
	private String name;
	
	public ParkingBoy() {
		
	}
	
	public ParkingBoy(String employeeID, String name) {
		this.employeeID = employeeID;
		this.name = name;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
