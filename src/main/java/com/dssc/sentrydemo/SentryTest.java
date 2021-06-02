package com.dssc.sentrydemo;

import io.sentry.Sentry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentryTest {
    private static final Logger logger = LogManager.getLogger(SentryTest.class);

    @GetMapping("/test")
    public void test() {
        Sentry.init("https://7f2305f19a334b349dcb070b0f9b2779@o736540.ingest.sentry.io/5784995");
        logger.error("log4j test");
        System.out.println("log4j print");
    }

    @PostMapping("/springboot-sentry")
    public void sentry() {
        try {
            throw new Exception("This is a test.");
        } catch (Exception e) {
            //需要使用依赖  <groupId>io.sentry</groupId>
            //            <artifactId>sentry-spring-boot-starter</artifactId>
            //            <version>4.3.0</version>
            //Sentry.captureException(e);
        }
    }
}
