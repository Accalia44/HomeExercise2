package at.fh.swengb.gradwohl.homework_2

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import at.fh.swengb.gradwohl.homework_2.Notes
import at.fh.swengb.gradwohl.homework_2.R
import kotlinx.android.synthetic.main.activity_add_note.view.*
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter():RecyclerView.Adapter<NoteViewHolder>(){

    private var dataList = mutableListOf<Notes>()

    fun updateData(list: List<Notes>) {
        dataList = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.note_item,parent,false)
        return NoteViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }

    override fun onBindViewHolder(viewHolder: NoteViewHolder, position: Int) {
        val item=dataList[position]
        viewHolder.bindData(item)
    }
}

class NoteViewHolder(itemview: View):RecyclerView.ViewHolder(itemview){
    fun bindData(Note: Notes){
        itemView.MyTitelID.text = Note.Titel
        itemView.MyNoteID.text=Note.Content
    }

}