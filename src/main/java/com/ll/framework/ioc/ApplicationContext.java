package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestFacadePostService;
import com.ll.domain.testPost.testPost.service.TestPostService;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    // bean저장할 해쉬맵
    private static Map<String, Object> beans = new HashMap<>();

    public ApplicationContext() {

    }

    public <T> T genBean(String beanName) {
        //beans에 존재하는 이름이면 그 빈 반환
        if (beans.containsKey(beanName)) {
            return (T) beans.get(beanName);
        }

        Object bean = null;
        if (!beans.containsKey(beanName)) {
            if ("testFacadePostService".equals(beanName)) {
                TestPostService testPostService = genBean("testPostService");
                TestPostRepository testPostRepository = genBean("testPostRepository");
                bean = new TestFacadePostService(testPostService, testPostRepository);
                beans.put(beanName, bean);
            } else if ("testPostRepository".equals(beanName)) {
                bean = new TestPostRepository();
                beans.put(beanName, bean);
            } else if ("testPostService".equals(beanName)) {
                TestPostRepository testPostRepository = genBean("testPostRepository");
                bean = new TestPostService(testPostRepository);
                beans.put(beanName, bean);
            } else {
                throw new IllegalArgumentException("Unknown bean name: " + beanName);
            }
        }
        return (T) bean;
    }
}

