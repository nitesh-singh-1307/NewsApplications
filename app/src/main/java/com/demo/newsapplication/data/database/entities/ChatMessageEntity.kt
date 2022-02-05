package com.demo.newsapplication.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chat_message")
data class ChatMessageEntity(
    @PrimaryKey
    var id: Long = 0,
    val messageId: String,
    val message: String,
    val messageType: Int,
    val unReadCount: Int = 0,
    var isMarkUnread: Int = 0,
    val senderId: Long,
    val sendName: String = "",
    val senderAvatar: String ="",
    val receiverId: Long,
    val readStatus: Int,
    val createdAt: Long,
    val chatId: String,
)