package com.epam.info.handling.logic.interpreter.expression.parser.impl;

import com.epam.info.handling.logic.interpreter.expression.AbstractExpression;
import com.epam.info.handling.logic.interpreter.expression.impl.*;
import com.epam.info.handling.logic.interpreter.expression.parser.ExpressionParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArithmeticExpressionParser implements ExpressionParser<Integer> {
    private static final String NUMBERS_REGEXP = "\\d+";
    private static final String OPERATIONS_REGEXP = "[+\\-/*^]";

    @Override
    public List<AbstractExpression<Integer>> parse(String expressionText) {
        List<AbstractExpression<Integer>> expressions = new ArrayList<>();

        List<String> textExpressions = splitExpression(expressionText, NUMBERS_REGEXP);
        textExpressions.addAll(splitExpression(expressionText, OPERATIONS_REGEXP));
        for (String expression : textExpressions) {
            switch (expression) {
                case "+":
                    expressions.add(new TerminalExpressionAdd());
                    break;
                case "-":
                    expressions.add(new TerminalExpressionSubtract());
                    break;
                case "*":
                    expressions.add(new TerminalExpressionMultiply());
                    break;
                case "/":
                    expressions.add(new TerminalExpressionDivide());
                    break;
                case "^":
                    expressions.add(new TerminalExpressionPow());
                    break;
                default:
                    expressions.add(new NonTerminalExpressionNumber(Integer.valueOf(expression)));
                    break;
            }
        }

        return expressions;
    }

    private List<String> splitExpression(String expressionText, String splitter) {
        List<String> expressions = new ArrayList<>();

        Pattern operationsPattern = Pattern.compile(splitter);
        Matcher operationMatcher = operationsPattern.matcher(expressionText);

        while (operationMatcher.find()) {
            expressions.add(operationMatcher.group());
        }

        return expressions;
    }
}
