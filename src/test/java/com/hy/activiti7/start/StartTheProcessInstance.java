package com.hy.activiti7.start;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

/**
 * @author by 奕丶尘
 * @Classname StartTheProcessInstance
 * @Date 2025/5/25 19:49
 */
public class StartTheProcessInstance {
    /*
    * 启动流程实例
     */
    @Test
    public void startTheProcessInstance(){
        // 获取默认的流程引擎
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine ( );
        // 获取运行时服务，用于管理和执行流程实例
        RuntimeService runtimeService = defaultProcessEngine.getRuntimeService ( );
        // 通过流程定义的键启动流程实例
        ProcessInstance myEvection = runtimeService.startProcessInstanceByKey ( "myEvection" );
        // 输出流程实例信息
        System.out.println ("流程定义ID="+myEvection.getProcessDefinitionId () );
        System.out.println ("流程实例ID="+myEvection.getId () );
        System.out.println ("当前活动的ID="+myEvection.getActivityId () );
        }
}
