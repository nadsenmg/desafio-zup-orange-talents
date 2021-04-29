package com.zup.desafioorange.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.desafioorange.model.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, UUID>{

}
