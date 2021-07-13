package com.joaogsrocha._carservice;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface CarRepository extends ReactiveMongoRepository<Car, UUID> {
}
