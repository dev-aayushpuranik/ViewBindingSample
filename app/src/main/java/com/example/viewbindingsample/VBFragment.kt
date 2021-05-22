package com.example.viewbindingsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewbindingsample.databinding.FragmentVBBinding

class VBFragment : Fragment() {

    private var _viewBinding: FragmentVBBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentVBBinding.inflate(inflater, container, false)

        // the id of simple text view was android:id = "@+id/simple_text_view"
        // but while assigning text it is refered as simpleTextView
        // (removing underscore with camel case)
        viewBinding.simpleTextView.text = "This is a simple Text View"

        // this dataTV is a text view. It is added in a separate layout
        // and we can assign id for include layout like the one we used in layout file
        // <include android:id="@+id/includes"
        //        layout="@layout/header_layout" />
        // and use it as below same we can do with merge layout.
        viewBinding.includes.dataTV.text = getString(R.string.message)

        viewBinding.recyclerView.layoutManager = LinearLayoutManager(context)
        viewBinding.recyclerView.adapter = RVAdapter(fetchList())

        return viewBinding.root
    }

    private fun fetchList(): ArrayList<UserModel> {
        val list = arrayListOf<UserModel>()
        list.add(UserModel("User 1", "Manager"))
        list.add(UserModel("User 2", "Delivery manager"))
        list.add(UserModel("User 3", "Software developer"))
        list.add(UserModel("User 4", "Software Tester"))
        list.add(UserModel("User 5", "Support executive"))

        return list
    }

    override fun onDestroyView() {
        _viewBinding = null
        super.onDestroyView()
    }
}