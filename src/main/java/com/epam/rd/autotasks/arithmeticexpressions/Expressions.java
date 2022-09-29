package com.epam.rd.autotasks.arithmeticexpressions;
import java.util.Arrays;
import java.util.StringJoiner;

public class Expressions {

    public static Variable var(String name, int value) {
       Variable variable = new Variable(name, value);
        return variable;
    }

    public static Expression val(int value) {
        Expression val = new Expression() {
            @Override
            public int evaluate() {
                return value;
            }
            @Override
            public String toExpressionString() {
                String value2 = Integer.toString(value);
                if (value<0){
                    return "("+value2+")";
                }
                return value2;
            }
        };
        return val;
    }

    public static Expression sum(Expression... members){
        Expression sum = new Expression() {
            @Override
            public String toExpressionString() {
                String Sum ="(";
                for (Expression x:members){
                Sum += (x.toExpressionString()+" + ");
                }
                Sum = Sum.substring(0,(Sum.length()-3));
                Sum += ")";
                return Sum;
            }
            @Override
            public int evaluate() {
                int res = 0;
                for (Expression x:members){
                    res += x.evaluate();
                }
                return res;
                 }
        };
        return sum;
    }

    public static Expression product(Expression... members){
        Expression prod = new Expression() {
            @Override
            public int evaluate() {
                int res = 1;
                for (Expression y:members){
                    res *= y.evaluate();
                }
                return res;
            }

            @Override
            public String toExpressionString() {
                String Sum ="(";
                for (Expression x:members){
                    Sum += (x.toExpressionString()+" * ");
                }
                Sum = Sum.substring(0,(Sum.length()-3));
                Sum += ")";
                return Sum;
            }
        };
        return prod;
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
        Expression dif = new Expression() {
            @Override
            public int evaluate() {
                int A = minuend.evaluate() - subtrahend.evaluate();
                return A;
            }
            @Override
            public String toExpressionString() {
                String A = minuend.toExpressionString();
                String B = subtrahend.toExpressionString();
                return "("+A+" - "+B+")";
            }
        };
        return dif;
    }

    public static Expression fraction(Expression dividend, Expression divisor){
        Expression frac = new Expression() {
            @Override
            public int evaluate() {
                int A = dividend.evaluate();
                int B = divisor.evaluate();
                return A/B;
            }
            @Override
            public String toExpressionString() {
                String A = dividend.toExpressionString();
                String B = divisor.toExpressionString();
                return "("+A+" / "+B+")";
            }
        };
        return frac;
    }

}
