package org.jfree.chart.imagemap;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Tests for the {@link StandardURLTagFragmentGenerator} class.
 */
public class StandardURLTagFragmentGeneratorTest {

    /**
     * Some checks for the generateURLFragment() method.
     */
    public void testGenerateURLFragment() {
        StandardURLTagFragmentGenerator g = new StandardURLTagFragmentGenerator();
        assertEquals(" href=\"http://www.jfree.org/images/abc.png\"", g.generateURLFragment("http://www.jfree.org/images/abc.png"));
    }
}
