package com.alis.boilerplate.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.alis.boilerplate.data.network.paging.FooPagingApiService
import com.alis.boilerplate.models.paging.FooPagingData
import retrofit2.HttpException
import java.io.IOException

private const val FOO_STARTING_PAGE_INDEX = 1

class FooPagingSource(
    private val service: FooPagingApiService
) : PagingSource<Int, FooPagingData>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, FooPagingData> {
        val startingPageNumber = params.key ?: FOO_STARTING_PAGE_INDEX

        return try {
            val response = service.fetchFooPagingData(startingPageNumber)
            val data = response.body()!!

            LoadResult.Page(
                data = data.data,
                prevKey = null,
                nextKey = data.next
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, FooPagingData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}