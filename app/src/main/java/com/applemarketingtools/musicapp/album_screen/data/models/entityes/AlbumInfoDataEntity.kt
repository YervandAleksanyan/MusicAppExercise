package com.applemarketingtools.musicapp.album_screen.data.models.entityes

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


open class AlbumInfoDataEntity : RealmObject {
    @PrimaryKey
    var id: String? = ""
    var artistId: String? = ""
    var artistName: String? = ""
    var artistUrl: String? = ""
    var imageUrl: String? = ""
    var contentAdvisoryRating: String? = ""
    var kind: String? = ""
    var name: String? = ""
    var releaseDate: String? = ""
    var url: String? = ""
    var copyright:String? = ""

}
