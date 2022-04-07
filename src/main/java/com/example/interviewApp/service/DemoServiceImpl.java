package com.example.interviewApp.service;

import com.example.interviewApp.model.Runner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String firstUniqueProduct(String[] products) {
        Map<String, Long> productMap = Arrays.stream(products)
                .collect(Collectors.groupingBy(p -> p, LinkedHashMap::new, Collectors.counting()));
        for (String product : productMap.keySet()) {
            if (productMap.get(product) == 1) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void getTasks(Runner runner) {
        runner.acquireResource(1).performTask("Task11");
        runner.acquireResource(2).performTask("Task21");
        System.out.println(String.join(", ", runner.acquireResource(2).getTasks()));
        runner.releaseResource(2);
        runner.acquireResource(1).performTask("Task12");
        System.out.println(String.join(", ", runner.acquireResource(1).getTasks()));
        runner.releaseResource(1);
    }
}
