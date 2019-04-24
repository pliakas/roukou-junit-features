package org.roukou.junit.features.core;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.IntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.*;

public final class CoreFeatures
{

    static Map<Integer, Set<String>> invertMultimap( Map<String, Set<Integer>> input )
    {
        requireNonNull( input, "Cannot be null." );

        try
        {
            Thread.sleep( 3000 );
        }
        catch( InterruptedException e )
        {
            e.printStackTrace();
        }
        return input.entrySet().stream()
            .flatMap( entry -> entry.getValue().stream()
                .map( value -> new AbstractMap.SimpleEntry<>( entry.getKey(), value ) ))
            .collect( groupingBy( Map.Entry::getValue,
                mapping( Map.Entry::getKey, toSet() ))
            );
    }

    static List<String> denormalizedMap( Map<Integer, List<String>> input )
    {
        requireNonNull( input, "Cannot be null." );

        return input.entrySet().stream()
            .flatMap( entry -> entry.getValue().stream()
                .map( name -> name + ":" + entry.getKey() ) )
            .collect( Collectors.toList() );
    }

    public static List<String> selectUpcaseOddLengthWords( List<String> input )
    {
        requireNonNull( input, "Cannot be null" );
        return input.stream()
                .filter(w -> (w.length() & 1) == 1)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static List<String> selectUpcaseOddLengthWords( List<String> input, long duration )
        throws InterruptedException
    {
        requireNonNull( input, "Cannot be null" );
        Thread.sleep( duration );
        return input.stream()
            .filter(w -> (w.length() & 1) == 1)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }


    public static <T> Collector<T, ?, T[]> toArray( IntFunction<T[]> converter )
    {

        return collectingAndThen( toList(),
            list -> list.toArray( converter.apply( list.size() ) ) );
    }
}
