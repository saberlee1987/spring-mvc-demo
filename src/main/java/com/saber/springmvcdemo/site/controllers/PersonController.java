package com.saber.springmvcdemo.site.controllers;

import com.saber.springmvcdemo.site.dto.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/person")
@RequiredArgsConstructor
public class PersonController {

    private final RestTemplate restTemplate;

    @RequestMapping(value = "/p1",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getPersonJson(){

        Person person = new Person();
        person.setId(12L);
        person.setFirstName("saber");
        person.setLastName("Azizi");
        person.setAge(35);
        return ResponseEntity.ok(person);
    }

    @RequestMapping(value = "/p2",produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Person> getPersonXml(){

        Person person = new Person();
        person.setId(12L);
        person.setFirstName("saber");
        person.setLastName("Azizi");
        person.setAge(35);
        return ResponseEntity.ok(person);
    }

    @GetMapping(value = "/p3",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> employees(){
        return restTemplate.exchange("https://dummy.restapiexample.com/api/v1/employees",
                HttpMethod.GET, null, String.class);
    }

}
