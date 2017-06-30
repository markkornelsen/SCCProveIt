package com.example.ProducerSCCProveIt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    private ProducerEntity producerEntity = null;

    @RequestMapping(value = "/Value", method = RequestMethod.GET)
    public ResponseEntity<ProducerEntity> providerEntity() {
        if (this.producerEntity != null)
            return new ResponseEntity<ProducerEntity>(this.producerEntity, HttpStatus.OK);
        else
            return new ResponseEntity<ProducerEntity>(new ProducerEntity(), HttpStatus.OK);
    }

    @RequestMapping(value="/createEntity", method = RequestMethod.POST)
    ResponseEntity<ProducerEntity> createEntity(@RequestBody ProducerEntity producerEntity) {
        ResponseEntity<ProducerEntity> result = new ResponseEntity<ProducerEntity>(producerEntity, HttpStatus.OK);
        return result;
    }
}
