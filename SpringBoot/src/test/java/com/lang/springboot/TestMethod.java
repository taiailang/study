package com.lang.springboot;

import com.arcsoft.face.toolkit.ImageInfo;
import com.lang.springboot.bean.AsyncTasks;
import com.lang.springboot.bean.SomeBean;
import com.lang.springboot.config.Config;
import com.lang.springboot.handler.HelloJobHandler;
import com.lang.springboot.scheduled.ScheduledTask;
import com.lang.springboot.service.TestService;
import com.lang.springboot.util.Utils;
import com.xxl.job.core.biz.model.ReturnT;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.concurrent.CompletableFuture;

import static com.arcsoft.face.toolkit.ImageFactory.getRGBData;


/**
 * @author 浪浪
 * @date 2022/2/25
 */

@Slf4j
@SpringBootTest(classes = SpringbootStartApplication.class)
@RunWith(SpringRunner.class)
public class TestMethod {

    @Autowired
    private AsyncTasks asyncTasks;

    @Autowired
    private TestService testService;

    @Autowired
    private ScheduledTask scheduledTask;

    @Autowired
    private HelloJobHandler helloJobHandler;

    /**
     * 测试异步调用
     */
    @Test
    public void testAsync() throws Exception {
        long start = System.currentTimeMillis();

        CompletableFuture<String> task1 = asyncTasks.doTaskOne();
        CompletableFuture<String> task2 = asyncTasks.doTaskTwo();
        CompletableFuture<String> task3 = asyncTasks.doTaskThree();

        CompletableFuture.allOf(task1, task2, task3).join();
        System.out.println(task1);
        System.out.println(task2);
        System.out.println(task3);

        long end = System.currentTimeMillis();
        log.info("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

    @Test
    public void test() {

        Boolean a = false;
        Integer b = 10;
        Integer c = 100;
        System.out.println(a ? b : c);

    }

    /**
     * 测试读取配置文件
     */
    @Test
    public void testAnnotation() {
        String str = testService.testAnnotation();
        System.out.println(str);
    }

    /**
     * 测试获取bean
     */
    @Test
    public void testConfig() {
//        SomeBean someBean = config.someBean();
//        someBean.doWork();
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SomeBean sb = context.getBean(SomeBean.class);
        sb.doWork();
    }

    /**
     * 测试获取bean的三种状态
     */
    @Test
    public void testConfig1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SomeBean sb1 = context.getBean(SomeBean.class);
        System.out.println(sb1);
        SomeBean sb2 = context.getBean(SomeBean.class);
        System.out.println(sb2);
        context.close();
    }

    /**
     * 测试Scheduled定时任务
     */
    @Test
    public void testScheduledTask() {
        scheduledTask.testScheduledTask();
        ReturnT<String> execute = null;
        try {
            execute = helloJobHandler.execute("1000");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(execute);
    }

    /**
     * 将url转化为file文件
     */
    @Test
    public void TestUrlToFile() {
        File fileByUrl = Utils.getFileByUrl("https://lang-feng.oss-cn-hangzhou.aliyuncs.com/%E6%AD%A6.jpg");
        System.out.println(fileByUrl);
        ImageInfo imageInfo = getRGBData(fileByUrl);
        System.out.println(imageInfo);
    }

}
