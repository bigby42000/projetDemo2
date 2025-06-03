package com.test.projetDemo.repositories;

import com.test.projetDemo.beans.Territoire;
import com.test.projetDemo.beans.Territoire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerritoireRepositories extends JpaRepository<Territoire, Integer> {
    Territoire findById(int id);
}
