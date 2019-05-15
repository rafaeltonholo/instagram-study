package com.rtonholo.study.instagram.ui.view.userdata

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rtonholo.study.instagram.R
import com.rtonholo.study.instagram.domain.Media
import com.rtonholo.study.instagram.ui.view.userdata.adapter.UserMediaRecyclerViewAdapter

import com.rtonholo.study.instagram.ui.view.userdata.dummy.DummyContent
import com.rtonholo.study.instagram.ui.view.userdata.dummy.DummyContent.DummyItem

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [UserMediaFragment.OnListFragmentInteractionListener] interface.
 */
class UserMediaFragment : Fragment() {

    private var mColumnCount = 1
    private var mMedias = listOf<Media>()

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            mColumnCount = it.getInt(ARG_COLUMN_COUNT)
            mMedias = it.getParcelableArrayList(ARG_MEDIAS)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_user_media_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    mColumnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, mColumnCount)
                }
                adapter = UserMediaRecyclerViewAdapter(
                    mMedias,
                    listener
                )
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        if (context is OnListFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
//        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }

    companion object {

        const val ARG_COLUMN_COUNT = "column-count"
        const val ARG_MEDIAS = "medias"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int, medias: List<Media>) =
            UserMediaFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                    putParcelableArrayList(ARG_MEDIAS, ArrayList(medias))
                }
            }
    }
}
