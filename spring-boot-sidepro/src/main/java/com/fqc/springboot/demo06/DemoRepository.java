package com.fqc.springboot.demo06;

import org.springframework.data.repository.PagingAndSortingRepository;

//@EnableAutoConfiguration
//@Repository 不加也可以的
public interface DemoRepository extends PagingAndSortingRepository<Demo, Long> {
}