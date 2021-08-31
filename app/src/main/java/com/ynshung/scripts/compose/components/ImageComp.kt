package com.ynshung.scripts.compose.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ynshung.scripts.R
import java.io.File

// Show image stored in app data, if file is not found show a placeholder
@Composable
fun ImageComp(fileName: String?, size: Int) {
    var containsFile = false
    LocalContext.current.fileList()?.run {
        containsFile = this.contains(fileName)
    }
    if (fileName != null && containsFile) {
        Image(
            bitmap =
            BitmapFactory.decodeFile(
                File(LocalContext.current.filesDir, fileName).absolutePath
            ).asImageBitmap(),
            contentDescription = null,
            modifier = Modifier.size(size.dp)
        )
    } else {
        Icon(
            painter = painterResource(id = R.drawable.ic_error),
            contentDescription = null,
            modifier = Modifier
                .size((size - 6).dp)
                .padding(3.dp),
            tint = LocalContentColor.current.copy(alpha = 0.6f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ImageCompPreview() {
    ImageComp(fileName = "file.jpg", size = 24)
}
