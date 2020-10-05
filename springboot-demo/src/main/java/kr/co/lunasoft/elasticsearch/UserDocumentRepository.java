package kr.co.lunasoft.elasticsearch;

import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDocumentRepository")
public interface UserDocumentRepository extends ElasticsearchRepository<UserDocument, String> {

    List<UserDocument> findByAge(int age, Sort sort);

    List<UserDocument> findByName(String name, Sort sort);

}
