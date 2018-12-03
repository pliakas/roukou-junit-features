package org.roukou.junit.features.core;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Parameterized tests make it possible to run a test multiple times with different arguments.
 * They are declared just like regular @Test methods but use the @ParameterizedTest annotation instead.
 * In addition, you must declare at least one source that will provide the arguments for each invocation
 * and then consume the arguments in the test method.
 */

@TestInstance( TestInstance.Lifecycle.PER_CLASS)
class ParameterizedTests
{
    @ParameterizedTest
    @ValueSource( strings = { "bravo", "charlie", "delta", "foxtrot" } )
    void upperCaseUsingValueSource( String word )
    {
        assertTrue( hasOddLength( word  ) );
    }

    @ParameterizedTest
    @MethodSource( "oddLenghtWord" )
    void upperCaseUsingMethodSource( String word )
    {
        assertTrue( hasOddLength( word  ) );
    }

    boolean hasOddLength( String input )
    {
        Predicate<String> predicate = word -> ( word.length() & 1 ) == 1;

        return predicate.test( input );
    }

    static Stream<String> oddLenghtWord()
    {
        return Stream.of( "bravo", "charlie", "delta" );
    }
}
