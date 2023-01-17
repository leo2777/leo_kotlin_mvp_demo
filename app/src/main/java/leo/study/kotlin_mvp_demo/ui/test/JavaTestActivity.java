package leo.study.kotlin_mvp_demo.ui.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

import leo.study.kotlin_mvp_demo.R;
import leo.study.kotlin_mvp_demo.databinding.ActivityJavaTestBinding;
import leo.study.lib_base.mvp.BaseMvpActivity;
import leo.study.lib_base.mvp.ITopPresenter;

public class JavaTestActivity extends BaseMvpActivity<TestContract.View,TestContract.Presenter> implements TestContract.View {

    private TestPresenter presenter;

    private ActivityJavaTestBinding javaTestBinding;


    @NonNull
    @Override
    public View getContentView() {
        javaTestBinding = ActivityJavaTestBinding.inflate(getLayoutInflater());
        return javaTestBinding.getRoot();
    }

    @Override
    public void initView() {

        javaTestBinding.btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }

    @Override
    public void initData() {

        presenter = new TestPresenter();
        presenter.getData();
        showLoading(false);
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
        javaTestBinding.tvTest.setText(msg);
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}