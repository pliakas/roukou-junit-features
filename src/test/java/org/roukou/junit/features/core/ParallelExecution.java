package org.roukou.junit.features.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;


/**
 *  JUnit Jupiter tests are run sequentially in a single thread. Running tests in parallel, e.g. to speed up execution,
 *  is available as an opt-in feature since version 5.3. To enable parallel execution, simply set
 *  the junit.jupiter.execution.parallel.enabled configuration parameter to true, e.g. in junit-platform.properties
 */

@Execution( ExecutionMode.CONCURRENT )
public class ParallelExecution
{
    @Test
    @DisplayName( "Test_1" )
    void test_one( TestInfo info ) throws InterruptedException
    {
        Thread.sleep(1_000);

        System.out.println( info.getDisplayName() + " running - " + Thread.currentThread().getName());
    }

    @Test
    @DisplayName( "Test_2" )
    void test_two( TestInfo info ) throws InterruptedException
    {
        Thread.sleep(1_000);
        System.out.println( info.getDisplayName() + " running - " + Thread.currentThread().getName());
    }

    @Test
    @DisplayName( "Test_3" )
    void test_third( TestInfo info ) throws InterruptedException
    {
        Thread.sleep(1_000);
        System.out.println( info.getDisplayName() + " running - " + Thread.currentThread().getName());
    }

    @Test
    @DisplayName( "Test_4" )
    void test_fourth( TestInfo info ) throws InterruptedException
    {
        Thread.sleep(1_000);
        System.out.println( info.getDisplayName() + " running - " + Thread.currentThread().getName());
    }

}
