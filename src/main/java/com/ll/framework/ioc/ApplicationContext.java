package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
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

        Object bean;
        if ("testPostService".equals(beanName)) {
            TestPostRepository testPostRepository = new TestPostRepository();
            bean = new TestPostService(testPostRepository);
            beans.put(beanName, bean);
        } else return null;
        return (T) bean;
    }
}

