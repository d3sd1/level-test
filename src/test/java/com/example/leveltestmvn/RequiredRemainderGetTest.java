package com.example.leveltestmvn;

import com.example.leveltestmvn.service.RequiredRemainderService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

public class RequiredRemainderGetTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private RequiredRemainderService requiredRemainderService;


    @Test
    public void givenCase1_whenGetGoodResult_thenStatus200() throws Exception {
        this.requiredRemainderService.calculate(7,5,12345);

        mvc.perform(MockMvcRequestBuilders.get("/required_reminder").contentType(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.jsonPath("$[0].result", CoreMatchers.is(12339)));
    }

    @Test
    public void givenCase2_whenGetGoodResult_thenStatus200() throws Exception {
        this.requiredRemainderService.calculate(5,0,4);

        mvc.perform(MockMvcRequestBuilders.get("/required_reminder").contentType(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.jsonPath("$[0].result", CoreMatchers.is(0)));
    }
    @Test
    public void givenCase3_whenGetGoodResult_thenStatus200() throws Exception {
        this.requiredRemainderService.calculate(10 ,5 ,15);

        mvc.perform(MockMvcRequestBuilders.get("/required_reminder").contentType(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.jsonPath("$[0].result", CoreMatchers.is(15)));
    }
    @Test
    public void givenCase4_whenGetGoodResult_thenStatus200() throws Exception {
        this.requiredRemainderService.calculate(17 ,8,54321);

        mvc.perform(MockMvcRequestBuilders.get("/required_reminder").contentType(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.jsonPath("$[0].result", CoreMatchers.is(54306)));
    }
    @Test
    public void givenCase5_whenGetGoodResult_thenStatus200() throws Exception {
        this.requiredRemainderService.calculate(499999993 ,9, 1000000000);

        mvc.perform(MockMvcRequestBuilders.get("/required_reminder").contentType(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.jsonPath("$[0].result", CoreMatchers.is(999999995)));
    }
    @Test
    public void givenCase6_whenGetGoodResult_thenStatus200() throws Exception {
        this.requiredRemainderService.calculate(10 ,5, 187);

        mvc.perform(MockMvcRequestBuilders.get("/required_reminder").contentType(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.jsonPath("$[0].result", CoreMatchers.is(185)));
    }
    @Test
    public void givenCase7_whenGetGoodResult_thenStatus200() throws Exception {
        this.requiredRemainderService.calculate(2 ,0 ,999999999);

        mvc.perform(MockMvcRequestBuilders.get("/required_reminder").contentType(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.jsonPath("$[0].result", CoreMatchers.is(999999998)));
    }
}
