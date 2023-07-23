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

public class RequiredRemainderPostTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private RequiredRemainderService requiredRemainderService;


    @Test
    public void givenCase1_whenGetGoodResult_thenStatus200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/required_reminder/calculate").contentType(MediaType.APPLICATION_JSON)
                                          .content("{\"x\": 7, \"y\": 5, \"n\": 12345}"))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.jsonPath("result", CoreMatchers.is(12339)));
    }

    @Test
    public void givenCase2_whenGetGoodResult_thenStatus200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/required_reminder/calculate").contentType(MediaType.APPLICATION_JSON)
                                          .content("{\"x\": 5, \"y\": 0, \"n\": 4}"))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.jsonPath("result", CoreMatchers.is(0)));
    }
    @Test
    public void givenCase3_whenGetGoodResult_thenStatus200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/required_reminder/calculate").contentType(MediaType.APPLICATION_JSON)
                                          .content("{\"x\": 10, \"y\": 5, \"n\": 15}"))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.jsonPath("result", CoreMatchers.is(15)));
    }
    @Test
    public void givenCase4_whenGetGoodResult_thenStatus200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/required_reminder/calculate").contentType(MediaType.APPLICATION_JSON)
                                          .content("{\"x\": 17, \"y\": 8, \"n\": 54321}"))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.jsonPath("result", CoreMatchers.is(54306)));
    }
    @Test
    public void givenCase5_whenGetGoodResult_thenStatus200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/required_reminder/calculate").contentType(MediaType.APPLICATION_JSON)
                                          .content("{\"x\": 499999993, \"y\": 9, \"n\": 1000000000}"))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.jsonPath("result", CoreMatchers.is(999999995)));
    }
    @Test
    public void givenCase6_whenGetGoodResult_thenStatus200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/required_reminder/calculate").contentType(MediaType.APPLICATION_JSON)
                                          .content("{\"x\": 10, \"y\": 5, \"n\": 197}"))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.jsonPath("result", CoreMatchers.is(195)));
    }
    @Test
    public void givenCase7_whenGetGoodResult_thenStatus200() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/required_reminder/calculate").contentType(MediaType.APPLICATION_JSON)
                                          .content("{\"x\": 2, \"y\": 0, \"n\": 999999999}"))
           .andExpect(MockMvcResultMatchers.status().isOk())
           .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.jsonPath("result", CoreMatchers.is(999999998)));
    }
    @Test
    public void givenEmptyInput_whenGetBadResult_thenStatus400() throws Exception {
        this.requiredRemainderService.calculate(2 ,0 ,999999999);

        mvc.perform(MockMvcRequestBuilders.post("/required_reminder/calculate").contentType(MediaType.APPLICATION_JSON))
           .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    @Test
    public void givenWrongInput_whenGetBadResult_thenStatus400() throws Exception {
        this.requiredRemainderService.calculate(2 ,0 ,999999999);

        mvc.perform(MockMvcRequestBuilders.post("/required_reminder/calculate").contentType(MediaType.APPLICATION_JSON).content("{}"))

           .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
