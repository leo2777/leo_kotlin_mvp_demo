package leo.study.kotlin_mvp_demo.ui.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.databinding.ActivityGlideTestBinding
import leo.study.lib_base.image.ImageLoaderHelper

class GlideTestActivity : AppCompatActivity(),OnClickListener {

    private lateinit var binding : ActivityGlideTestBinding

    private val webPath = "https://img.mp.itc.cn/upload/20161216/42bff90fa96141618885594b4fe176ff_th.jpg"
    private val webGif = "https://img.zcool.cn/community/01639c586c91bba801219c77f6efc8.gif"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGlideTestBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initView()
    }


    private fun initView(){
        binding.btnGlideTestWeb.setOnClickListener(this)
        binding.btnGlideTestDrawable.setOnClickListener(this)
        binding.btnGlideTestCircle.setOnClickListener(this)
        binding.btnGlideTestRound.setOnClickListener(this)

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_glide_test_web -> {
                ImageLoaderHelper.instance.loadGif(binding.imgGlideTest,webGif)
            }
            R.id.btn_glide_test_drawable -> {
                ImageLoaderHelper.instance.loadImage(binding.imgGlideTest,R.drawable.icon_home_bottom_user_default)

            }
            R.id.btn_glide_test_circle -> {
                ImageLoaderHelper.instance.loadCircleImage(binding.imgGlideTest,webPath)
            }
            R.id.btn_glide_test_round -> {
                ImageLoaderHelper.instance.loadRoundImage(binding.imgGlideTest,webPath,50)
            }

        }
    }

}