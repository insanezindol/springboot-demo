package kr.co.lunasoft.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.lunasoft.model.NoticeInfo;

@Repository
public interface NoticeMapper {    

	List<NoticeInfo> selectList();

	NoticeInfo selectOne(NoticeInfo param);

	int insertNotice(NoticeInfo param);

	int updateNotice(NoticeInfo param);

	int deleteNotice(NoticeInfo param);
    
}
