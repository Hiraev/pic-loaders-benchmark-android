package ru.touchin.pic_loaders_benchmark.extensions

import okhttp3.ResponseBody
import java.nio.charset.Charset

fun ResponseBody.cloneBody(): String? = source()
        .also { it.request(Long.MAX_VALUE) }
        .buffer
        ?.clone()
        ?.readString(Charset.forName("UTF-8"))
