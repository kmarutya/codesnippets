package com.kmarutyan.interview.misc;


import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        Integer curDigit = 0;
        Expression curExpr = null;
        char [] chars = s.toCharArray();
        for( int i = 0; i < chars.length; i++){
            Character c =  chars[i];
            boolean isLast = (i ==chars.length-1);

            if(Character.isDigit(c) ){
                curDigit = curDigit * 10 + Character.getNumericValue(c);
                if( !isLast)
                    continue;
            }
            if(curExpr == null){
                curExpr =   parseExpression(c);
                stack.push(curDigit);
                curDigit = 0;
            }
            int a = (curExpr.getPrecedence() == 1) ? stack.pop(): 0;
            int val =  curExpr.apply(a, curDigit);
            stack.push(val);
            curDigit = 0;

            if(!isLast)
                curExpr = parseExpression(c);

        }

        int ans = stack.stream().mapToInt(i-> i).sum();
        return ans;
    }

    public static boolean isDigit(String str){
        try{
            Integer.parseInt(str);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }


    public static final Expression parseExpression(Character expr){
        switch(expr){
            case '-':  return Expression.MINUS;
            case '+':  return Expression.PLUS;
            case '*':  return Expression. MULTIPLY;
            case '/':  return Expression.DIVIDE;
        }
        throw new RuntimeException( String.format("Wrong expression %s", expr));
    }

    public static void main(String... args){
        BasicCalculator  cal  = new BasicCalculator();
        System.out.println(cal.calculate("3+2*2"));
        System.out.println(cal.calculate("3-2*2"));
        System.out.println(cal.calculate("3-2*12"));
        System.out.println(cal.calculate("3-2*12+9 "));
    }
}





enum Expression {
    MINUS("-", 0){
        public  int apply(int a, int b){
            return a - b;
        }
    },
    PLUS("+",0){
        public  int apply(int a, int b){
            return a + b;
        }
    },
    MULTIPLY("*",1){
        public  int apply(int a, int b){
            return a * b;
        }
    },
    DIVIDE("/",1){
        public  int apply(int a, int b){
            return a / b;
        }
    };
    private final String strExpr;
    private final Integer precedence;
    Expression(String strExpr, Integer precedence)  {
        this.strExpr = strExpr;
        this.precedence = precedence;
    }

   public abstract int apply(int a, int b);

    public String getStrExpr() {
        return strExpr;
    }
    public Integer getPrecedence() {
        return precedence;
    }
}
