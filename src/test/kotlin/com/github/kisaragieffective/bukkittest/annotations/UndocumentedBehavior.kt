package com.github.kisaragieffective.bukkittest.annotations

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
/**
 * Tests are based on the most generally case and are not based on strict specified behavior on the document.
 * If this annotated on
 * * the method, the method is.
 * * the class, the all test methods are.
 */
annotation class UndocumentedBehavior