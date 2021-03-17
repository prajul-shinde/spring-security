package com.example.demo.authdb;

import java.util.Optional;

public interface ApplicationUserDao {

     Optional<ApplicationUser>selectApplicationUserByUsername(String username);
}
