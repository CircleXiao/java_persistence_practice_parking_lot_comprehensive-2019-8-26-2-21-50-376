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
//		for (ParkingBoy parkingBoy : parkingBoys) {
//			parkingBoy.setName("��ԭ����-" + parkingBoy.getName());
//		}
		return parkingBoys;
	}

	public void addParkingBoy(ParkingBoy parkingBoy) {
		parkingBoyMapper.addParkingBoy(parkingBoy);
	}
	
	public List<ParkingBoy> selectPagingParkingBoys(int page, int pageSize) {
		List<ParkingBoy> pagingBoys = new ArrayList<ParkingBoy>();
		
		int skippedItemCount = (page - 1) * pageSize;
		pagingBoys = parkingBoyMapper.selectByPage(skippedItemCount, pageSize);
		
		return pagingBoys;
	}

}
