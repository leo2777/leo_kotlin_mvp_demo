package leo.study.kotlin_mvp_demo.net

import android.util.Log
import leo.study.kotlin_mvp_demo.constants.Constants
import leo.study.lib_base.ext.showLogD
import leo.study.lib_base.http.retrofit.RetrofitFactory
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import java.util.logging.Logger


/**
 *
 * ***********************************************************************
 *the project desc: 主 网络请求类
 *this name is MainRetrofit
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月13日 16:01:28
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
class MainRetrofit : RetrofitFactory<MainServiceApi>() {

    override fun setApiService(): Class<MainServiceApi> {
        return MainServiceApi::class.java
    }

    override fun setBaseUrl(): String {
        return Constants.mainUrl
    }

    override fun setHeader(builder: Request.Builder): Request.Builder {
        builder.addHeader("token","")
        return builder
    }

    override fun setLoggingInterceptor(): HttpLoggingInterceptor {
        val logger:HttpLoggingInterceptor.Logger = HttpLoggingInterceptor.Logger {
            Log.i("333333", "setLoggingInterceptor: $it")
        }
        val interceptor = HttpLoggingInterceptor(logger)
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}