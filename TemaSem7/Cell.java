package org.example;

import java.util.List;

public class Cell {
    private final List<Token> tokens;

    public Cell(List<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "tokens=" + tokens +
                '}';
    }

    public List<Token> getTokens() {
        return tokens;
    }
}