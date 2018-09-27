package com.gtq.javasample.designpattern.interpreter;

import java.util.Map;

public abstract class SymbolExpression implements Expression {
    protected Expression mLeft;
    protected Expression mRight;

    public SymbolExpression(Expression left, Expression right) {
        mLeft = left;
        mRight = right;
    }
}
