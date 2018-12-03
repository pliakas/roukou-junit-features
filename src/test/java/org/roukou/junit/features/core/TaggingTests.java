package org.roukou.junit.features.core;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * Test classes and methods can be tagged via the @Tag annotation.
 * Those tags can later be used to filter test discovery and execution.
 */
@Tag( "jhug" )
class TaggingTests
{
    @Test
    @Tag( "integration" )
    void test_1()
    {
        System.out.println( "This is an integration test" );
    }

    @Test
    @Tag( "jhug" )
    void test_2()
    {
        System.out.println( "This is a component test");
    }
}
