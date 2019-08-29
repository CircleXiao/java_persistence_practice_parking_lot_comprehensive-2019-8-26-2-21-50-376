package tws.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import tws.entity.ParkingRela;

@Mapper
public interface ParkingRelaMapper {

	void addParkingRela(List<ParkingRela> parkingRelas);

	List<ParkingRela> getAllRela();

}
