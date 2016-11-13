package com.fqc.springboot.demo06;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

//@EnableAutoConfiguration
@Repository
public interface DemoRepository extends PagingAndSortingRepository<Demo, Long> {
}