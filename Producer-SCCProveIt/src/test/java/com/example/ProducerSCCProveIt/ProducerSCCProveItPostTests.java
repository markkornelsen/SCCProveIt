package com.example.ProducerSCCProveIt;

import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.cloud.contract.wiremock.restdocs.WireMockRestDocs;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import com.github.tomakehurst.wiremock.client.WireMock;

public class ProducerSCCProveItPostTests extends ProducerSCCProveItTestBase {

    private final String postUrl = "/createEntity";

    @Test
    public void testPostReturnsCorrectValue() throws Exception {

        String json = getJSONFromFile("CreateEntity.json");

        final MvcResult result = mockMvc.perform(post(postUrl).contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk()).andReturn();

        String response = result.getResponse().getContentAsString();
        ProducerEntity entity = mapper.readValue(response, ProducerEntity.class);
        assertThat(entity.getValue(), is("reallycoolguy@libertymutual.com"));
    }

    @Ignore
    @Test
    public void testGenerateConsumerContractPOST() throws Exception {

        String json = getJSONFromFile("CreateEntity.json");

        mockMvc.perform(post(postUrl).contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk())
                .andDo(WireMockRestDocs.verify()
                        .wiremock(WireMock.post(urlEqualTo(postUrl))
                                .withHeader("Content-Type", equalTo("application/json")).withRequestBody(
                                        matchingJsonPath("$[?(@.value =~ /" + crazyLongEmailExpression + "/)]")))
                        .stub("ProducerStubCreateEntity"));
    }
}
