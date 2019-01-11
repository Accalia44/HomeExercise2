package at.fh.swengb.gradwohl.homework_2

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update

@Dao
interface Note_DAO{

    @Insert
    fun insert(FullNote:Notes)

    @Update
    fun update(FullNote:Notes)

    @Query("SELECT*FROM notes")
    fun findAllNotes():List<Notes>
}
