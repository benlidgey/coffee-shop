package com.btb.coffeeshop.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class CoffeeShopControllerTests {

    private static final String COFFEESHOP_HOME_PATH = "/";

    private MockMvc mockMvc;

    @InjectMocks
    private CoffeeShopController controller;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    //@Test
    @DisplayName("view success path")
    public void getRequestSuccess() throws Exception {

    	RequestBuilder r = get(COFFEESHOP_HOME_PATH);
        this.mockMvc.perform(r)
                .andExpect(status().isOk());
    }
}
