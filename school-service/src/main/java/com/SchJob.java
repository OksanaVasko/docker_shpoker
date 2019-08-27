package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class SchJob {
    @Autowired
    private SchoolService schoolService;

    private static final Logger logger = LoggerFactory.getLogger(SchJob.class);
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "0 * * ? * *")
    public void currentTime() {
        logger.info("Current time = {} ", dateFormat.format(new Date()));
        schoolService.getTimeFromStudentService();
    }

}
