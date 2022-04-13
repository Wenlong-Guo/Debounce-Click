package io.github.guowenlong.debounce

import android.view.View

/**
 * Description: View的点击防抖扩展类
 * Author:      郭文龙
 * Date:        2022/4/12 18:08
 * Gmail:       guowenlong20000@sina.com
 */

/**
 * 防抖时间间隔的Tag
 */
const val TIME_TAG_KEY_TRIGGER_LAST = 1111111111

/**
 * 最后一次点击生效的时间戳的Tag
 */
const val TIME_TAG_KEY_TRIGGER_DELAY = 1111111112

var TRIGGER_INTERVAL_DEFAULT = 500L


/**
 * 带过滤的点击事件 默认500毫秒
 */
fun View.setDebounceClickListener(interval: Long = 500, block: (View) -> Unit) {
    triggerInterval = interval
    setOnClickListener {
        if (clickEnable()) {
            block(it)
        }
    }
}

/**
 * 设置默认防抖时间间隔
 */
fun setTriggerDefaultInterval(timeMillis: Long) {
    TRIGGER_INTERVAL_DEFAULT = timeMillis
}

/**
 * 自定义属性保存防抖时间间隔
 */
private var View.triggerInterval: Long
    get() = (getTag(TIME_TAG_KEY_TRIGGER_DELAY) as? Long) ?: TRIGGER_INTERVAL_DEFAULT
    set(value) {
        setTag(TIME_TAG_KEY_TRIGGER_DELAY, value)
    }

/**
 * 自定义属性保存最后一次点击生效的时间戳
 */
private var View.triggerLastTime: Long
    get() = (getTag(TIME_TAG_KEY_TRIGGER_LAST) as? Long) ?: 0
    set(value) {
        setTag(TIME_TAG_KEY_TRIGGER_LAST, value)
    }

/**
 * 是否可以点击
 */
private fun View.clickEnable(): Boolean {
    val isEnable = System.currentTimeMillis() - triggerLastTime >= triggerInterval
    if (isEnable) triggerLastTime = System.currentTimeMillis()
    return isEnable
}