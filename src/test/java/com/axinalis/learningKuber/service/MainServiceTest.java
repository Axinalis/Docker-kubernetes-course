package com.axinalis.learningKuber.service;

import com.axinalis.learningKuber.dao.MainRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {MainService.class, ObjectMapper.class})
public class MainServiceTest {

    @MockBean
    private MainRepository dao;
    @Autowired
    private MainService service;

    @Test
    public void getPrimesTest(){
        assertEquals("3, 5", service.getPrimesAsString(15L));
        assertEquals("5, 5, 5, 5", service.getPrimesAsString(625L));
        assertEquals("7, 11, 13", service.getPrimesAsString(1001L));
        assertEquals("3571", service.getPrimesAsString(3571L));
        assertEquals("13, 3001, 16691", service.getPrimesAsString(651165983L));
    }
}
