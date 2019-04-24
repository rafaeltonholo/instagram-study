package com.rtonholo.study.instagram.domain

import java.util.*

data class Comment(val text: String, val owner: User, val likes: Int, val time: Date)