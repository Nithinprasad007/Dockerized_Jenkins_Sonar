package com.qbros.testo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("persons")
public class ControllerV1 {

    @PutMapping("{id}")
    public Person updateById(@PathVariable int id, @RequestBody Person person){
        log.info("updating person id: {}  with data {}", id, person);
        //do biz
        return person;
    }
}
