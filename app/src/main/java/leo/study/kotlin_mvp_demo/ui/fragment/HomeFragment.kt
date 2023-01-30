package leo.study.kotlin_mvp_demo.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.orhanobut.logger.Logger
import leo.study.kotlin_mvp_demo.databinding.FragmentHomeBinding
import leo.study.kotlin_mvp_demo.ui.test.GlideTestActivity
import leo.study.kotlin_mvp_demo.ui.test.JavaTestActivity
import leo.study.kotlin_mvp_demo.ui.test.KotlinTestActivity

/**
 * 首页
 */
class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding ?= null
    private val binding: FragmentHomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Logger.t("333333").d(this.toString())

        binding.btnHomeFragmentJumpTest.setOnClickListener {
            val intent = Intent(context, GlideTestActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}