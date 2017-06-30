package com.example.ProducerSCCProveIt;

import org.junit.Before;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

public class ContractTestBase {

    @Before
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(new ProducerController());
    }
}
