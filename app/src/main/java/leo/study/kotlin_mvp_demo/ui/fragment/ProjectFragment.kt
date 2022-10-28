package leo.study.kotlin_mvp_demo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import leo.study.kotlin_mvp_demo.R

/**
 * 项目分页
 */
class ProjectFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard,container,false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}