package ru.touchin.pic_loaders_benchmark.viewcontrollers.recyclerview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class RecyclerViewState(
        val picProcessor: PicProcessor,
        val picType: PicType,
        val picSize: PicSize
) : Parcelable {

    enum class PicProcessor {
        GLIDE, FRESCO, PICASSO, COIL
    }

    enum class PicType {
        JPEG, PNG, WEBP
    }

    enum class PicSize {
        LARGE, SMALL
    }

}
