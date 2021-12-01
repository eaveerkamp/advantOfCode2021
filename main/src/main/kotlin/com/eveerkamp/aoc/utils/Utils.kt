package com.eveerkamp.aoc.utils

fun readFile(filename: String) = Dummy::class.java.classLoader.getResource(filename).readText()

class Dummy