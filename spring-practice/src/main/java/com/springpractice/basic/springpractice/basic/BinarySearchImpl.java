package com.springpractice.basic.springpractice.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BinarySearchImpl implements Comparable<Integer> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //Sorting an array
    //Search the array
    //Return the result
    @Autowired
 private SortAlgorithm sortAlgorithm;

    List<Integer> l1 = new ArrayList<>();
    public int binarySearch(Integer[] numbers, Integer numerToSearch){


        sortAlgorithm.sort(numbers);

        for (int i = 0; i < numbers.length; i++){
           l1.add(numbers[i]);
        }
       int result = Collections.binarySearch(l1, numerToSearch, null);


        System.out.println(sortAlgorithm);
        return result;
    }

    @Override
    public int compareTo(Integer i) {
        return this.compareTo(i);
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("postConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        logger.info("preDestroy");
    }

}
