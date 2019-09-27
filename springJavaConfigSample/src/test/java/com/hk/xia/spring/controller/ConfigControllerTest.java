package com.hk.xia.spring.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author wang.yubin
 * @date 2019/9/27
 * @description
 */
public class ConfigControllerTest {

    @Test
    public void startTest() throws Exception {
        ConfigController configController = new ConfigController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(configController).build();
        ResultActions jspStart = mockMvc.perform(MockMvcRequestBuilders.get("/start"))
                .andExpect(MockMvcResultMatchers.view().name("tart"));
        System.out.println(jspStart.andReturn().getResponse().getForwardedUrl());
    }

}
