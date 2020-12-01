package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .setDatabaseUrl(dbUrl)
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
            .putData("action", "newPost")
            .putData("content", """{
          "id": 1,
          "author": "Den Dirty",
          "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In facilisis semper efficitur. Nullam quis commodo velit. Quisque sollicitudin augue quis tellus dapibus varius. Cras aliquam eleifend lobortis. Praesent pellentesque massa ac auctor suscipit. Integer consequat lorem a euismod dapibus. Vestibulum eu sodales neque. Sed iaculis, dui et feugiat mollis, nulla nisi fermentum libero, vitae tristique ante neque facilisis tortor. Donec ut ipsum sit amet dui mattis rutrum. Suspendisse porta, enim quis feugiat fermentum, mauris arcu dignissim odio, non rutrum ipsum risus a ex. Praesent quis nisl sed libero egestas hendrerit in nec est. Aliquam quis rhoncus nisi. In aliquet dictum lorem, vitae rutrum ex tempus ut. Sed posuere sit amet augue ut tincidunt. Duis aliquet eleifend lobortis. Vestibulum sed commodo ante. Phasellus fermentum sem vel hendrerit porta. Cras at est vel nulla efficitur ornare id a nisl. Nullam congue mattis tellus, eget faucibus dui blandit non. Morbi magna velit, semper sit amet odio eget, efficitur bibendum tellus. Mauris egestas nisl nec massa malesuada, condimentum pharetra lectus consectetur. Mauris ut enim feugiat, molestie quam ac, feugiat sem. Pellentesque interdum dapibus lobortis. Aliquam non mauris dictum, laoreet libero non, feugiat augue. Maecenas convallis lobortis magna. Nullam sollicitudin sit amet ante in luctus."
        }""".trimIndent())
            .setToken(token)
            .build()

    FirebaseMessaging.getInstance().send(message)
}
