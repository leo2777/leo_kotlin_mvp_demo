package leo.study.lib_base.scheduler


/**
 *
 * ***********************************************************************
 *the project desc: 调度任务类
 *this name is SchedulerUtils
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2022年10月31日 15:57:36
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
object SchedulerUtils {
    fun<T> ioToMain():IoMainScheduler<T>{
        return IoMainScheduler()
    }
}