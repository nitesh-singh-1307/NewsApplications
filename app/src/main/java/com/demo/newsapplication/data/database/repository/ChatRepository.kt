package com.demo.newsapplication.data.database.repository

import com.demo.newsapplication.data.database.daos.ChatDao
import com.demo.newsapplication.data.database.entities.ChatMessageEntity
import com.google.gson.Gson
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

@DelicateCoroutinesApi
@ObsoleteCoroutinesApi
class ChatRepository(private val chatDao: ChatDao) {

//    private val app by lazy { App.getInstance() }
//    private val pref by lazy { app.getPref() }
    private val repositoryScope = CoroutineScope(Dispatchers.IO)
    private val serverDateFormat =
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault()).apply {
            timeZone = TimeZone.getTimeZone("UTC")
        }

    companion object {
        const val TAG = "ChatRepository"
    }


//
//    fun clearAll() {
//        repositoryScope.launch { chatDao.clearAll() }
//    }



    }

    /*fun insertOfflineData(data: OfflineSyncData) {
        repositoryScope.launch {
            if (data.messages.isNotEmpty()) {
                val messages = data.messages.map {
                    ChatMessageEntity(
                        id = it.id.toLong(),
                        chatId = it.chat_id,
                        createdAt = (serverDateFormat.parse(it.created_date) ?: Date()).time,
                        message = it.message,
                        messageId = it.m_id,
                        messageType = it.message_type,
                        readStatus = it.read_status,
                        receiverId = it.receiver_id.toLong(),
                        senderId = it.sender_id.toLong(),
                    )
                }
                chatDao.insertChatMessages(messages)
            }
            if (data.delivery.isNotEmpty()) {
                val deliveredMessage = data.delivery.groupBy { it.chat_id }
                deliveredMessage.forEach {
                    chatDao.updateReadStatus(it.key, ReadStatus.DELIVERED.status)
                }
            }
            if (data.delete.isNotEmpty()) {
                data.delete.forEach { deleteMessage ->
                    when (deleteMessage.delete_status) {
                        1 -> pref.userInfo?.id?.let { chatDao.deleteMessageForSender(deleteMessage.m_id, it.toLong()) }
                        2 -> pref.userInfo?.id?.let { chatDao.deleteMessageForReceiver(deleteMessage.m_id, it.toLong()) }
                        3, 4 -> chatDao.deleteMessage(deleteMessage.m_id)
                    }
                }
            }
            if (data.read.isNotEmpty()) {
                val readMessage = data.read.groupBy { it.chat_id }
                readMessage.forEach {
                    chatDao.updateReadStatus(it.key, ReadStatus.READ.status)
                }
            }
            if (data.block_unblock.isNotEmpty()) {

                val readMessage = data.read.groupBy { it.chat_id }
                readMessage.forEach {
                    chatDao.updateReadStatus(it.key, ReadStatus.READ.status)
                }
            }
        }
    }*/

