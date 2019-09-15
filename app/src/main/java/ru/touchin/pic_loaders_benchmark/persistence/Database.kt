package ru.touchin.pic_loaders_benchmark.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.touchin.pic_loaders_benchmark.persistence.entities.UserEntity

@Database(version = 1, entities = [UserEntity::class], exportSchema = false)
abstract class Database : RoomDatabase()
