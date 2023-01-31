package leo.study.kotlin_mvp_demo.ui.mvp.fragment.home

import io.reactivex.Observable
import leo.study.kotlin_mvp_demo.common.BaseRequest
import leo.study.kotlin_mvp_demo.model.home.BannerModel
import leo.study.lib_base.mvp.IModel
import leo.study.lib_base.mvp.IPresenter
import leo.study.lib_base.mvp.IView


/**
 *
 * ***********************************************************************
 *the project desc: 首页 fragment 契约类
 *this name is HomeContact
 *this from package leo_kotlin_mvp_demo
 *this create by machine leo mark
 *this full time on 2023年01月31日 10:45:12
 *this developer is 冯立仁
 *this developer QQ is 2549732107
 * ***********************************************************************
 */
interface HomeContact {

    interface View : IView<Presenter>{
        /**
         * 请求成功数据返回
         *
         * @param [list] 数据实体
         */
        fun getBannerSuccess(list: List<BannerModel>)
    }

    interface Presenter: IPresenter<View,Model>{
        /**
         * 获取banner数据
         *
         */
        fun getBanner()

    }

    interface Model : IModel{
        /**
         * 获取banner数据
         *
         * @return 数据实体
         */
        fun getBanner():Observable<BaseRequest<List<BannerModel>>>

    }
}