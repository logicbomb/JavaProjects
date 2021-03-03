package com.springpractice.basic.springpractice.basic;

import org.springframework.stereotype.Component;

import javax.annotation.Priority;

@Component
@Priority(1)
public class BubbleSorAlogrith implements SortAlgorithm {



    @Override
    public Integer[] sort(Integer[] numbers) {
        return numbers;
    }
}
