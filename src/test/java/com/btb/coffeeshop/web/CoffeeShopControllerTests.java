package com.btb.coffeeshop.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class CoffeeShopControllerTests {

    private static final String COFFEESHOP_HOME_PATH = "/coffeeshop/";

    private MockMvc mockMvc;

    @InjectMocks
    private CoffeeShopController controller;

    @BeforeEach
    private void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Payment Summary view success path")
    void getRequestSuccess() throws Exception {

        this.mockMvc.perform(get(COFFEESHOP_HOME_PATH))
                .andExpect(status().isOk())
                .andExpect(view().name(CoffeeShopController.COFFEESHOP_SUMMARY_VIEW));
    }
}
