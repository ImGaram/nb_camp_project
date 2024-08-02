package com.example.imagelocker.view.screen

import android.content.Context.MODE_PRIVATE
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.imagelocker.view.component.LoadingIndicator
import com.example.imagelocker.view.item.SearchResultItem
import com.example.imagelocker.viewmodel.LockerViewModel

@Composable
fun LockerScreen(lockerViewModel: LockerViewModel = viewModel()) {
    val context = LocalContext.current
    val sp = context.getSharedPreferences("locker_list", MODE_PRIVATE)
    val lockerList = lockerViewModel.lockerList.collectAsState()
    val isLoading by lockerViewModel.isLoading.collectAsState()

    LaunchedEffect(Unit) {
        lockerViewModel.getData(sp)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        if (lockerList.value.isNotEmpty()) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                verticalItemSpacing = 8.dp,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                items(lockerList.value) {
                    SearchResultItem(
                        item = it,
                        removeLocker = {
                            lockerViewModel.removeData(it, sp)
                            Toast.makeText(context, "저장소의 데이터를 삭제했습니다.", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }

        if (isLoading == false) {
            LoadingIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            )
        }
    }
}

@Preview
@Composable
private fun LockerScreenPreview() {
    LockerScreen()
}