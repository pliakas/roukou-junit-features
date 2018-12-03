package org.roukou.junit.features.core.interfaces;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TimeExtension
    implements BeforeTestExecutionCallback, AfterTestExecutionCallback
{

    @Override
    public void beforeTestExecution( ExtensionContext context )
    {
        long start = System.currentTimeMillis();

        getStore( context ).put( "START", start );
    }

    @Override
    public void afterTestExecution( ExtensionContext context ) throws Exception
    {
        long start = getStore( context ).get( "START", long.class );
        long duration = System.currentTimeMillis() - start;
        context.publishReportEntry( "exucution time", "" + duration );
    }

    private ExtensionContext.Store getStore( ExtensionContext context )
    {
        return context.getStore( ExtensionContext.Namespace.create( context.getRequiredTestMethod() ) );
    }

}
