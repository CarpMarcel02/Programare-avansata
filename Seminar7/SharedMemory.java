package org.example;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class SharedMemory {
    private static List<Token> tokens = null;


    public SharedMemory(int n) {
        tokens = new ArrayList<>();

        for(int i=0;i<n;i++) {
            Random random = new Random();
            int randomInt = random.nextInt(n);
            Token token = new Token(randomInt);
            tokens.add(token);
        }
        Collections.shuffle(tokens);

    }
    public static synchronized Token extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extracted.add(tokens.get(i));
        }
        return (Token) extracted;
    }
}