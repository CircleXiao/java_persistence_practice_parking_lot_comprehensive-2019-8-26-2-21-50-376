package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import tws.entity.ParkingBoy;

@Mapper
public interface ParkingBoyMapper {

	void addParkingBoy(ParkingBoy parkingBoy);
	
	ParkingBoy selectById(@Param("employeeID")String employeeID);

	List<ParkingBoy> getAllParkingBoys();
	
	List<ParkingBoy> selectByPage(
			@Param("skippedItemCount") int skippedItemCount, 
			@Param("pageSize") int pageSize);

}
