package com.hy.activiti7.Test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.junit.Test;

/**
 * @author by 奕丶尘
 * @Classname TestCreate
 * @Date 2025/5/22 23:20
 */
public class TestCreate {
    @Test
    public void testCreateDbTable() {
        //使用activiti提供的工具类创建表
        //会默认读取resources下的activiti.cfg.xml文件
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        System.out.println ( processEngine );
    }
}
