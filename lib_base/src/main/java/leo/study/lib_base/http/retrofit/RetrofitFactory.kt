package leo.study.lib_base.http.retrofit

import android.util.Log.e
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.math.log


/**
 *
 * ***********************************************************************
 *the project desc: Retrofit 工厂类
 *this name is RetrofitFactory
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2022年10月31日 13:45:21
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
abstract class RetrofitFactory<T>() {
    //超时时间
    private val timeOut : Long = 20
    private var apiService : T


    /**
     * 初始化
     */
    init {

        val dispatcher = Dispatcher(Executors.newFixedThreadPool(20))
        dispatcher.maxRequests = 20
        dispatcher.maxRequestsPerHost = 1
        val logInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> })
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY


        val httpClient = OkHttpClient.Builder()
            .dispatcher(dispatcher)
            .addInterceptor(logInterceptor)
            .addInterceptor { chain ->
                var builder = chain.request().newBuilder()
                builder.addHeader("Cache-Control", "max-age=0")
                builder.addHeader("Upgrade-Insecure-Requests", "1")
                builder=this.setHeader(builder)
                chain.proceed(builder.build())
            }
            .connectTimeout(timeOut,TimeUnit.SECONDS)
            .readTimeout(timeOut,TimeUnit.SECONDS)
            .build()

        apiService = Retrofit.Builder()
            .baseUrl(this.setBaseUrl())
            .addConverterFactory(GsonConverterFactory.create(buildGson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
            .create(this.setApiService())
    }


    /**
     * 设置接口文件
     */
    abstract fun setApiService():Class<T>

    /**
     * 设置地址
     */
    abstract fun setBaseUrl():String

    /**
     * 设置头部
     */
    abstract fun setHeader(builder:Request.Builder):Request.Builder

    /**
     * 获取retrofit
     */
    fun getService():T{
        return apiService
    }

    /**
     * 构建gson
     */
    private fun buildGson(): Gson {
        return GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create()
    }
}