package com.gtq.javasample.designpattern.interpreter;

import java.util.Map;

public class SubExpression extends SymbolExpression {
    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(Map<String, Integer> var) {
        return mLeft.interpreter(var) - mRight.interpreter(var);
    }
}
