package kr.co.lunasoft.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.lunasoft.model.EmpInfo;

public interface EmpInfoRepository extends JpaRepository<EmpInfo, Integer> {
	
}
