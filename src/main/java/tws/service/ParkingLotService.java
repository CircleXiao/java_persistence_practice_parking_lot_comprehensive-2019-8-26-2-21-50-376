package tws.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tws.entity.ParkingLot;
import tws.repository.ParkingBoyMapper;
import tws.repository.ParkingLotMapper;

@Service
public class ParkingLotService {
	@Autowired
	private ParkingLotMapper parkingLotMapper;
	@Autowired
	private ParkingBoyMapper parkingBoyMapper;

	public void addParkingLot(ParkingLot parkingLot) {
		parkingLotMapper.addParkingLot(parkingLot);	
	}

	public List<ParkingLot> getAllParkingLots() {
		List<ParkingLot> parkingLots = parkingLotMapper.getAllParkingLots();
		return parkingLots;
	}
	
	public void name(String parkingBoyId) {
		HashMap<String, ParkingLot> map = new HashMap<String, ParkingLot>();
		List<ParkingLot> parkingLots = parkingLotMapper.getAllParkingLots();
		for (ParkingLot parkingLot : parkingLots) {
			if (parkingBoyId.equals(parkingLot.getParkingBoyId())) {
				map.put(parkingBoyId, parkingLot);
			}
		}
		
	}

	public Map<String, Object> getParkingRela(String parkingBoyId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ParkingLot> selectedParkingLots = new ArrayList<ParkingLot>();
		List<ParkingLot> parkingLots = parkingLotMapper.getAllParkingLots();
		
		for (ParkingLot parkingLot : parkingLots) {
			if (parkingBoyId.equals(parkingLot.getParkingBoyId())) {
				selectedParkingLots.add(parkingLot);
			}
		}
		
		map.put("parkingBoyId", parkingBoyId);
		map.put("name", parkingBoyMapper.selectById(parkingBoyId).getName());
		map.put("parkingLots", selectedParkingLots);
		
		return map;
	}
	

}
