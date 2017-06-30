package com.example.ProducerSCCProveIt;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.contract.wiremock.restdocs.WireMockRestDocs;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;

public class ProducerSCCProveItGetTests extends ProducerSCCProveItTestBase {

    private final String getUrl = "/Value";

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper mapper;

    @Test
    public void testDefaultGetValueIsMessage() throws Exception {

        final MvcResult result = mockMvc.perform(get(getUrl).contentType(MediaType.APPLICATION_JSON)).andReturn();
        final ProducerEntity entity = mapper.readValue(result.getResponse().getContentAsString(), ProducerEntity.class);
        assertThat(entity.getValue(), is("Producer Entity Value Not Set"));
    }

    @Ignore
    @Test
    public void testGenerateConsumerContractGET() throws Exception {

        mockMvc.perform(get(getUrl).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andDo(WireMockRestDocs.verify()
                        .wiremock(
                                WireMock.get(urlEqualTo(getUrl)).withHeader("Content-Type", equalTo("application/json")))
                        .stub("ProducerStubValue"))
                .andReturn();
    }
}
