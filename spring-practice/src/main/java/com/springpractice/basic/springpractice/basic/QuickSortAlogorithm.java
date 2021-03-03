package com.springpractice.basic.springpractice.basic;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSortAlogorithm implements SortAlgorithm {
    @Override
    public Integer[] sort(Integer[] numbers) {
        return numbers;
    }
}
