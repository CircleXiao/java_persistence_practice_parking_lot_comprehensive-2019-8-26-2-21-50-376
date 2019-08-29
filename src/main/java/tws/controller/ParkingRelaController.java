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

import tws.entity.ParkingRela;
import tws.repository.ParkingRelaMapper;

@RestController
@RequestMapping("/parkingrelas")
public class ParkingRelaController {
	@Autowired
	private ParkingRelaMapper parkingRelaMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addParkingRela(@RequestBody List<ParkingRela> parkingRelas) {
		parkingRelaMapper.addParkingRela(parkingRelas);
	}
	
	@GetMapping
	public List<ParkingRela> getAllRela() {
		return parkingRelaMapper.getAllRela();
	}

}
