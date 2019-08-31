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
        jdbcTemplate.execute("INSERT INTO PARKINGBOY VALUES('001','tom');");
        
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
    	parkingBoy.setName("mike");
    	
    	// when
    	parkingBoyMapper.addParkingBoy(parkingBoy);
    	List<ParkingBoy> parkingBoys = parkingBoyMapper.getAllParkingBoys();

    	// then
    	assertEquals(1, parkingBoys.size());
    	
    }
    
    @Test
    public void should_return_3th_and_4th_when_select_by_page_given_skipped_as_2_size_as_2() {
    	// given
        jdbcTemplate.execute("INSERT INTO PARKINGBOY VALUES('001','lihua');");
        jdbcTemplate.execute("INSERT INTO PARKINGBOY VALUES('002','lilei');");
        jdbcTemplate.execute("INSERT INTO PARKINGBOY VALUES('003','hanmeimei');");
        jdbcTemplate.execute("INSERT INTO PARKINGBOY VALUES('004','hhh');");
    	int skippedItemCount = 2;
		int pageSize = 2;
		
		// when
    	List<ParkingBoy> pagingBoys = parkingBoyMapper.selectByPage(skippedItemCount, pageSize);
    	
    	// then
    	assertEquals("003", pagingBoys.get(0).getEmployeeID());
    	assertEquals("hanmeimei", pagingBoys.get(0).getName());
    	assertEquals("004", pagingBoys.get(1).getEmployeeID());
    	assertEquals("hhh", pagingBoys.get(1).getName());
    }
    
    @Test
    public void shouldGetOneParkingBoy() {
        // given
        jdbcTemplate.execute("INSERT INTO PARKINGBOY VALUES('001','tom');");
        String employeeID = "001";
        
        // when
        ParkingBoy parkingBoy = parkingBoyMapper.selectById(employeeID);
        
        // then
        assertEquals("tom", parkingBoy.getName());
    }

}
