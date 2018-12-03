package org.roukou.junit.features.core.interfaces;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

@Tag( "jhug" )
@ExtendWith( TimeExtension.class )
interface TimeExecutionLogger {}
