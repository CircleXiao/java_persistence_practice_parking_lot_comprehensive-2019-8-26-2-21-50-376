package tws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.ParkingBoy;
import tws.service.ParkingBoyService;

@RestController
@RequestMapping("/parkingboys")
public class ParkingBoyController {
	@Autowired
	private ParkingBoyService parkingBoyService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addParkingBoy(@RequestBody ParkingBoy parkingBoy) {
		parkingBoyService.addParkingBoy(parkingBoy);
	}
	
	@GetMapping("")
	public List<ParkingBoy> selectPagingParkingBoys(
			@RequestParam(name="page", required = false) Integer page, 
			@RequestParam(name="pageSize", required = false) Integer pageSize) {
		if (page != null && pageSize != null) {
			return parkingBoyService.selectPagingParkingBoys(page, pageSize);
		} 
		return parkingBoyService.findAllParkingBoys();
	}

}
