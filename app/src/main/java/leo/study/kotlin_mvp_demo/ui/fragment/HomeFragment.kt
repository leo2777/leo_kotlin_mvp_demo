package leo.study.kotlin_mvp_demo.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*
import leo.study.kotlin_mvp_demo.R
import leo.study.kotlin_mvp_demo.ui.test.JavaTestActivity
import leo.study.kotlin_mvp_demo.ui.test.KotlinTestActivity

/**
 * 首页
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_home_fragment_jump_test.setOnClickListener {
            val intent = Intent(context, JavaTestActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}