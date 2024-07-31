package com.codegym.thuchanhajax.service.classroom;

import com.codegym.thuchanhajax.model.Classroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClassroomService {
    Page<Classroom> findAllClassroom(Pageable pageable);
}
