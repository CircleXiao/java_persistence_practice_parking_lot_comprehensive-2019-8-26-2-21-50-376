package tws.entity;

import java.io.Serializable;
import java.util.List;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class ParkingRela implements Serializable {
	private ParkingBoy parkingBoy;
	private List<ParkingLot> parkingLots;
	
	public ParkingRela() {
		
	}

	public ParkingRela(ParkingBoy parkingBoy, List<ParkingLot> parkingLots) {
		this.setParkingBoy(parkingBoy);
		this.setParkingLots(parkingLots);
	}

	public ParkingBoy getParkingBoy() {
		return parkingBoy;
	}

	public void setParkingBoy(ParkingBoy parkingBoy) {
		this.parkingBoy = parkingBoy;
	}

	public List<ParkingLot> getParkingLots() {
		return parkingLots;
	}

	public void setParkingLots(List<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
	}
}
