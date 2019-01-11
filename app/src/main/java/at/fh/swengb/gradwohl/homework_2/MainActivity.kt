package at.fh.swengb.gradwohl.homework_2

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="Notes"
    }
    fun start(view: View) {

        val nametext = NameID.text.toString()
        val agetext=AgeID.text.toString()
        if(nametext.isEmpty()){
            agetext.isEmpty()
            return
        }
        else {
            val sharedPreference = getSharedPreferences("userdata", Context.MODE_PRIVATE)
            sharedPreference.edit().putString("Name", NameID.text.toString()).apply()
            sharedPreference.edit().putInt("Age", AgeID.text.toString().toInt()).apply()

            val intent = Intent(this, NoteListActivity::class.java)
            startActivity(intent)
        }
    }
}
