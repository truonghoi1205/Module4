package com.codegym.registrationform.repository;

import com.codegym.registrationform.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFormRepo extends JpaRepository<Form,Long> {

}
