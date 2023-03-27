package leo.study.lib_base.base

import android.app.Application
import android.content.Context
import com.bumptech.glide.Glide.init


/**
 *
 * ***********************************************************************
 *the project desc: 项目 baseAppclication
 *this name is BaseApplication
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年02月22日 15:42:23
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
abstract class BaseApplication : Application() {


    abstract var dataStoreName:String

     abstract var sharedPrfName:String


    companion object {
        lateinit var instance:BaseApplication
        private set
        /**
         * 返回项目的 context
         *
         * @return context
         */
        fun getAppContext(): Context {
            return instance.applicationContext
        }
    }



    override fun onCreate() {
        super.onCreate()

        instance = this;

        init()
    }


    abstract fun init()


}