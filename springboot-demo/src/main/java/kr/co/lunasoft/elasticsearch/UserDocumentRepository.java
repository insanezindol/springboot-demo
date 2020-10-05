package kr.co.lunasoft.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("UserDocumentRepository")
public interface UserDocumentRepository extends ElasticsearchRepository<UserDocument, String> {

    List<UserDocument> findByAge(int age);

    List<UserDocument> findByName(String name);

}
