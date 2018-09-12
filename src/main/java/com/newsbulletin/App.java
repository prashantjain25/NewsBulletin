package com.newsbulletin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.newsbulletin.service.NewsDeliveryImpl;
import com.newsbulletin.util.BulletinCSVReader;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    
    
    public static void main( String[] args ) throws IOException
    {
        SpringApplication.run(App.class, args);
    }
}
