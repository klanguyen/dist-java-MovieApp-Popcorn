package edu.wctc.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

public class HibernateAwareObjectMapper extends ObjectMapper {
    public HibernateAwareObjectMapper() {
        // Our object mapper is just like Jackson's default,
        // but it knows it's using Hibernate 5
        registerModule(new Hibernate5Module());

        // This is supposed to stop LocaleDates from printing
        // as giant objects, but it's not working
        configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
    }
}
