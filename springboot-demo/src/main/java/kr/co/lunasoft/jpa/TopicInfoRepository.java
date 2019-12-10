package kr.co.lunasoft.jpa;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kr.co.lunasoft.model.TopicInfo;

public interface TopicInfoRepository extends JpaRepository<TopicInfo, Long> {
	
	public List<TopicInfo> findAllByTitleLike(String title);
	
	@Modifying
	@Transactional
	@Query(value="UPDATE appdb.topic SET title = :#{#param.title}, description = :#{#param.description} WHERE id = :#{#param.id}", nativeQuery=true)
	Integer updateTopicById(@Param("param") TopicInfo param );
	
}
