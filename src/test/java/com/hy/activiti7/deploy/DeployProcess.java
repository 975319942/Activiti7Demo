package com.hy.activiti7.deploy;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * @author by 奕丶尘
 * @Classname DeployProcess
 * @Date 2025/5/25 18:51
 */
public class DeployProcess {
    /**
     * 通过资源部署流程
     */
    @Test
    public void deployProcess(){
        // 获取默认的流程引擎
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine ( );
        // 获取仓库服务，用于管理流程定义和流程资源
        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService ( );
        // 创建一个新的部署，并设置出差申请流程的名称
        // 添加流程定义文件和流程图到部署中
        // 最后，执行部署
        Deployment deploy = repositoryService.createDeployment ( )
                .name ( "出差申请流程" )
                .addClasspathResource ( "bpmn/evection.bpmn" )
                .addClasspathResource ( "bpmn/png/evection-出差申请流程.png" )
                .deploy ( );
        // 打印部署对象，用于调试和验证流程是否成功部署
        System.out.println ("流程部署对象="+deploy );
    }

    /**
     * 通过zip部署流程
     */
    @Test
    public void deployProcessByZip(){
        // 获取默认的流程引擎
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine ( );
        // 获取仓库服务，用于管理流程定义和流程资源
        RepositoryService repositoryService = defaultProcessEngine.getRepositoryService ( );
        //通过相对路径获取bpmn的zip文件
        InputStream inputStream = this.getClass ( ).getClassLoader ( ).getResourceAsStream ( "bpmn/evection.zip" );
        ZipInputStream zipInputStream = new ZipInputStream ( inputStream);
        // 创建一个新的部署，并设置出差申请流程的名称
        // 添加zip文件到部署中
        // 最后，执行部署
        Deployment deploy = repositoryService.createDeployment ( )
                .addZipInputStream (  zipInputStream)
                .deploy ( );
        // 打印部署对象，用于调试和验证流程是否成功部署
        System.out.println ("流程部署对象="+deploy );
    }

}
