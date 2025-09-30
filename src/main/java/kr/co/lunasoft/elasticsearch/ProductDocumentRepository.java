package kr.co.lunasoft.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository("ProductDocumentRepository")
public interface ProductDocumentRepository extends ElasticsearchRepository<ProductDocument, String> {

}
