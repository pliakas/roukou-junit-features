package org.roukou.junit.features.core;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * The standard @Test annotation in JUnit Jupiter described in Annotations is very similar to the @Test annotation
 * in JUnit 4. Both describe methods that implement test cases. These test cases are static in the sense that
 * they are fully specified at compile time, and their behavior cannot be changed by anything happening at runtime.
 * Assumptions provide a basic form of dynamic behavior but are intentionally rather limited in their expressiveness.
 * <p>
 * a completely new kind of test programming model has been introduced in JUnit Jupiter. This new kind of test
 * is a dynamic test which is generated at runtime by a factory method that is annotated with @TestFactory.
 * <p>
 * a completely new kind of test programming model has been introduced in JUnit Jupiter. This new kind of test
 * is a dynamic test which is generated at runtime by a factory method that is annotated with @TestFactory.
 *
 * @TestFactory method must return a Stream, Collection, Iterable, Iterator, or array of DynamicNode instances.
 */

class DynamicTests
{
    @TestFactory
    Stream<DynamicNode> firstTenEvenIntegers()
    {
        return IntStream.iterate( 0, n -> n + 2 ).limit( 10 )
            .mapToObj( n -> dynamicTest( "test" + n,
                () -> assertTrue( n % 2 == 0 ) ) );
    }

    @TestFactory
    Stream<DynamicNode> dynamicStrings()
    {
        return Stream.of( "A", "B", "C" )
            .map( str -> dynamicTest( "test" + str,
                () -> assertTrue( str.charAt( 0 ) < 'A' ) ) );
    }
}
