package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.entity.ParkingLot;

@Mapper
public interface ParkingLotMapper {

	void addParkingLot(ParkingLot parkingLot);

	List<ParkingLot> getAllParkingLots();
	
	ParkingLot selectById(@Param("parkingLotID")String parkingLotID);

}
