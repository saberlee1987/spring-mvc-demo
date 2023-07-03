package com.saber.springmvcdemo.site.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "Person")
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
}
