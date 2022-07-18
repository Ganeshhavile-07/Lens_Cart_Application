package com.cg.cs.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.cg.cs.entity.Customer;
import com.cg.cs.serviceimpl.CustomerServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {
	
	@MockBean
	private CustomerServiceImpl customerServiceImpl;
	
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	void testCustomerServiceNotNull() {
		assertThat(customerServiceImpl).isNotNull();
	}
	
	@Test
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}
	
	
//	@Test
//	void testShowPlanters() throws Exception {
//		Planter p1= new Planter(2000,9, "red","oval",10, 90);
//		Planter p2= new Planter(2001,10, "brown","round",20, 100);
//		List<Planter> planterList=new ArrayList<Planter>();
//		planterList.add(p1);
//		planterList.add(p2);
//		when(planterServiceImpl.getAllPlanters()).thenReturn(planterList);
//	mockMvc.perform(get("/planter/allplanters"))
//	.andExpect(status().isOk())
//	.andExpect(content().contentType("application/json"))
//	//.andExpect(jsonPath("$[*]", hasSize(2)))
//	.andExpect(jsonPath("$[0].planterId").value(2000))
//	.andExpect(jsonPath("$[0].planterHeight").value(9))
//	.andExpect(jsonPath("$[0].planterShape").value("oval"))
//	.andExpect(jsonPath("$[0].planterStock").value(20))
//	.andExpect(jsonPath("$[0].planterColor").value("red"))
//	.andExpect(jsonPath("$[0].planterCost").value(200));
//		
//	}
	
	

//	@Test
//	void testShowPlantersById() throws Exception {
//		Planter p2= new Planter(2001,10, "brown","round",20, 100);
//			when(planterServiceImpl.getPlanterById(2001)).thenReturn(p2);
//	mockMvc.perform(get("/planter/planters/2001"))
//	.andExpect(status().isOk())
//	.andExpect(content().contentType("application/json"))
//	.andExpect(jsonPath("$[0].planterId").value(2001))
//	.andExpect(jsonPath("$[0].planterHeight").value(10))
//	.andExpect(jsonPath("$[0].planterShape").value("round"))
//	.andExpect(jsonPath("$[0].planterStock").value(20))
//	.andExpect(jsonPath("$[0].planterColor").value("brown"))
//	.andExpect(jsonPath("$[0].planterCost").value(100));
//		
//	}
	
	
	@Test
	void testShowCustomerInvalidId() throws Exception {
		Customer c1=new Customer(2000,"Ganesh","ganesh@gmail.com",22,"9637731476");
	when(customerServiceImpl.getCustomerById( (long) 10)).thenReturn(c1);
	MvcResult result=mockMvc.perform(get("/api/v1/customers/20"))
	.andExpect(status().isOk())
	.andReturn();
	assertThat(result.getResponse().toString())
	.as("Customer with the id 20 doesn't exist");
		
	}
	
//	
//	@Test
//	void testDeletePlanterById() throws Exception {
//	
//		Planter p1 = new Planter(2000,9, "red","oval",10, 90);
//		String s="deleted successfully....";
//	when(planterServiceImpl.deletePlanter(2000)).thenReturn(s);
//	mockMvc.perform(delete("/planter/planters/2001"))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));	
//	}
//	
//	@Test
//	void testdeletePlanterInvalidId() throws Exception {
//		Customer c1=new Customer(2000,"Ganesh","ganesh@gmail.com",22,"9637731476");
//		String s="deleted successfully....";
//		when(customerServiceImpl.deleteCustomer(20)).thenReturn(s);
//	MvcResult result=mockMvc.perform(delete("/planter/planters/11"))
//	.andExpect(status().isOk())
//	.andReturn();
//	assertThat(result.getResponse().toString())
//	.as("Planter with the id 20 doesn't exist");
//		
//	}
	
//	@Test
//	void testAddPlanter() throws Exception {
//		Planter p1 = new Planter(2002,9, "red","oval",10, 90);
//		Planter s= "added successfully";
//		when(planterServiceImpl.addPlanter(p1)).thenReturn(s);
//		
//		ObjectMapper mapper=new ObjectMapper();
//		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
//		String reqstr=writer.writeValueAsString(p1);
//	mockMvc.perform(post("/planter/addplanters/")
//			.contentType("application/json")
//			.content(reqstr))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));
//		
//	}
//	
//	@Test
//	void testUpdateCustomer() throws Exception {
//		Customer c1=new Customer((long) 10,"Ganesh","ganesh@gmail.com",22,"9637731476");
//		String s="updated successfully....";
//		when(customerServiceImpl.updateCustomer(c1, null)).thenReturn(s);
//		
//		ObjectMapper mapper=new ObjectMapper();
//		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
//		String reqstr=writer.writeValueAsString(p1);
//	mockMvc.perform(put("/planter/updateplanter/")
//			.contentType("application/json")
//			.content(reqstr))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));
//		
//	}
//	
//	@Test
//	void testUpdateCustomer() throws Exception {
//		Customer c1=new Customer(2000,"Ganesh","ganesh@gmail.com",22,"9637731476");
//		String s="updated successfully....";
//		when(customerServiceImpl.update(c1)).thenReturn(s);
//		
//		ObjectMapper mapper=new ObjectMapper();
//		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
//		String reqstr=writer.writeValueAsString(p1);
//	mockMvc.perform(put("/planter/updateplanter/")
//			.contentType("application/json")
//			.content(reqstr))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));
//		
//	}
}