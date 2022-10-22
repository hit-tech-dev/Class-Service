package com.hit.classservice.infrastructure.repository.database;

import com.hit.classservice.application.dai.DocumentRepository;
import com.hit.classservice.domain.entity.Document;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository("DatabaseDocumentRepository")
public interface DatabaseDocumentRepository extends DocumentRepository {
  List<Document> getListDocumentByLessonId(@Param("lessonId") Long lessonId);
}
