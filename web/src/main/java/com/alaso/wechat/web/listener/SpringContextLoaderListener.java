package com.alaso.wechat.web.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * Created by adam on 4/5/16.
 */
public class SpringContextLoaderListener extends ContextLoaderListener {

    /**
     * slf4j 日志类
     **/
    private static final Logger logger = LoggerFactory.getLogger(SpringContextLoaderListener.class);

    /**
     * Spring Bean 初始化
     * <p/>
     * {@inheritDoc}
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        logger.info("-------------SpringContextLoaderListener加载开始--------------");
        super.contextInitialized(event);
    }


    /**
     * 工程关闭
     * <p/>
     * {@inheritDoc}
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        super.contextDestroyed(event);
    }
}
