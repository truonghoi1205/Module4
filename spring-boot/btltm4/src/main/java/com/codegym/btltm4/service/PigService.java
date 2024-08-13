package com.codegym.btltm4.service;

import com.codegym.btltm4.model.Pig;
import com.codegym.btltm4.repository.PigRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PigService implements IPigService{

    @Autowired
    private PigRepo pigRepo;

    public Iterable<Pig> getAllPig() {
        return pigRepo.findAll();
    }

    public Iterable<Pig> searchPig(String code, String name, boolean sold) {
        return pigRepo.findByCodeContainingAndSoldAndOriginName(
                code != null ? code : "",
                name != null ? name : "",
                sold
        );
    }

    public Pig getPigById(Long id) {
        return pigRepo.findById(id).orElse(null);
    }

    public void savePig(Pig pig) {
        pigRepo.save(pig);
    }

    public void deletePig(Long id) {
        pigRepo.deleteById(id);
    }

    public boolean sellPig(Long pigId) {
        Optional<Pig> pig = pigRepo.findById(pigId);
        if (pig.isPresent()) {
            Pig p = pig.get();
            p.setSellDate(LocalDate.now()); // Cập nhật ngày bán
            // Optional: Set weight on sell if needed
            pigRepository.save(p);
            return true;
        }
        return false;
    }
}
