package at.fh.swengb.gradwohl.homework_2

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "notes")
class Notes (val Titel:String,
            val Content:String){

    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}