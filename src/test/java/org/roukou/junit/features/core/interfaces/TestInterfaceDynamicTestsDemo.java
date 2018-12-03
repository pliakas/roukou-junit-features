package org.roukou.junit.features.core.interfaces;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public interface TestInterfaceDynamicTestsDemo
{
    @TestFactory
    default List<DynamicTest> dynamicTestsFromCollection()
    {
        return List.of(
            dynamicTest( "1st dynamic test in test interface",
                () -> assertTrue( true ) ),
            dynamicTest( "2nd dynamic test in test interface",
                () -> assertEquals( 4, 2 * 2 ) ) );
    }

}