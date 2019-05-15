package com.rtonholo.study.instagram.ui.view.userdata.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.rtonholo.study.instagram.R
import com.rtonholo.study.instagram.domain.Media
import com.rtonholo.study.instagram.ui.view.userdata.UserMediaFragment.OnListFragmentInteractionListener
import com.rtonholo.study.instagram.ui.view.userdata.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class UserMediaRecyclerViewAdapter(
    private val mValues: List<Media>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<UserMediaRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    private lateinit var mContext: Context

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Media
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
//            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext)
            .inflate(R.layout.fragment_user_media, parent, false)
        return ViewHolder(view as ImageView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        Glide.with(mContext)
            .load(item.url)
            .thumbnail(0.5f)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .crossFade()
            .into(holder.view)

        with(holder.view) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val view: ImageView) : RecyclerView.ViewHolder(view)
}
