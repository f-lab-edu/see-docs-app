package kr.co.common.util

interface Mapper<LEFT, RIGHT> {
    fun mapToRight(from: LEFT): RIGHT
}