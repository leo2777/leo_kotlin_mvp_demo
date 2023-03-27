package leo.study.lib_base.http.retrofit

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import leo.study.lib_base.ext.dataStoreGet
import leo.study.lib_base.ext.dataStorePut
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl


/**
 *
 * ***********************************************************************
 *the project desc: 持久化cookie
 *this name is DataStoreCookieJar
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年03月24日 15:49:03
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class DataStoreCookieJar(private val context:Context):CookieJar {

    companion object {
        private const val PREFS_COOKIE_NAMES = "CookieNames"
    }

    override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
        val cookieNames = HashSet<String>()

        MainScope().launch{
            for (cookie in cookies){
                context.dataStorePut(cookie.name(),cookie.toString())
                cookieNames.add(cookie.name())
            }
            context.dataStorePut(PREFS_COOKIE_NAMES,cookieNames.toString())
        }
    }

    override fun loadForRequest(url: HttpUrl): MutableList<Cookie> {
        val cookies = ArrayList<Cookie>()
        MainScope().launch {
            val cookieNames:HashSet<Char> = context.dataStoreGet<String>(PREFS_COOKIE_NAMES).toHashSet()
            for (name in cookieNames){
                val encodedCookie = context.dataStoreGet<String>(name.toString())
                val cookie = Cookie.parse(url,encodedCookie) ?: continue
                cookies.add(cookie)
            }
        }
        return cookies
    }
}