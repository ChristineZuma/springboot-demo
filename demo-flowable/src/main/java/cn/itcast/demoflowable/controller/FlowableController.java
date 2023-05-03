package cn.itcast.demoflowable.controller;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping
public class FlowableController {
    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    /**
     * 部署流程
     */
    @GetMapping("/deploy")
    public void deployProcess(){
        Deployment deploy = repositoryService
                .createDeployment()
                .addClasspathResource("process/spring-holiday.bpmn20.xml")
                .name("spring请假")
                .deploy();
        System.out.println("deploy.getName() = " + deploy.getName());
        System.out.println("deploy.getId() = " + deploy.getId());
    }

    /**
     * 开启流程
     */
    @GetMapping("/start")
    public void startProcess(){
        Map<String, Object> map = new HashMap<>();
        map.put("employee1","zhangsan");
        map.put("employee2","lisi");
        ProcessInstance processInstance = runtimeService.startProcessInstanceById("spring-holiday:2:80b54e18-e9c8-11ed-b2c4-0242ca064cd5", map);
    }

    /**
     * 完成
     */
    @GetMapping("/finish")
    public void finishTask(){
        Task task = taskService.createTaskQuery()
                .processDefinitionId("spring-holiday:2:80b54e18-e9c8-11ed-b2c4-0242ca064cd5")
                .taskAssignee("lisi")
                .singleResult();
        if(Objects.nonNull(task)){
            taskService.complete(task.getId());
        }

    }
}
