package com.demo.newsapplication.data.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface ChatDao {
    //region chat_user
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertChatUsers(listUsers: Collection<ChatUserEntity>): List<Long>?


//    suspend fun clearAll() {
//        clearMessages()
//        clearUsers()
//    }

//    @Query("DELETE FROM chat_user")
//    suspend fun clearUsers()
//
//    @Query("DELETE FROM chat_message")
//    suspend fun clearMessages()
}