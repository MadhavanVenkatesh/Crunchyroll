package com.example.bottomnavigationbarcomposeexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorPrimaryDark))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Home View",
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.Orange),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
fun MusicScreen() {
    WatchList(watchList = DatasourceMyList().loadWatching())
}
@Composable
private fun WatchList(watchList: List<Watching>, modifier: Modifier = Modifier)
{
    LazyColumn(Modifier.background(Color.Black)){
        items(watchList){ watching ->
            CrunchyrollCard(watching)
        }
    }
}
@Composable
fun CrunchyrollCard(watching: Watching, modifier: Modifier = Modifier) {
    Row(modifier = Modifier
        .wrapContentSize()
        .padding(20.dp, 0.dp)) {
        Card(backgroundColor = colorResource(id = R.color.Hale_Navy),
            modifier = Modifier
                .padding(3.dp)
                .width(170.dp)
        ){
            Column(){
                Image(painter = painterResource(watching.imageResourceId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(247.dp)
                )
                Text(text = LocalContext.current.getString(watching.stringResourceId),
                    style = TextStyle(fontSize = 17.sp, color = Color.White, fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .padding(8.dp,8.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row() {
                    Text(text = LocalContext.current.getString(watching.stringResourceId3),
                        style = TextStyle(fontSize = 13.sp, color = Color.White),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(8.dp,16.dp,0.dp,8.dp))

                    Spacer(modifier = Modifier.padding(55.dp,0.dp,0.dp,0.dp))
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.MoreVert, "Null")
                    }
                }
            }
        }
        Card(backgroundColor = colorResource(id = R.color.Hale_Navy),
            modifier = Modifier
                .padding(3.dp)
                .width(170.dp)
        ){
            Column(){
                Image(painter = painterResource(watching.imageResourceId2),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(247.dp)
                )
                Text(text = LocalContext.current.getString(watching.stringResourceId2),
                    style = TextStyle(fontSize = 17.sp, color = Color.White, fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .padding(8.dp,8.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row() {
                    Text(text = LocalContext.current.getString(watching.stringResourceId3),
                        style = TextStyle(fontSize = 13.sp, color = Color.White),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(8.dp,16.dp,0.dp,8.dp))

                    Spacer(modifier = Modifier
                        .padding(55.dp,0.dp,0.dp,0.dp))
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.MoreVert, "Null")
                    }
                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun MusicScreenPreview() {
    MusicScreen()
}

@Composable
fun MoviesScreen() {
    Column(
        Modifier
            .padding(5.dp)
            .background(Color.Black)
            .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical), verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Row (Modifier.padding(horizontal = 5.dp)){
            Card(elevation = 34.dp) {
                Box(modifier = Modifier.wrapContentSize(), Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.demon_slayer),
                        contentDescription = "action",
                        Modifier
                            .height(100.dp)
                            .width(180.dp)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(
                                        Brush.verticalGradient(
                                            0F to Color.Transparent,
                                            1000f to Color.Black
                                        )
                                    )
                                }
                            },
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "ACTION",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Card(elevation = 34.dp) {
                Box(modifier = Modifier.wrapContentSize(), Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.adv),
                        contentDescription = "action",
                        Modifier
                            .height(100.dp)
                            .width(180.dp)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(
                                        Brush.verticalGradient(
                                            0F to Color.Transparent,
                                            900f to Color.Black
                                        )
                                    )
                                }
                            },
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "ADVENTURE",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }
        }
        Row (Modifier.padding(horizontal = 5.dp)){
            Card(elevation = 34.dp) {
                Box(modifier = Modifier.wrapContentSize(), Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.comedy),
                        contentDescription = "action",
                        Modifier
                            .height(100.dp)
                            .width(180.dp)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(
                                        Brush.verticalGradient(
                                            0F to Color.Transparent,
                                            900f to Color.Black
                                        )
                                    )
                                }
                            },
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "COMEDY",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Card(elevation = 34.dp) {
                Box(modifier = Modifier.wrapContentSize(), Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.drama),
                        contentDescription = "action",
                        Modifier
                            .height(100.dp)
                            .width(180.dp)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(
                                        Brush.verticalGradient(
                                            0F to Color.Transparent,
                                            900f to Color.Black
                                        )
                                    )
                                }
                            },
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "DRAMA",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }
        }
        Row (Modifier.padding(horizontal = 5.dp)){
            Card(elevation = 34.dp) {
                Box(modifier = Modifier.wrapContentSize(), Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.fantasy),
                        contentDescription = "action",
                        Modifier
                            .height(100.dp)
                            .width(180.dp)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(
                                        Brush.verticalGradient(
                                            0F to Color.Transparent,
                                            900f to Color.Black
                                        )
                                    )
                                }
                            },
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "FANTASY",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Card(elevation = 34.dp) {
                Box(modifier = Modifier.wrapContentSize(), Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.music),
                        contentDescription = "action",
                        Modifier
                            .height(100.dp)
                            .width(180.dp)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(
                                        Brush.verticalGradient(
                                            0F to Color.Transparent,
                                            900f to Color.Black
                                        )
                                    )
                                }
                            },
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "MUSIC",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }
        }

        Row (Modifier.padding(horizontal = 5.dp)){
            Card(elevation = 34.dp) {
                Box(modifier = Modifier.wrapContentSize(), Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.rom),
                        contentDescription = "action",
                        Modifier
                            .height(100.dp)
                            .width(180.dp)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(
                                        Brush.verticalGradient(
                                            0F to Color.Transparent,
                                            900f to Color.Black
                                        )
                                    )
                                }
                            },
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "ROMANCE",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Card(elevation = 34.dp) {
                Box(modifier = Modifier.wrapContentSize(), Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.scifi),
                        contentDescription = "action",
                        Modifier
                            .height(100.dp)
                            .width(180.dp)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(
                                        Brush.verticalGradient(
                                            0F to Color.Transparent,
                                            900f to Color.Black
                                        )
                                    )
                                }
                            },
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "SCIFI",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }
        }

        Row (Modifier.padding(horizontal = 5.dp)){
            Card(elevation = 34.dp) {
                Box(modifier = Modifier.wrapContentSize(), Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.shonen),
                        contentDescription = "action",
                        Modifier
                            .height(100.dp)
                            .width(180.dp)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(
                                        Brush.verticalGradient(
                                            0F to Color.Transparent,
                                            900f to Color.Black
                                        )
                                    )
                                }
                            },
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "SHONEN",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Card(elevation = 34.dp) {
                Box(modifier = Modifier.wrapContentSize(), Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.sports),
                        contentDescription = "action",
                        Modifier
                            .height(100.dp)
                            .width(180.dp)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(
                                        Brush.verticalGradient(
                                            0F to Color.Transparent,
                                            900f to Color.Black
                                        )
                                    )
                                }
                            },
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "SPORTS",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }

        }

        Row (Modifier.padding(horizontal = 5.dp)){
            Card(elevation = 34.dp) {
                Box(modifier = Modifier.wrapContentSize(), Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.supernatural),
                        contentDescription = "action",
                        Modifier
                            .height(100.dp)
                            .width(180.dp)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(
                                        Brush.verticalGradient(
                                            0F to Color.Transparent,
                                            900f to Color.Black
                                        )
                                    )
                                }
                            },
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "SUPERNATURAL",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Card(elevation = 34.dp) {
                Box(modifier = Modifier.wrapContentSize(), Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.thriller),
                        contentDescription = "action",
                        Modifier
                            .height(100.dp)
                            .width(180.dp)
                            .drawWithCache {
                                onDrawWithContent {
                                    drawContent()
                                    drawRect(
                                        Brush.verticalGradient(
                                            0F to Color.Transparent,
                                            900f to Color.Black
                                        )
                                    )
                                }
                            },
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "THRILLER",
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview() {
    MoviesScreen()
}

@Composable
fun BooksScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Black)) {
        nav1()
        Spacer(modifier = Modifier.padding(10.dp))
        cardv1()
    }
}
@Composable
fun nav1(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .padding(start = 5.dp)
        .background(Color.Black)){
        Row {
            Image(painter = painterResource(id = R.drawable.ic_baseline_arrow_drop_down_24), contentDescription = "dropdown")
            Text(text = "Fall 2022", fontSize = 17.sp, color = Color.White, modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp), textDecoration = TextDecoration.Underline, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun cardv1(){
    Column(
        Modifier
            .padding(5.dp)
            .background(Color.Black)
            .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical),verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Row (Modifier.padding(horizontal = 5.dp)) {
            Card(elevation = 34.dp) {
                Column {
                    Box(Modifier.wrapContentSize(), androidx.compose.ui.Alignment.BottomStart) {
                        Image(
                            painter = painterResource(id = R.drawable.demon_slayer),
                            contentDescription = "demon",
                            Modifier
                                .height(220.dp)
                                .width(175.dp), contentScale = ContentScale.FillHeight
                        )

                    }
                    Box(
                        Modifier
                            .background(colorResource(id = R.color.Hale_Navy))
                            .height(50.dp)
                            .width(175.dp)) {
                        Column(Modifier.wrapContentSize()) {
                            Text(
                                text = "Demon Slayer",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Row() {
                                Text(text = "SERIES", color = Color.White)
                                Icon(
                                    Icons.Default.MoreVert,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.padding(start = 100.dp)
                                )
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))

            Card(elevation = 34.dp) {
                Column {
                    Box(Modifier.wrapContentSize(), androidx.compose.ui.Alignment.BottomStart) {
                        Image(
                            painter = painterResource(id = R.drawable.supernatural),
                            contentDescription = "demon",
                            Modifier
                                .height(220.dp)
                                .width(178.dp),contentScale = ContentScale.FillHeight
                        )

                    }
                    Box(
                        Modifier
                            .background(colorResource(id = R.color.Hale_Navy))
                            .height(50.dp)
                            .width(178.dp)) {
                        Column(Modifier.wrapContentSize()) {
                            Text(
                                text = "FIRE FORCE",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Row(Modifier.wrapContentSize()) {
                                Text(text = "SERIES", color = Color.White)
                                Icon(
                                    Icons.Default.MoreVert,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.padding(start = 103.dp)
                                )
                            }
                        }
                    }
                }
            }

        }

        Row (Modifier.padding(horizontal = 5.dp)) {
            Card(elevation = 34.dp) {
                Column {
                    Box(Modifier.wrapContentSize(), androidx.compose.ui.Alignment.BottomStart) {
                        Image(
                            painter = painterResource(id = R.drawable.sports),
                            contentDescription = "demon",
                            Modifier
                                .height(220.dp)
                                .width(175.dp), contentScale = ContentScale.FillWidth
                        )

                    }
                    Box(
                        Modifier
                            .background(colorResource(id = R.color.Hale_Navy))
                            .height(50.dp)
                            .width(175.dp)) {
                        Column(Modifier.wrapContentSize()) {
                            Text(
                                text = "Haikyuu",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Row(Modifier.wrapContentSize()) {
                                Text(text = "SERIES", color = Color.White)
                                Icon(
                                    Icons.Default.MoreVert,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.padding(start = 100.dp)
                                )
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))

            Card(elevation = 34.dp) {
                Column {
                    Box(Modifier.wrapContentSize(), androidx.compose.ui.Alignment.BottomStart) {
                        Image(
                            painter = painterResource(id = R.drawable.adv),
                            contentDescription = "demon",
                            Modifier
                                .height(220.dp)
                                .width(178.dp),contentScale = ContentScale.Crop
                        )

                    }
                    Box(
                        Modifier
                            .background(colorResource(id = R.color.Hale_Navy))
                            .height(50.dp)
                            .width(178.dp)) {
                        Column(Modifier.wrapContentSize()) {
                            Text(
                                text = "LOG HORIZON",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Row(Modifier.wrapContentSize()) {
                                Text(text = "SERIES", color = Color.White)
                                Icon(
                                    Icons.Default.MoreVert,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.padding(start = 103.dp)
                                )
                            }
                        }
                    }
                }
            }

        }
        Row (Modifier.padding(horizontal = 5.dp)) {
            Card(elevation = 34.dp) {
                Column {
                    Box(Modifier.wrapContentSize(), androidx.compose.ui.Alignment.BottomStart) {
                        Image(
                            painter = painterResource(id = R.drawable.drama),
                            contentDescription = "demon",
                            Modifier
                                .height(220.dp)
                                .width(178.dp), contentScale = ContentScale.FillHeight
                        )

                    }
                    Box(
                        Modifier
                            .background(colorResource(id = R.color.Hale_Navy))
                            .height(50.dp)
                            .width(178.dp)) {
                        Column(Modifier.wrapContentSize()) {
                            Text(
                                text = "Kingdom",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Row(Modifier.wrapContentSize()) {
                                Text(text = "SERIES", color = Color.White)
                                Icon(
                                    Icons.Default.MoreVert,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.padding(start = 100.dp)
                                )
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.padding(5.dp))

            Card(elevation = 34.dp) {
                Column {
                    Box(Modifier.wrapContentSize(), androidx.compose.ui.Alignment.BottomStart) {
                        Image(
                            painter = painterResource(id = R.drawable.shonen),
                            contentDescription = "demon",
                            Modifier
                                .height(220.dp)
                                .width(178.dp),contentScale = ContentScale.Crop
                        )

                    }
                    Box(
                        Modifier
                            .background(colorResource(id = R.color.Hale_Navy))
                            .height(50.dp)
                            .width(178.dp)) {
                        Column(Modifier.wrapContentSize()) {
                            Text(
                                text = "Black Clover",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Row(Modifier.wrapContentSize()) {
                                Text(text = "SERIES", color = Color.White)
                                Icon(
                                    Icons.Default.MoreVert,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.padding(start = 103.dp)
                                )
                            }
                        }
                    }
                }
            }

        }

    }
}



@Preview(showBackground = true)
@Composable
fun BooksScreenPreview() {
    BooksScreen()
}


@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.colorPrimaryDark))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Profile View",
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.Orange),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {

}
