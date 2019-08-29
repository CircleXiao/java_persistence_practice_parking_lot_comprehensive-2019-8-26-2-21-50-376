package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import tws.entity.ParkingBoy;

@Mapper
public interface ParkingBoyMapper {

	void addParkingBoy(ParkingBoy parkingBoy);

	List<ParkingBoy> getAllParkingBoys();

}
