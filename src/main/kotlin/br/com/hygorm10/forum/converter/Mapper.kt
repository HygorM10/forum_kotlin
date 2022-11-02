package br.com.hygorm10.forum.converter

interface Mapper<T, U> {

    fun map(t: T): U

}
