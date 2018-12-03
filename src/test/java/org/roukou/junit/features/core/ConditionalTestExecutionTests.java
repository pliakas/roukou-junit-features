package org.roukou.junit.features.core;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * The ExecutionCondition extension API in JUnit Jupiter allows developers to either enable or disable a
 * container or test based on certain conditions programmatically. The simplest example of such a condition
 * is the built-in DisabledCondition which supports the @Disabled annotation (see Disabling Tests).
 *
 * In addition to @Disabled, JUnit Jupiter also supports several other annotation-based conditions
 * in the org.junit.jupiter.api.condition package that allow developers to enable
 * or disable containers and tests declaratively
 */
class ConditionalTestExecutionTests
{
    @Test
    @Disabled( "This is a real bad test ..")
    void disableBadTest()
    {
        assertTrue( true );
    }

    @Test
    @DisabledOnOs( OS.LINUX )
    void disableOnLinux()
    {
        fail( "I am bourgeois test and I am running only on Mac and Windows." );
    }

    @Test
    @EnabledOnJre( JRE.JAVA_11 )
    void runOnlyOnJava11()
    {
        System.out.println( "I am a hipster, I am running only on Java 11 or higher" );
        assertTrue( true);
    }

    @Test
    @EnabledOnJre( JRE.JAVA_8 )
    void runOnlyOnJava8()
    {
        System.out.println( "I am a too old. I can be executing only in Java 8" );
        assertTrue( true);
    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    void runOnlyInModernArchs()
    {
        assertTrue( true);
    }

}
