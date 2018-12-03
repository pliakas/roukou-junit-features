package org.roukou.junit.features.core.interfaces;

import org.junit.jupiter.api.*;

import java.util.logging.Logger;

/**
 * JUnit Jupiter allows @Test, @RepeatedTest, @ParameterizedTest, @TestFactory, @TestTemplate, @BeforeEach,
 * and @AfterEach to be declared on interface default methods. @BeforeAll and @AfterAll can either be
 * declared on static methods in a test interface or on interface default methods if the test interface
 * or test class is annotated with @TestInstance(Lifecycle.PER_CLASS)
 */

@TestInstance( TestInstance.Lifecycle.PER_CLASS )
public interface TestInterfaceTests
{
    static final Logger logger = Logger.getLogger(TestInterfaceTests.class.getName());

    @BeforeAll
    default void beforeAllTests()
    {
        logger.info( "Before all tests" );
    }

    @AfterAll
    default void afterAllTests()
    {
        logger.info( "After all tests" );
    }

    @BeforeEach
    default void beforeEachTest( TestInfo testInfo )
    {
        logger.info( () -> String.format( "About to execute [%s]", testInfo.getDisplayName() ) );
    }

    @AfterEach
    default void afterEachTest( TestInfo testInfo )
    {
        logger.info( () -> String.format( "Finished executing [%s]", testInfo.getDisplayName() ) );
    }

}
