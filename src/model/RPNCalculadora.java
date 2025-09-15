package model;

import java.util.Stack;

public class RPNCalculadora {
    public double evaluateRPN(String expression) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Expressão RPN inválida: operandos insuficientes para o operador " + token);
                }
                double operando2 = stack.pop();
                double operando1 = stack.pop();
                double result = applyOperator(operando1, operando2, token);
                stack.push(result);
            } else {
                throw new IllegalArgumentException("Token inválido na expressão RPN: " + token);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Expressão RPN inválida: muitos operandos");
        }

        return stack.pop();
    }

    private boolean isNumeric(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private double applyOperator(double op1, double op2, String operador) {
        switch (operador) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                if (op2 == 0) {
                    throw new ArithmeticException("Divisão por zero");
                }
                return op1 / op2;
            default:
                throw new IllegalArgumentException("Operador Inválido: " + operador);
        }
    }

}
