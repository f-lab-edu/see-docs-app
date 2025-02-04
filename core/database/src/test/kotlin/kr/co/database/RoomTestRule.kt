package kr.co.database

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

internal class RoomTestRule : TestRule {

    val db: SeeDocsDatabase by lazy { initialiseRoomDb() }

    override fun apply(base: Statement?, description: Description?): Statement {
        return RoomStatement(statement = base)
    }

    inner class RoomStatement(private val statement: Statement?) : Statement() {

        override fun evaluate() {
            try {
                statement?.evaluate()
            } finally {
                db.close()
            }
        }

    }

    private fun initialiseRoomDb(): SeeDocsDatabase = Room.inMemoryDatabaseBuilder(
        InstrumentationRegistry.getInstrumentation().targetContext,
        SeeDocsDatabase::class.java
    ).allowMainThreadQueries().build()

}