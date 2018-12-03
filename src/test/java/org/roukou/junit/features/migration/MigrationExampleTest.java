package org.roukou.junit.features.migration;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import static org.roukou.junit.features.core.CoreFeatures.selectUpcaseOddLengthWords;

public class MigrationExampleTest
{
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Rule
    public Timeout globalTimeout = Timeout.millis( 2000 );

    @Test
    public void test1_success()
    {
        //arrange
        var input = List.of( "alfa", "bravo", "charlie", "delta", "echo", "foxtrot" );

        var result = selectUpcaseOddLengthWords( input );

        assertEquals( List.of( "BRAVO", "CHARLIE", "DELTA", "FOXTROT" ), result );
    }

    @Test
    public void test2_failure()
    {
        exception.expect( NullPointerException.class );
        exception.expectMessage( "Cannot be null" );

        selectUpcaseOddLengthWords( null );

    }

    @Test
    public void test3_timeout() throws InterruptedException
    {
        var input = List.of( "alfa", "bravo", "charlie", "delta", "echo", "foxtrot" );

        selectUpcaseOddLengthWords( input, 1000 );
    }
}
