package kr.co.lunasoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.lunasoft.mapper.NoticeMapper;
import kr.co.lunasoft.model.NoticeInfo;

@Service
public class NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;

	@Transactional(readOnly = true)
	public List<NoticeInfo> getList() {
		return noticeMapper.selectList();
	}

	@Transactional(readOnly = true)
	public NoticeInfo getOne(NoticeInfo param) {
		return noticeMapper.selectOne(param);
	}

	@Transactional
	public int addNotice(NoticeInfo param) {
		return noticeMapper.insertNotice(param);
	}

	@Transactional
	public int modifyNotice(NoticeInfo param) {
		return noticeMapper.updateNotice(param);
	}

	@Transactional
	public int removeNotice(NoticeInfo param) {
		return noticeMapper.deleteNotice(param);
	}

}
