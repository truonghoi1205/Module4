package com.codegym.btltm4.repository;

import com.codegym.btltm4.model.Pig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PigRepo extends JpaRepository<Pig,Long> {

    Iterable<Pig> findBySold(boolean sold);
    Iterable<Pig> findByCodeContaining(String code);
    Iterable<Pig> findByOriginNameContaining(String name);

    Iterable<Pig> findByCodeContainingAndSoldAndOriginName(String code,  String name,boolean sold);
}
