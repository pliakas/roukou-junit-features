package org.roukou.junit.features.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;
import static org.roukou.junit.features.core.CoreFeatures.invertMultimap;

class AssertionsTest
{

    private Map<String, Set<Integer>> mapInput = Map.of(
        "a", Set.of( 1, 2 ),
        "b", Set.of( 2, 3 ),
        "c", Set.of( 1, 3 ),
        "d", Set.of( 1, 4 ),
        "e", Set.of( 2, 4 ),
        "f", Set.of( 3, 4 ) );

    @Test
    @DisplayName( "Standard Test - Denormilized Map - Success" )
    void standardAssertions()
    {
        //arrange
        var input = Map.of(
            "a", Set.of( 1, 2 ),
            "b", Set.of( 2, 3 ),
            "c", Set.of( 1, 3 ),
            "d", Set.of( 1, 4 ),
            "e", Set.of( 2, 4 ),
            "f", Set.of( 3, 4 ) );


        //execute
        var result = invertMultimap( input );

        //assert
        assertEquals( 4, result.size() );
        assertEquals( new HashSet<>( Arrays.asList( "a", "c", "d" ) ), result.get( 1 ), "Failure" );
        assertEquals( new HashSet<>( Arrays.asList( "a", "b", "e" ) ), result.get( 2 ) );
        assertEquals( new HashSet<>( Arrays.asList( "b", "c", "f" ) ), result.get( 3 ) );
        assertEquals( new HashSet<>( Arrays.asList( "d", "e", "f" ) ), result.get( 4 ) );
    }

    @Test
    @DisplayName( "Grouped Assertions" )
    void groupedAssertions()
    {

        //execute
        var result = invertMultimap( mapInput );

        //assert
        assertAll( "Invert Map",
            () -> assertEquals( new HashSet<>( Arrays.asList( "a", "c", "d" ) ), result.get( 1 ) ),
            () -> assertEquals( new HashSet<>( Arrays.asList( "a", "b", "e" ) ), result.get( 2 ) ),
            () -> assertEquals( new HashSet<>( Arrays.asList( "b", "c", "f" ) ), result.get( 3 ) ),
            () -> assertEquals( new HashSet<>( Arrays.asList( "d", "e", "f" ) ), result.get( 4 ) )
        );
    }

    @Test
    @DisplayName( "Invert Map - Failure (Exception Thrown) ")
    void exceptionTest() {

        //execute
        final NullPointerException expectedException = assertThrows(
            NullPointerException.class,
            () -> invertMultimap( null )
        );

        assertEquals( "Cannot be null.", expectedException.getMessage() );
    }

    @Test
    void timeoutNotExceeded() {
       var result =  assertTimeout(ofMinutes(2), () -> invertMultimap( mapInput ) );

        assertAll( "Invert Map",
            () -> assertEquals( new HashSet<>( Arrays.asList( "a", "c", "d" ) ), result.get( 1 ) ),
            () -> assertEquals( new HashSet<>( Arrays.asList( "a", "b", "e" ) ), result.get( 2 ) ),
            () -> assertEquals( new HashSet<>( Arrays.asList( "b", "c", "f" ) ), result.get( 3 ) ),
            () -> assertEquals( new HashSet<>( Arrays.asList( "d", "e", "f" ) ), result.get( 4 ) )
        );
    }

    @Test
    void timeoutExceeded() {
        assertTimeout(ofMillis(1000), () -> {
            Thread.sleep(100);
        });
    }
}
