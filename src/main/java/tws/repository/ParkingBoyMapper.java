package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fasterxml.jackson.core.sym.Name;

import tws.entity.ParkingBoy;

@Mapper
public interface ParkingBoyMapper {

	void addParkingBoy(ParkingBoy parkingBoy);

	List<ParkingBoy> getAllParkingBoys();
	
	List<ParkingBoy> selectByPage(@Param("skippedItemCount") int skippedItemCount, 
								@Param("pageSize") int pageSize);

}
