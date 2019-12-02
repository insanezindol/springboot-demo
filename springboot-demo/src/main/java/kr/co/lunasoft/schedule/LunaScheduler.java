package kr.co.lunasoft.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LunaScheduler {
	
	// 초(0-59) 분(0-59) 시간(0-23) 일(1-31)　월(1-12)　요일(0-7)

    // cron 에 명시된 시간에 실행
    @Scheduled(cron = "0 0 * * * ?")
    public void cronJobSch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String strDate = sdf.format(now);
        log.info("cron task - " + strDate);
    }

}
