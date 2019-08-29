package tws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

@RestController
@RequestMapping("/parkinglots")
public class ParkingLotController {
	@Autowired
	private ParkingLotMapper parkingLotMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addParkingLot(@RequestBody ParkingLot parkingLot) {
		parkingLotMapper.addParkingLot(parkingLot);
	}
	
	@GetMapping
	public List<ParkingLot> getAllParkingLots() {
		return parkingLotMapper.getAllParkingLots();
	}

}