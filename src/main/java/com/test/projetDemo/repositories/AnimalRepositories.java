package com.test.projetDemo.repositories;

import com.test.projetDemo.beans.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepositories extends JpaRepository<Animal, Integer> {
    List<Animal> findByEspece(String espece);
    List<Animal> findByOrderByAge();
    List<Animal> findByAgeGreaterThan(int age);
    List<Animal> findTop2ByOrderByAge();
    Animal findFirstByEspeceOrderByAge(String espece);
    List<Animal> findByNomLike(String espece);
}
