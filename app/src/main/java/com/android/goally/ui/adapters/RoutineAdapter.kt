package com.android.goally.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.goally.R
import com.android.goally.data.model.api.response.copilot.Routine
import com.bumptech.glide.Glide

class RoutineAdapter(
    private var routineList: List<Routine>,
    private val onItemClick: (Routine) -> Unit
) : RecyclerView.Adapter<RoutineAdapter.RoutineViewHolder>() {

    inner class RoutineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val routineImageView: ImageView = itemView.findViewById(R.id.routineImageView)
        private val routineName: TextView = itemView.findViewById(R.id.tvRoutineName)
        private val tvSchedule: TextView = itemView.findViewById(R.id.tvSchedule)
        private val tvFolderName: TextView = itemView.findViewById(R.id.tvFolderName)

        fun bind(routine: Routine) {
            routine.name?.let {
                routineName.text = it
            } ?: run {
                routineName.text = "No Name"
            }

            routine.scheduleV2?.type?.let {
                tvSchedule.text = it
            } ?: run {
                tvSchedule.text = "No Schedule"
            }

            routine.folder?.let {
                tvFolderName.text = it
            } ?: run {
                tvFolderName.text = "No Folder Name"
            }


            Glide.with(itemView.context)
                .load(routine.imgURL)
                .placeholder(R.drawable.ic_routine_placeholder)
                .into(routineImageView)

            itemView.setOnClickListener {
                onItemClick(routine)
            }
        }
    }

    fun updateList(newList: List<Routine>) {
        routineList = newList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_copilot, parent, false)
        return RoutineViewHolder(view)
    }

    override fun onBindViewHolder(holder: RoutineViewHolder, position: Int) {
        holder.bind(routineList[position])
    }

    override fun getItemCount(): Int = routineList.size
}
