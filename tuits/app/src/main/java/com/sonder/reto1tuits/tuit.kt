package com.sonder.reto1tuits

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Mytuit() {
    Scaffold(
        topBar = { TopBar() }
    ) {
        Tuitt()
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Tuit cool", color = Color.White) },
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
        },
        backgroundColor = Color.Blue
    )
}

@Composable
fun Tuitt() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, end = 25.dp, start = 15.dp)
    ) {
        ImageProfile()
        Content()
    }
}

@Composable
fun ImageProfile() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "ProfileImage",
        modifier = Modifier
            .clip(
                CircleShape
            )
            .width(65.dp)
    )
}

@Composable
fun Content() {
    Column(
        modifier = Modifier
            .padding(start = 15.dp)
    ) {
        ContentProfile()
        ContentTuit()
        ContentImage()
        ButtonOptions()
    }
}

@Composable
fun ButtonOptions() {
    var chatIcon by rememberSaveable { mutableStateOf(false) }
    var iconShowChat by rememberSaveable { mutableStateOf(R.drawable.ic_chat) }
    var contIconChat by rememberSaveable { mutableStateOf(13) }

    var retuitIcon by rememberSaveable { mutableStateOf(false) }
    var iconShow by rememberSaveable { mutableStateOf(R.drawable.ic_rt) }
    var retuitIconChat by rememberSaveable { mutableStateOf(4) }

    var likeIcon by rememberSaveable { mutableStateOf(false) }
    var iconShowLike by rememberSaveable { mutableStateOf(R.drawable.ic_like) }
    var contIconLike by rememberSaveable { mutableStateOf(10) }

    var shareIcon by rememberSaveable { mutableStateOf(false) }
    var iconShowShare by rememberSaveable { mutableStateOf(R.drawable.ic_share) }
    var contIconShare by rememberSaveable { mutableStateOf(5) }

    Row(Modifier.padding(end = 30.dp, top = 10.dp, start = 0.dp)) {
        IconButton(id = iconShowChat, description = "chat", modifier = Modifier
            .weight(1f)
            .clickable {
                if (chatIcon) {
                    chatIcon = false
                    iconShowChat = R.drawable.ic_chat
                    contIconChat -= 1
                } else {
                    chatIcon = true
                    iconShowChat = R.drawable.ic_chat_filled
                    contIconChat += 1
                }
            })
        Text(text = contIconChat.toString())
        IconButton(id = iconShow, description = "retuit", modifier = Modifier
            .weight(1f)
            .clickable {
                if (retuitIcon) {
                    retuitIcon = false
                    iconShow = R.drawable.ic_rt
                    retuitIconChat -= 1
                } else {
                    retuitIcon = true
                    iconShow = R.drawable.ic_rt
                    retuitIconChat += 1
                }
            })
        Text(text = retuitIconChat.toString())
        IconButton(id = iconShowLike, description = "like", modifier = Modifier
            .weight(1f)
            .clickable {
                if (likeIcon) {
                    likeIcon = false
                    iconShowLike = R.drawable.ic_like
                    contIconLike -= 1
                } else {
                    likeIcon = true
                    iconShowLike = R.drawable.ic_like_filled
                    contIconLike += 1
                }
            })
        Text(text = contIconLike.toString())
        IconButton(id = iconShowShare, description = "share", modifier = Modifier
            .weight(1f)
            .clickable {
                if (shareIcon) {
                    shareIcon = false
                    iconShowShare = R.drawable.ic_share
                    contIconShare -= 1
                } else {
                    shareIcon = true
                    iconShowShare = R.drawable.ic_share
                    contIconShare += 1
                }
            })
        Text(text = contIconShare.toString())
    }
}

@Composable
fun IconButton(id: Int, description: String, modifier: Modifier) {
    Icon(
        painter = painterResource(id = id),
        contentDescription = description,
        modifier = modifier
    )
}

@Composable
fun ContentImage() {
    Image(
        painter = painterResource(id = R.drawable.profile),
        contentDescription = "ImageTuit",
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .clip(RoundedCornerShape(25.dp)),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun ContentTuit() {
    Column {
        Text(text = "Descripcion larga sobre el tweet")
        Text(text = "Descripcion larga sobre el tweet")
        Text(text = "Descripcion larga sobre el tweet")
        Text(text = "Descripcion larga sobre el tweet")
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun ContentProfile() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            Text(text = "Aris")
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "@AristiDevs")
            Spacer(modifier = Modifier.width(7.dp))
            Text(text = "4h")
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = painterResource(id = R.drawable.ic_dots), contentDescription = "options")
        }
    }
}

@Preview
@Composable
fun Prev(){
    Mytuit()
}