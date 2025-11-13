package id.bytezilla.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import id.bytezilla.borutoapp.data.local.dao.HeroDao
import id.bytezilla.borutoapp.data.local.dao.HeroRemoteKeyDao
import id.bytezilla.borutoapp.domain.model.Hero
import id.bytezilla.borutoapp.domain.model.HeroRemoteKey

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao

}