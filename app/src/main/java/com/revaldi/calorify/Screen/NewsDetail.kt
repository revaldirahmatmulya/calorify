package com.revaldi.calorify.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.revaldi.calorify.Data.Article

@Composable
fun NewsDetail(article: Article,navController: NavHostController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = article.title, style = MaterialTheme.typography.h1,color = Color.Black, fontWeight = FontWeight.Bold)
        Image(
            painter = rememberImagePainter(article.urlToImage),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 16.dp)
                .fillMaxWidth()
                .height(200.dp)
        )
        Text(text = article.publishedAt, style = MaterialTheme.typography.body1, color = Color.Black)
        Text(text = article.author, style = MaterialTheme.typography.h3,color = Color.Black,fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = article.description, style = MaterialTheme.typography.body1,color = Color.Black)

    }
}