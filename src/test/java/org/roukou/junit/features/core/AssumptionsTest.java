package org.roukou.junit.features.core;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssumptionsTest
{
    @Test
    @DisplayName( "Invert multimap - Success when size is 4" )
    void testAssumption()
    {
        //arrange
        var input = List.of(
            "alfa", "bravo", "charlie", "delta", "echo", "foxtrot");

        //act
        var result = CoreFeatures.selectUpcaseOddLengthWords( input );

        //arrange
        Assumptions.assumeTrue( result.size() == 4, "Size of the result is other than 5"  );

        assertEquals(List.of("BRAVO", "CHARLIE", "DELTA", "FOXTROT"), result);
    }


    @Test
    @DisplayName( "Failure  multimap - Success when size is 4" )
    void testAssumptionFailure()
    {
        //arrange
        var input = List.of(
            "alfa", "bravo", "charlie", "delta", "echo" );

        //act
        var result = CoreFeatures.selectUpcaseOddLengthWords( input );

        //assumption
        Assumptions.assumeTrue( result.size() == 4, "Size of the result is other than 4"  );

        //assert
        assertEquals(List.of("BRAVO", "CHARLIE", "DELTA", "FOXTROT"), result);
    }
}
