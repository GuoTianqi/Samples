package com.gtq.javasample.designpattern.interpreter;

import java.util.Map;

public class VarExpression implements Expression {
    private String mKey;

    public VarExpression(String key) {
        mKey = key;
    }

    @Override
    public int interpreter(Map<String, Integer> var) {
        return var.get(mKey);
    }
}
