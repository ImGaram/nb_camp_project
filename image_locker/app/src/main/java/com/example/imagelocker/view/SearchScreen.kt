package com.example.imagelocker.view

import android.widget.Toast
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
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.example.imagelocker.view.component.LoadingIndicator
import com.example.imagelocker.view.item.SearchResultItem
import com.example.imagelocker.viewmodel.SearchViewModel

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun SearchScreen(searchViewModel: SearchViewModel = viewModel()) {
    val context = LocalContext.current
    val searchList = searchViewModel.searchResult.collectAsState()
    val isLoading = searchViewModel.isLoading.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 2.dp, spotColor = Color.DarkGray)
                .background(Color.White)
                .padding(8.dp)
        ) {
            val searchKeywordState = rememberTextFieldState()
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

        if (isLoading.value == true) {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                verticalItemSpacing = 8.dp,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(searchList.value) {
                    SearchResultItem(item = it)
                }
            }
        } else if (isLoading.value == false) {
            LoadingIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            )
        }
    }
}

@Preview
@Composable
private fun SearchScreenPreview() {
    SearchScreen()
}