package com.gtq.javasample.pecs;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<? super ClassB> customer = new ArrayList<>();
        customer.add(new ClassC());
    }
}
