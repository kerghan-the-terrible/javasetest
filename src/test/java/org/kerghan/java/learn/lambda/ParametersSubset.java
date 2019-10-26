package org.kerghan.java.learn.lambda;

import org.junit.Test;

import java.util.function.Function;

public class ParametersSubset {

    private static String moreParameters(String p1, String p2) {
        return p1 + p2;
    }

    private static void doPrint(Function<String, String> labda, String p) {
        System.out.println(labda.apply(p));
    }

    @Test
    public void testLambda() {
        doPrint((p) -> moreParameters("p1 ", p), "p2");
    }

}
