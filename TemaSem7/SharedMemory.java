package org.example;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class SharedMemory {
    private static List<Token> tokens = null;

    /**
     * se creeaza o lista cu n numere random
     * @param n
     */
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

    /**
     * functia creeaza o lista de 3 tokenuri pe care le aleg din lista initiala de tokenuri
     * @param howMany
     * @return
     */
    public static synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extracted.add(tokens.get(i));
            //System.out.println(tokens.get(i));
        }
        return extracted;
    }
}