package com.example.imagelocker.view.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.imagelocker.data.response.ResultDocument
import com.example.imagelocker.view.item.SearchResultItem

@Composable
fun SearchInfiniteLazyGrid(
    item: List<ResultDocument>,
    columns: StaggeredGridCells,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    verticalItemSpacing: Dp = 0.dp,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(0.dp),
    loading: Boolean?,
    loadMore: () -> Unit = {}
) {
    val gridState = rememberLazyStaggeredGridState()
    // 최하단에 도달했을 때의 state
    val reachedBottom: Boolean by remember {
        derivedStateOf {
            val lastVisibleItem = gridState.layoutInfo.visibleItemsInfo.lastOrNull()
            lastVisibleItem?.index != 0 && lastVisibleItem?.index == gridState.layoutInfo.totalItemsCount - 1
        }
    }

    LaunchedEffect(reachedBottom) {
        if (reachedBottom) {
            loadMore()
        }
    }

    Column {
        if (item.isNotEmpty()) {
            LazyVerticalStaggeredGrid(
                columns = columns,
                modifier = modifier,
                state = gridState,
                contentPadding = contentPadding,
                verticalItemSpacing = verticalItemSpacing,
                horizontalArrangement = horizontalArrangement
            ) {
                items(item) {
                    SearchResultItem(item = it)
                }
            }
        }

        if (loading == false) {
            LoadingIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp)
            )
        }
    }
}