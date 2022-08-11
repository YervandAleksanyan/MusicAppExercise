package com.applemarketingtools.musicapp.core.data.database.dao

import com.applemarketingtools.musicapp.album_screen.data.models.entityes.AlbumInfoDataEntity
import com.applemarketingtools.musicapp.core.extensions.i
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query

class MusicAppDaoImpl(private val realmAppDB: Realm) : MusicAppDao {

    override fun insertAllAlbumInfo(albumInfoListData: List<AlbumInfoDataEntity>) {

        albumInfoListData.forEach {
            realmAppDB.writeBlocking {

                // fetch a frog from the realm based on some query
                val albumInfoData: AlbumInfoDataEntity? =
                    realmAppDB.query<AlbumInfoDataEntity>("id == '${it.id}'").first().find()

                // if the query returned an object, update object from the query
                if (albumInfoData != null) {
                    albumInfoData.id = it.id
                    albumInfoData.name = it.name
                    albumInfoData.artistId = it.artistName
                    albumInfoData.imageUrl = it.imageUrl
                    albumInfoData.artistUrl = it.artistUrl
                    albumInfoData.contentAdvisoryRating = it.contentAdvisoryRating
                    albumInfoData.kind = it.kind
                    albumInfoData.releaseDate = it.releaseDate
                    albumInfoData.url = it.url
                    albumInfoData.artistName = it.artistName
                    albumInfoData.copyright = it.copyright

                    i {
                        "Update Album Info in Realm DB ->${AlbumInfoDataEntity()}"
                    }

                } else {
                    // if the query returned no object, insert a new object with a new primary key.
                    copyToRealm(AlbumInfoDataEntity().apply {
                        id = it.id
                        name = it.name
                        artistName = it.artistName
                        artistId = it.artistName
                        imageUrl = it.imageUrl
                        artistUrl = it.artistUrl
                        contentAdvisoryRating = it.contentAdvisoryRating
                        kind = it.kind
                        releaseDate = it.releaseDate
                        url = it.url
                        copyright = it.copyright
                    })

                    i {
                        "Save Album Info in Realm DB ->${AlbumInfoDataEntity()}"
                    }
                }
            }
        }
    }

    override fun getAllAlbumInfo(): List<AlbumInfoDataEntity> {
        i {
            "Get All Album Info from Realm DB ->${realmAppDB.query<AlbumInfoDataEntity>().find()}"
        }
        return realmAppDB.query<AlbumInfoDataEntity>().find()
    }
}