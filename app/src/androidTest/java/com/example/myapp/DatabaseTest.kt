package com.example.myapp

import androidx.room.Room
import androidx.test.runner.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myapp.data.AffairDao
import com.example.myapp.data.AffairDatabase
import com.example.myapp.model.Affair
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    private lateinit var affairDao: AffairDao
    private lateinit var db: AffairDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, AffairDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        affairDao = db.affairDao()
    }
    //
    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
    //
    @Test
    @Throws(Exception::class)
     fun insertUser() {
        val item = Affair(0, "Make some homework", "In progress")
        affairDao.addAffair(item)
        val user = affairDao.readAllData()
        assertNotNull(user)
    }
}