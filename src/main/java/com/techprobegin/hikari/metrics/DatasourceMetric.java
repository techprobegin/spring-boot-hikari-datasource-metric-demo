package com.techprobegin.hikari.metrics;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@Component
@Slf4j
public class DatasourceMetric {
    @Autowired
    private HikariDataSource hikariDataSource;
    @Scheduled(fixedRate = 3000)
    public void metric() {
        try {
            ;
            HikariPoolMXBean hikariPoolMXBean = hikariDataSource.getHikariPoolMXBean();
            int totalConnections = hikariPoolMXBean.getTotalConnections();
            int activeConnections = hikariPoolMXBean.getActiveConnections();
            int idleConnections = hikariPoolMXBean.getIdleConnections();
            int awaitingConnection = hikariPoolMXBean.getThreadsAwaitingConnection();
            log.info("Total connections={}, active connections={},idle connections={},threads awaiting connections={}",
                    totalConnections, activeConnections, idleConnections, awaitingConnection);

        } catch (Exception e) {
            log.error("Error occurred while capturing datasource metrics ", e);
        }
    }
}
