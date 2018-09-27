package com.gtq.javasample.designpattern.interpreter;

import java.util.Map;

public interface Expression {
    public int interpreter(Map<String, Integer> var);
}
