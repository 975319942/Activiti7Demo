package com.hy.activiti7.demo;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

/**
 * @author by 奕丶尘
 * @Classname ProcessDemo
 * @Date 2025/5/25 22:24
 */
public class ProcessDemo {
    /**
     * 查询用户的待办列表
     * 此方法用于查询指定用户的所有待办任务，通过流程定义键和任务负责人进行筛选
     */
    @Test
    public void queryUserToDoList(){
        // 获取默认的流程引擎
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine ( );
        // 获取任务服务
        TaskService taskService = defaultProcessEngine.getTaskService ( );
        // 查询任务列表，根据流程定义键"myEvection"和任务负责人"zhanshan"进行筛选
        List < Task > list = taskService.createTaskQuery ( ).processDefinitionKey ( "myEvection" ).taskAssignee ( "zhanshan" ).list ( );
        // 遍历任务列表，输出任务信息
        for (Task task : list) {
            // 输出流程实例ID
            System.out.println ("流程实例ID="+task.getProcessInstanceId ());
            // 输出任务ID
            System.out.println ("任务ID="+task.getId ());
            // 输出任务负责人
            System.out.println ("任务负责人="+task.getAssignee ());
            // 输出任务名称
            System.out.println ("任务名称="+task.getName ());
        }
    }

    /**
     * 完成用户的待办
     * 此方法用于查询并完成指定负责人的所有待办任务
     * 它通过流程引擎获取任务服务，并根据流程定义键和任务负责人查询任务，然后完成这些任务
     */
    @Test
    public void completeToDo(){
        // 获取默认的流程引擎
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine ( );
        // 获取任务服务
        TaskService taskService = defaultProcessEngine.getTaskService ( );
        // 查询流程定义键为"myEvection"且任务负责人为"zhanshan"的所有任务
        List < Task > list = taskService.createTaskQuery ( ).processDefinitionKey ( "myEvection" ).taskAssignee ( "zhanshan" ).list ( );
        // 遍历查询到的任务列表
        for (Task task : list) {
            // 输出流程实例ID
            System.out.println ("流程实例ID="+task.getProcessInstanceId ());
            // 输出任务ID
            System.out.println ("任务ID="+task.getId ());
            // 输出任务负责人
            System.out.println ("任务负责人="+task.getAssignee ());
            // 输出任务名称
            System.out.println ("任务名称="+task.getName ());
            // 完成当前任务
            taskService.complete ( task.getId () );
            // 完成当前任务
            System.out.println ("已发送至下一个流程节点！");
        }

    }

}
