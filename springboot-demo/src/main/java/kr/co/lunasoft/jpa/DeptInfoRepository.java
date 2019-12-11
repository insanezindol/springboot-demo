package kr.co.lunasoft.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.lunasoft.model.DeptInfo;

public interface DeptInfoRepository extends JpaRepository<DeptInfo, Integer> {
	
}
