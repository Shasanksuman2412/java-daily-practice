package com.javadailypractice.demo;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int multiply(int a, int b, int c) {
        return a * b * c;
    }

    public java.util.List<Integer> fibonacciList(int count) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < count; i++) {
            result.add(a);
            int next = a + b;
            a = b;
            b = next;
        }
        return result;
    }
}
