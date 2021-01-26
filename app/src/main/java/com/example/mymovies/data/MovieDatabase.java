package com.example.mymovies.data;

import android.content.Context;
import android.content.Entity;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Movie.class, FavouriteMovie.class}, version = 3, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

    private static final String NAME_DB = "notes.db";
    private static MovieDatabase database;
    private static final Object LOCK = new Object();

    public static MovieDatabase getInstance(Context context) {
        synchronized (LOCK) {
            if (database == null) {
                database = Room.databaseBuilder(context, MovieDatabase.class, NAME_DB).fallbackToDestructiveMigration().build();
            }
        }
        return database;
    }

    public abstract MovieDao movieDao();
}
