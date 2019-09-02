package com.demo.frame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


public class DataSourceSwitcher extends AbstractRoutingDataSource {
    private static Logger logger = LoggerFactory.getLogger(DataSourceSwitcher.class);

    private static ThreadLocal<String> DATASOURCE_KEY = new ThreadLocal<String>();

    protected Object determineCurrentLookupKey() {
        String key = DATASOURCE_KEY.get();
        logger.debug("thread:{},DataSourceKety:{}", Thread.currentThread().getName(), key);
        return key;
    }

    public static void setDatasourceKey(String datasourceKey) {
        DATASOURCE_KEY.set(datasourceKey);
        logger.debug("thread:{},setDatasourceKey:{}", Thread.currentThread().getName(), datasourceKey);
    }

    public static void clearDatasourceKey() {
        logger.debug("thread:{},clearDatasourceKey:{}", Thread.currentThread().getName(), DATASOURCE_KEY.get());
        DATASOURCE_KEY.remove();
    }

}