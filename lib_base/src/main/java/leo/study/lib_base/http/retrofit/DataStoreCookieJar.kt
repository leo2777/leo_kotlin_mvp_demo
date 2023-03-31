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


    private val cookiePrefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveFromResponse(url: HttpUrl, cookies: MutableList<Cookie>) {
        val prefsEditor = cookiePrefs.edit()
        val cookieNames = HashSet<String>()

        for (cookie in cookies) {
            prefsEditor.putString(cookie.name(), cookie.toString())
            cookieNames.add(cookie.name())
        }

        prefsEditor.putStringSet(PREFS_COOKIE_NAMES, cookieNames)
        prefsEditor.apply()
    }

    override fun loadForRequest(url: HttpUrl): ArrayList<Cookie> {
        val cookieNames = cookiePrefs.getStringSet(PREFS_COOKIE_NAMES, HashSet())

        val cookies = ArrayList<Cookie>()
        cookieNames?:return cookies
        for (name in cookieNames) {
            val encodedCookie = cookiePrefs.getString(name, null) ?: continue
            val cookie = Cookie.parse(url, encodedCookie) ?: continue
            cookies.add(cookie)
        }

        return cookies
    }

    companion object {
        private const val PREFS_NAME = "CookiePrefs"
        private const val PREFS_COOKIE_NAMES = "CookieNames"
    }
}