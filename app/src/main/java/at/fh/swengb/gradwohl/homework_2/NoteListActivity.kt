package at.fh.swengb.gradwohl.homework_2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity() {
    private var noteList = mutableListOf<Notes>()
    private var noteAdapter = NoteAdapter()
    private lateinit var myDb:NoteRoomDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        val sharedPreference = getSharedPreferences("userdata", Context.MODE_PRIVATE)
        val safedName =sharedPreference.getString("Name","Leer")
        val safedAge = sharedPreference.getInt("Age",0)
        user_info.text= "Notes for $safedName, $safedAge"

        myDb= NoteRoomDatabase.getDatabase(applicationContext)
        recyclerView.layoutManager=LinearLayoutManager(this)
        noteAdapter=NoteAdapter()
        recyclerView.adapter = noteAdapter
        title="Notes"
    }

    override fun onResume() {
        super.onResume()
        val dbItems = myDb.noteDAO.findAllNotes()
        noteAdapter.updateData(dbItems)

        updateList()

    }

    fun addNote(view: View){
        val intent = Intent(this, AddNoteActivity::class.java)
        startActivity(intent)
    }

    fun updateList(){
        val item = noteList.firstOrNull() ?: return
        myDb.noteDAO.insert(item)
        val dbItems = myDb.noteDAO.findAllNotes()
        noteAdapter.updateData(dbItems)
        //noteList.add(Notes("First Note","Give it a try with add Note"))
    }

    fun deleteNote(v:View){
        myDb.clearAllTables()
        val dbItems = myDb.noteDAO.findAllNotes()
        noteAdapter.updateData(dbItems)

    }

}
