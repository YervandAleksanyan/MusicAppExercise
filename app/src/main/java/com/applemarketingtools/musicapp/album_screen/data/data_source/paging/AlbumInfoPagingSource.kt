//package com.applemarketingtools.musicapp.album_screen.data.data_source.paging
//
//import androidx.paging.PagingSource
//import androidx.paging.PagingState
//import com.applemarketingtools.musicapp.album_screen.data.DEFAULT_INIT_KEY
//import com.applemarketingtools.musicapp.album_screen.data.MAX_PAGE_SIZE
//import com.applemarketingtools.musicapp.album_screen.data.NEXT_PAGE_COUNT
//import com.applemarketingtools.musicapp.album_screen.data.enums.MediaTypeEnum
//import com.applemarketingtools.musicapp.album_screen.data.models.network.AlbumInfoDataResponse
//import com.applemarketingtools.musicapp.core.restservice.MusicAppRestServiceApi
//import okio.IOException
//import retrofit2.HttpException
//
//class AlbumInfoPagingSource(
//    private val musicAppRestApi: MusicAppRestServiceApi
//
//) : PagingSource<Int, AlbumInfoDataResponse>() {
//
//
//    override fun getRefreshKey(state: PagingState<Int, AlbumInfoDataResponse>): Int? {
//        val anchorPosition = state.anchorPosition ?: return null
//        val page = state.closestPageToPosition(anchorPosition) ?: return null
//        return page.prevKey?.plus(NEXT_PAGE_COUNT) ?: page.nextKey?.minus(NEXT_PAGE_COUNT)
//
//
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AlbumInfoDataResponse> {
//
//        return try {
//            val page = params.key ?: DEFAULT_INIT_KEY
//            val pageSize = params.loadSize.coerceAtMost(MAX_PAGE_SIZE)
//            val musicInfoListResponse = musicAppRestApi.getAllMusic(
//                locale = "us",
//                mediaType = MediaTypeEnum.MUSIC.typeName,
//                page = page
//            )
//
//
//            if (musicInfoListResponse.isSuccessful) {
//                val content =
//                    checkNotNull(musicInfoListResponse.body()).feed?.results ?: emptyList()
//                val nextKey = if (content.size < pageSize) null else page + NEXT_PAGE_COUNT
//                val prevKey = if (page == 1) null else page - NEXT_PAGE_COUNT
//                LoadResult.Page(
//                    data = content,
//                    prevKey = prevKey,
//                    nextKey = nextKey
//                )
//            } else {
//                LoadResult.Error(HttpException(musicInfoListResponse))
//
//            }
//
//
//        } catch (exception: IOException) {
//            return LoadResult.Error(exception)
//        } catch (exception: HttpException) {
//            return LoadResult.Error(exception)
//        }
//    }
//}