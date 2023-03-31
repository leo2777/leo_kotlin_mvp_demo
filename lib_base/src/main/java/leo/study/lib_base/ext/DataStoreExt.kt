package leo.study.lib_base.ext

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import leo.study.lib_base.base.BaseApplication


/**
 *
 * ***********************************************************************
 *the project desc: DataStore操作类
 *this name is DataStoreExt
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月16日 16:37:29
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */

//获取dataStore 实体
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = BaseApplication.instance.dataStoreName)

/**
 * 保存数据
 *
 * @param [T] 保存数据的类型
 * @param [key] 指标key
 * @param [value] 保存的数
 */
suspend fun <T : Any> Context.dataStorePut(key: String, value: T) {
    withContext(Dispatchers.IO) {
        dataStore.edit { setting ->
            when (value) {
                is Int -> setting[intPreferencesKey(key)] = value
                is Long -> setting[longPreferencesKey(key)] = value
                is Float -> setting[floatPreferencesKey(key)] = value
                is Double -> setting[doublePreferencesKey(key)] = value
                is Boolean -> setting[booleanPreferencesKey(key)] = value
                is String -> setting[stringPreferencesKey(key)] = value
                else -> throw IllegalArgumentException("输入值该类型不支持保存，请检查！！")
            }
        }
    }
}

/**
 * 获取保存的本地数据
 * 使用   get<type>("key")
 *
 * @param [T] 类型
 * @param [key] 指标key
 * @return 对应的类型数据
 */
suspend inline fun <reified T : Any> Context.dataStoreGet(key: String): T =
    withContext(Dispatchers.IO) {
        return@withContext dataStore.data.map { setting ->
            when (T::class) {
                Int::class -> setting[intPreferencesKey(key)] ?: 0
                Long::class -> setting[longPreferencesKey(key)] ?: 0L
                Float::class -> setting[floatPreferencesKey(key)] ?: 0f
                Double::class -> setting[doublePreferencesKey(key)] ?: 0.0
                Boolean::class -> setting[booleanPreferencesKey(key)] ?: false
                String::class -> setting[stringPreferencesKey(key)] ?: ""
                else -> throw IllegalArgumentException("输入的类型不支持获取，请检查！！")
            }
        }.first() as T
    }