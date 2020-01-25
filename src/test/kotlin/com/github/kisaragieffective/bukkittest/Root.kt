package com.github.kisaragieffective.bukkittest

import org.bukkit.craftbukkit.Main
import java.lang.reflect.InvocationTargetException
import kotlin.reflect.KClass
import kotlin.reflect.jvm.isAccessible

fun main() {
    Main.main(emptyArray())
}

private inline operator fun <reified T : Any> KClass<T>.invoke(parameters: Any?): T {
    val constructor = T::class.constructors.singleOrNull {
        it.parameters.size == 1
    }

    constructor ?: throw InvocationTargetException(InstantiationException("${T::class} doesn't have constructors that take 1 parameter."))

    // not null
    if (!constructor.isAccessible) constructor.isAccessible = true
    return constructor.call(parameters)
}