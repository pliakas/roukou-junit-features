package org.roukou.junit.features.core;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * As one of the major changes in JUnit Jupiter, both test constructors and methods are now permitted to have parameters.
 * This allows for greater flexibility and enables Dependency Injection for constructors and methods.
 * <p>
 * ParameterResolver defines the API for test extensions that wish to dynamically resolve parameters at runtime.
 * If a test constructor or a @Test, @TestFactory, @BeforeEach, @AfterEach, @BeforeAll, or @AfterAll method accepts
 * a parameter, the parameter must be resolved at runtime by a registered ParameterResolver.
 */
@DisplayName( "Dependency Injection and Constructors demo" )
public class DependencyInjectionTests
{
    public DependencyInjectionTests( TestInfo info )
    {
        assertEquals( "Dependency Injection and Constructors demo", info.getDisplayName() );
    }


    @Test
    @DisplayName( "TEST 1" )
    @Tag( "my-tag" )
    void test1( TestInfo testInfo )
    {
        assertEquals( "TEST 1", testInfo.getDisplayName() );
        assertTrue( testInfo.getTags().contains( "my-tag" ) );
    }
}
