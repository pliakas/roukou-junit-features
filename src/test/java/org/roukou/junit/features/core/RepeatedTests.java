package org.roukou.junit.features.core;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RepeatedTests
{
    @RepeatedTest( 10 )
    void simpleRepeatedTest()
    {
        var result = veryBadOddNumberGenerator();

        Predicate<Integer> predicate = number -> ( number.intValue() & 1 ) == 1 ;

        result.forEach(
            entry -> assertTrue( predicate.test( entry ) )
        );
    }

    @RepeatedTest(value = 10,
        name = "Odd Numbers Generator {currentRepetition} out of {totalRepetitions}")
    void repeatedTestWithRepetionInfo() {

        var result = veryBadOddNumberGenerator();

        Predicate<Integer> predicate = number -> ( number.intValue() & 1 ) == 1 ;

        result.forEach(
            entry -> assertTrue( predicate.test( entry ) )
        );

    }


    private Set<Integer> veryBadOddNumberGenerator()
    {
        return IntStream
            .rangeClosed( 1, 10 )
            .filter( n -> n % 2 != 0 ).boxed()
            .collect( Collectors.toSet() );
    }
}
