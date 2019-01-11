package at.fh.swengb.gradwohl.homework_2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_add_note.*
import kotlinx.android.synthetic.main.activity_note_list.*

class AddNoteActivity : AppCompatActivity() {
    private var noteList = mutableListOf<Notes>()
    private var noteAdapter = NoteAdapter()
    private lateinit var myDb:NoteRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        myDb= NoteRoomDatabase.getDatabase(this)
        title="Notes"
    }

    fun addNote(v: View){
        val titel = TitelID.text.toString()
        val content=ContentID.text.toString()
        if(titel.isEmpty()){
            content.isEmpty()
            return
        }
        else {
            val note=Notes(titel,content)
            noteList.add(note)
            val item = noteList.firstOrNull() ?: return
            myDb.noteDAO.insert(item)

            val dbItems = myDb.noteDAO.findAllNotes()
            noteAdapter.updateData(dbItems)

            finish()
        }
    }

}
