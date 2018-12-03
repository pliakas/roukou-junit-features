package org.roukou.junit.features.core;

import org.junit.jupiter.api.*;

/**
 * In order to allow individual test methods to be executed in isolation and to avoid unexpected side effects due
 * to mutable test instance state, JUnit creates a new instance of each test class before executing
 * each test method (see Test Classes and Methods).
 */
@TestInstance( TestInstance.Lifecycle.PER_METHOD )
class TestLifecycleTest
{
    @BeforeAll
    static void setupAll()
    {
        System.out.println( "Setup for ALL tests");
    }


    @BeforeEach
    void setUp()
    {
        System.out.println( "Setup for EACH test");
    }

    @Test
    void test1()
    {
        System.out.println( "Executing First test" );
    }

    @Test
    void test2()
    {
        System.out.println( "Executing second test ");
    }

    @AfterEach
    void tearDown()
    {
        System.out.println( "Teardown for EACH test");
    }

    @AfterAll
    static void tearDownAll()
    {
        System.out.println( "Teardown for ALL tests" );
    }
}
