package leo.study.kotlin_mvp_demo.ui.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

import leo.study.kotlin_mvp_demo.R;
import leo.study.kotlin_mvp_demo.databinding.ActivityJavaTestBinding;
import leo.study.kotlin_mvp_demo.utils.ToastyUtils;
import leo.study.lib_base.image.ImageLoaderHelper;
import leo.study.lib_base.mvp.BaseMvpActivity;
import leo.study.lib_base.mvp.ITopPresenter;

public class JavaTestActivity extends BaseMvpActivity<ActivityJavaTestBinding,TestContract.View,TestContract.Presenter> implements TestContract.View {

    private TestPresenter presenter;



    @Override
    public void initView() {

        getBinding().btnTest.setOnClickListener(view -> ToastyUtils.INSTANCE.showInfo("测试点击事件"));

    }

    @Override
    public void initData() {

        presenter = new TestPresenter();
        presenter.getData();
        showLoading(false);

        ImageLoaderHelper.Companion.getInstance().loadImage(getBinding().btnTest,"");
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