package org.example.processor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// АННОТАЦИЯ, КОТОРАЯ СТАВИТСЯ НАД МЕТОДАМИ И КЛАССАМИ ДЛЯ ЗАМЕРА СКОКРОСТИ РАБОТЫ
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Benchmark {
}
