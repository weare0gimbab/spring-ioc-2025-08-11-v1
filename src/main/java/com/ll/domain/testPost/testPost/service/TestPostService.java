package com.ll.domain.testPost.testPost.service;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;


public class TestPostService {
    private final TestPostRepository testPostRepository;

    public TestPostService(TestPostRepository testPostRepository) {

        this.testPostRepository = testPostRepository;
    }
}
