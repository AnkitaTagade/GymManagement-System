package com.app.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.app.Entity.Customer;
import com.app.Entity.Role;
import com.app.repository.CustomerReopository;


@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CustomerReopository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
   
    @Override
    public void run(String... args) {
        // Save the area first
      
        if (adminRepository.findByEmail("admin@gmail.com").isEmpty()) {
            Customer admin = new Customer();
            admin.setName("Admin User");
            admin.setEmail("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setContact("123456790");
            admin.setGender("MALE");
            
            admin.setRole(Role.ROLE_ADMIN);
           
            

            adminRepository.save(admin);
            System.out.println("Admin user seeded successfully.");
        } else {
            System.out.println("Admin user already exists.");
        }
    }



}
