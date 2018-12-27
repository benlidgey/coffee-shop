package com.brighterthanblue.coffeeshop.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.brighterthanblue.coffeeshop.brew.BrewingService;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest(CoffeeShopController.class)
public class CoffeeShopControllerTests {

	private static final String COFFEESHOP_HOME_PATH = "/";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BrewingService brewingService;

	@InjectMocks
	private CoffeeShopController controller;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	@DisplayName("view success path")
	public void getRequestSuccess() throws Exception {

		RequestBuilder r = get(COFFEESHOP_HOME_PATH);
		this.mockMvc.perform(r).andExpect(status().isOk());
	}
}
