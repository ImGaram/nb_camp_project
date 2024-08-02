package com.example.imagelocker.view

import android.content.Context.MODE_PRIVATE
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.imagelocker.R
import com.example.imagelocker.view.component.SearchInfiniteLazyGrid
import com.example.imagelocker.viewmodel.LockerViewModel
import com.example.imagelocker.viewmodel.SearchViewModel
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun SearchScreen(
    searchViewModel: SearchViewModel = viewModel(),
    lockerViewModel: LockerViewModel = viewModel()
) {
    val context = LocalContext.current
    val searchList = searchViewModel.searchResult.collectAsState()
    val isLoading = searchViewModel.isLoading.collectAsState()
    val pageState = remember { mutableIntStateOf(1) }
    val sp = context.getSharedPreferences("locker_list", MODE_PRIVATE)

    Box(modifier = Modifier.fillMaxSize()) {
        val gridState = rememberLazyStaggeredGridState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            val searchKeywordState = rememberTextFieldState()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(elevation = 2.dp, spotColor = Color.DarkGray)
                    .background(Color.White)
                    .padding(8.dp)
            ) {
                val keyBoardController = LocalSoftwareKeyboardController.current
                val focusManager = LocalFocusManager.current

                BasicTextField2(
                    modifier = Modifier.fillMaxWidth(),
                    state = searchKeywordState,
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            val searchQuery = searchKeywordState.text.toString()
                            if (searchQuery.isNotEmpty()) {
                                searchViewModel.getSearchList(searchQuery, 1)
                            } else Toast.makeText(context, "검색어가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show()

                            keyBoardController?.hide()
                            focusManager.clearFocus()
                        }
                    ),
                    decorator = { innerTextField ->
                        Row(
                            modifier = Modifier
                                .background(Color.White, shape = RoundedCornerShape(8.dp))
                                .border(
                                    border = BorderStroke(1.dp, color = Color.LightGray),
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(vertical = 8.dp, horizontal = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(contentAlignment = Alignment.CenterStart) {
                                if (searchKeywordState.text.isEmpty()) {
                                    Text(
                                        text = "검색어를 입력하세요.",
                                        color = Color(0xFF9E9E9E)
                                    )
                                }
                                innerTextField()
                            }
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = "search",
                                modifier = Modifier.clickable {
                                    val searchQuery = searchKeywordState.text.toString()
                                    if (searchQuery.isNotEmpty()) {
                                        searchViewModel.getSearchList(searchQuery, 1)
                                    } else Toast.makeText(context, "검색어가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show()

                                    focusManager.clearFocus()
                                }
                            )
                        }
                    }
                )
            }

            SearchInfiniteLazyGrid(
                item = searchList.value,
                columns = StaggeredGridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                state = gridState,
                contentPadding = PaddingValues(8.dp),
                verticalItemSpacing = 8.dp,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                loading = isLoading.value,
                loadMore = {
                    pageState.intValue++
                    searchViewModel.getNextPageSearchList(searchKeywordState.text.toString(), pageState.intValue)
                },
                saveLocker = {
                    lockerViewModel.addData(it, sp)
                    Toast.makeText(context, "저장소에 저장되었습니다.", Toast.LENGTH_SHORT).show()
                }
            )
        }

        val reachedFirst: Boolean by remember {
            derivedStateOf { gridState.firstVisibleItemIndex != 0 }
        }
        val coroutineScope = rememberCoroutineScope()
        AnimatedVisibility(
            visible = reachedFirst,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 80.dp, end = 24.dp),
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            SmallFloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        gridState.animateScrollToItem(0)
                    }
                },
                containerColor = Color.Cyan,
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "상단으로 스크롤",
                    tint = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
    SearchScreen()
}