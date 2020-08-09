package com.test.controller.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Location;

public interface ILocationDao extends JpaRepository<Location, Long>{

}
