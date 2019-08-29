package tws.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
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

import tws.entity.ParkingBoy;

@RunWith(SpringRunner.class)
@MybatisTest
public class ParkingBoyMapperTest {
	@Autowired
	private ParkingBoyMapper parkingBoyMapper;
	
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @After
    public void tearDown() throws Exception {
        JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingBoy");
    }
    
    @Test
    public void shouldFetchAllParkingBoys() {
        // given
        jdbcTemplate.execute("INSERT INTO PARKINGBOY VALUES('001');");
        // when
        List<ParkingBoy> parkingBoys = parkingBoyMapper.getAllParkingBoys();
        // then
        assertEquals(1, parkingBoys.size());
    }
    
    @Test
    public void shouldAddAParkingBoy() {
    	// given
    	ParkingBoy parkingBoy = new ParkingBoy();
    	parkingBoy.setEmployeeID("007");
    	// when
    	parkingBoyMapper.addParkingBoy(parkingBoy);
    	List<ParkingBoy> parkingBoys = parkingBoyMapper.getAllParkingBoys();

    	// then
    	assertEquals(1, parkingBoys.size());
    	
    }

}
