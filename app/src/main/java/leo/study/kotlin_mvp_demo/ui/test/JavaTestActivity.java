package leo.study.kotlin_mvp_demo.ui.test;

import static leo.study.lib_base.ext.CommonExtKt.showInfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener;

import org.jetbrains.annotations.Nullable;

import leo.study.kotlin_mvp_demo.R;
import leo.study.kotlin_mvp_demo.databinding.ActivityJavaTestBinding;
import leo.study.lib_base.image.ImageLoaderHelper;
import leo.study.lib_base.mvp.BaseMvpActivity;
import leo.study.lib_base.mvp.ITopPresenter;

public class JavaTestActivity extends BaseMvpActivity<ActivityJavaTestBinding,TestContract.View,TestContract.Presenter> implements TestContract.View {

    private TestPresenter presenter;



    @Override
    public void initView() {

        getBinding().btnTest.setOnClickListener(view -> showInfo(this,"测试点击事件"));

    }

    @Override
    public void initData() {

        presenter = new TestPresenter();
        presenter.getData();
        showLoading(false);

        ImageLoaderHelper.Companion.getInstance().loadImage(getBinding().btnTest,"");

        SmartRefreshLayout smartRefreshLayout = new SmartRefreshLayout(this);
        smartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {

            }
        });
    }

    @NonNull
    @Override
    public TestContract.Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(@NonNull TestContract.Presenter presenter) {
    }

    @Override
    public void getDataSuccess(@Nullable String msg) {
        getBinding().tvTest.setText(msg);
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @NonNull
    @Override
    public ActivityJavaTestBinding getViewBinding() {
        return ActivityJavaTestBinding.inflate(getLayoutInflater());
    }
}