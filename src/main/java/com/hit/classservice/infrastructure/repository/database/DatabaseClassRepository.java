package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.ClassRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("DatabaseClassRepository")
public interface DatabaseClassRepository extends ClassRepository {
}
