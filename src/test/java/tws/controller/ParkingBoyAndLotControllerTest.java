package tws.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import tws.entity.ParkingBoy;
import tws.entity.ParkingLot;
import tws.repository.ParkingBoyMapper;
import tws.repository.ParkingLotMapper;
import tws.service.ParkingLotService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParkingBoyAndLotControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	private ParkingBoyMapper parkingBoyMapper;
	@Autowired
	private ParkingLotMapper parkingLotMapper;
	@Autowired
	private ParkingLotService parkingLotService;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@After
	public void tearDown() throws Exception {
		JdbcTestUtils.deleteFromTables(jdbcTemplate, "parkingBoy");
	}

	@Before
	public void deleteFrromTable() throws Exception{
		jdbcTemplate.execute("delete from parkingBoy");
		jdbcTemplate.execute("delete from parkingLot");
	}
	
	@Test
	public void shouldReturnOkAndBoys() throws Exception {
        // given
		jdbcTemplate.execute("INSERT INTO PARKINGBOY VALUES('100','tom');");
        List<ParkingBoy> parkingBoys = parkingBoyMapper.getAllParkingBoys();
        String getString = objectMapper.writeValueAsString(parkingBoys);
        
        // then
        this.mockMvc.perform(get("/parkingboys"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(
						content().json(getString));
	}
	
	@Test
	public void shouldReturnOkAndLotsRelaWithParkingBoy() throws Exception {
		// given
		jdbcTemplate.execute("INSERT INTO PARKINGBOY VALUES('100','tom');");
		jdbcTemplate.execute("INSERT INTO PARKINGLOT VALUES('1',10,10,'100')");
	    jdbcTemplate.execute("INSERT INTO PARKINGLOT VALUES('2',10,10,'100')");
		Map<String, Object> parkingLotsRela = parkingLotService.getParkingRela("100");
		String getString = objectMapper.writeValueAsString(parkingLotsRela);
		
        // then
        this.mockMvc.perform(get("/parkinglots" + "/100"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(
						content().json(getString));
	}

}
