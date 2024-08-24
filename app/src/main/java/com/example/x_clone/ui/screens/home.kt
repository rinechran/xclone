package com.example.x_clone.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.x_clone.model.Photo
import com.example.x_clone.ui.StartUiState
import com.example.x_clone.ui.theme.X_cloneTheme
import com.example.x_clone.ui.xCloneModelView


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun XcloneAppBar(scrollBehavior : TopAppBarScrollBehavior, modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(text = "XClone")
        }
    )
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun XcloneApp( ) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior() // 변수명 수정
    Scaffold(
        topBar = { XcloneAppBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val xCloneModelView: xCloneModelView = viewModel()
            HomeScreen(xCloneModelView = xCloneModelView)
        }
    }
}
@Composable
fun HomeScreen(xCloneModelView: xCloneModelView , modifier: Modifier = Modifier){
    when (xCloneModelView.stateUiState) {
        is StartUiState.Success -> ResultScreen(
            xCloneModelView.photos, modifier = modifier.fillMaxWidth()
        )

        StartUiState.Error -> Test(modifier = modifier.fillMaxWidth())
        StartUiState.Loading -> Test(modifier = modifier.fillMaxWidth())
    }
}
@Composable
fun ResultScreen(photos: List<Photo>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(photos) { photo ->
            PhotoCard(photo = photo)
        }
    }
}

@Composable
fun PhotoCard(photo : Photo ){
    Image(
        painter = rememberAsyncImagePainter(photo.thumbnailUrl),
        contentDescription = null,
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = photo.title)
    Spacer(modifier = Modifier.height(4.dp))
    Text(text = photo.url)
}

@Composable
fun Test( modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
        ) {
            Text(text = "asd")
        }
    }
}