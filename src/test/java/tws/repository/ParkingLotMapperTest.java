package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import tws.entity.ParkingLot;

@RunWith(SpringRunner.class)
@MybatisTest
public class ParkingLotMapperTest {
	@Autowired
	private ParkingLotMapper parkingLotMapper;
	
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingLot");
    }
    
    @Test
    public void shouldFetchAllParkingLots() {
        // given
        jdbcTemplate.execute("INSERT INTO PARKINGLOT VALUES('001',20,10);");
        // when
        List<ParkingLot> parkingLots = parkingLotMapper.getAllParkingLots();
        // then
        assertEquals(1, parkingLots.size());
    }
    
    @Test
    public void shouldAddAParkingBoy() {
    	// given
    	ParkingLot parkingLot = new ParkingLot();
    	parkingLot.setParkingLotID("007");
    	// when
    	parkingLotMapper.addParkingLot(parkingLot);
    	List<ParkingLot> parkingLots = parkingLotMapper.getAllParkingLots();

    	// then
    	assertEquals(1, parkingLots.size());
    	
    }

}
