package tws.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.ParkingLot;
import tws.service.ParkingLotService;

@RestController
@RequestMapping("/parkinglots")
public class ParkingLotController {
	@Autowired
	private ParkingLotService parkingLotService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addParkingLot(@RequestBody ParkingLot parkingLot) {
		parkingLotService.addParkingLot(parkingLot);
	}
	
	@GetMapping
	public List<ParkingLot> getAllParkingLots() {
		return parkingLotService.getAllParkingLots();
	}
	
	@GetMapping(path = "/{parkingBoyId}")
	public Map<String, Object> getParkingRela(@PathVariable String parkingBoyId) {
		return parkingLotService.getParkingRela(parkingBoyId);
	}

}
