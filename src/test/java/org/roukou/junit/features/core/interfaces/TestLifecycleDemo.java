package org.roukou.junit.features.core.interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestLifecycleDemo implements TestInterfaceDynamicTestsDemo, TestInterfaceTests, TimeExecutionLogger
{
    @Test
    void testSample() throws InterruptedException
    {
        Thread.sleep( 1000 );
        assertEquals(1, 1, "is always equal");
    }
}
