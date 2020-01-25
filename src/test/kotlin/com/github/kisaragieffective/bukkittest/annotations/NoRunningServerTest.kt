package com.github.kisaragieffective.bukkittest.annotations

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
/**
 * If this annotated to class, **the all test methods** of it don't need running CraftBukkit.
 * If this annotated to method, it doesn't need running CraftBukkit.
 */
annotation class NoRunningServerTest