package org.roukou.junit.features.core;

import org.junit.jupiter.api.*;

/**
 * Nested tests give the test writer more capabilities to express the relationship among several group of tests.
 */
@DisplayName( "Nested Tests - Testing a collector" )
public class NestedTests
{
    @BeforeEach
    void setup1()
    {
        System.out.println( "Before each all" );
    }

    @Test
    void topTest()
    {
        System.out.println( "Top Test" );
    }

    @Nested
    class InnerClass1
    {
        @BeforeEach
        void setup2()
        {
            System.out.println( "Inner Setup 2" );
        }

        @Test
        void innerTest1()
        {
            System.out.println( "Inner Test 2" );
        }

        @Nested
        class InnerClass2
        {
            @Test
            void innerTest2()
            {
                System.out.println( "Inner Test 3" );
            }
        }
    }
}
