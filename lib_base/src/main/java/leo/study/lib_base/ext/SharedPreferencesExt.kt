package leo.study.lib_base.ext

import android.content.Context
import android.content.SharedPreferences
import leo.study.lib_base.base.BaseApplication


/**
 *
 * ***********************************************************************
 *the project desc: SharePreference 扩展类
 *this name is SharedPreferencesExt
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月22日 11:46:48
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */


/**
 * 获取 SP
 */
val Context.sharePfs: SharedPreferences
    get() = this.getSharedPreferences(BaseApplication.instance.sharedPrfName,Context.MODE_PRIVATE)


/**
 * 写入数据进SP
 *
 * @param T 写入类型
 * @param key key
 * @param value 值
 */
fun<T:Any> Context.sharePrefPut(key:String,value:T){
    with(sharePfs.edit()) {
        when(value){
            is Int -> putInt(key,value)
            is Long -> putLong(key,value)
            is Float -> putFloat(key,value)
            is Boolean -> putBoolean(key,value)
            is String -> putString(key,value)
            else -> throw IllegalArgumentException("输入值该类型不支持保存，请检查！！")
        }
        apply()
    }
}


/**
 * 获取值
 *
 * @param T 类型
 * @param key key
 * @return 返回对应T的数值
 */
inline fun<reified T:Any> Context.sharePrefGet(key:String):T {
    return when(T::class){
        Int::class -> sharePfs.getInt(key,0) as T
        Long::class -> sharePfs.getLong(key,0) as T
        Float::class -> sharePfs.getFloat(key,0.0f) as T
        Boolean::class -> sharePfs.getBoolean(key,false) as T
        String::class -> sharePfs.getString(key,"") as T
        else -> throw IllegalArgumentException("输入值该类型不支持保存，请检查！！")
    }
}



/**
 * 移除某个值
 *
 * @param key key
 */
fun Context.remove(key:String){
    with(sharePfs.edit()){
        remove(key)
        apply()
    }
}


/**
 * 清空
 *
 */
fun Context.clear(){
    with(sharePfs.edit()){
        clear()
        apply()
    }
}