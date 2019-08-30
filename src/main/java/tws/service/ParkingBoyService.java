package tws.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tws.entity.ParkingBoy;
import tws.repository.ParkingBoyMapper;

@Service
public class ParkingBoyService {
	@Autowired
	private ParkingBoyMapper parkingBoyMapper;

	public List<ParkingBoy> findAllParkingBoys() {
		List<ParkingBoy> parkingBoys = parkingBoyMapper.getAllParkingBoys();
//		List<ParkingBoy> newParkingBoys = new ArrayList<ParkingBoy>();
		for (ParkingBoy parkingBoy : parkingBoys) {
			parkingBoy.setName("中原银行" + parkingBoy.getName());
		}
		return parkingBoys;
	}

	public void addParkingBoy(ParkingBoy parkingBoy) {
		parkingBoyMapper.addParkingBoy(parkingBoy);
	}

}
