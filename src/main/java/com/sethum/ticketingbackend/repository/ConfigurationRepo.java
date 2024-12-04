package com.sethum.ticketingbackend.repository;

import com.sethum.ticketingbackend.model.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigurationRepo extends JpaRepository<Configuration, Long> {
}
