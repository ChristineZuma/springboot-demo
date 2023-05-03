package cn.itcast.demoflowable;

import org.flowable.engine.ProcessEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoFlowableApplicationTests {

    @Autowired
    private ProcessEngine processEngine;
    @Test
    void contextLoads() {
        System.out.println("processEngine = " + processEngine);
    }

}
