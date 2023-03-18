package com.example.databaseapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseAdapter {
    static DataBaseHelper dataBaseHelper;
    public DataBaseAdapter (Context context){
        dataBaseHelper = new DataBaseHelper(context);
    }
    public long addUser(UserDTO user){
        SQLiteDatabase db = dataBaseHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.COL_USERNAME,user.getUserName());
        contentValues.put(DataBaseHelper.COL_USERPHONE,user.getPhone());
        long id = db.insert(DataBaseHelper.TABLE_NAME,null,contentValues);
        return id;
    }

    public UserDTO getUrse(){
        UserDTO userDTO = null;
        Cursor c ;
        SQLiteDatabase db = dataBaseHelper.getReadableDatabase();
        String [] columns = {DataBaseHelper.COL_USERNAME , DataBaseHelper.COL_USERPHONE};
        c = db.query(DataBaseHelper.TABLE_NAME , columns ,null,null,null,null,null);
        while(c.moveToNext()){
            userDTO = new UserDTO(c.getString(0),c.getString(1));
        }
        return  userDTO;
    }

    static class DataBaseHelper extends SQLiteOpenHelper {


        private static final int DATA_BASE_VERSION = 1;
        private static final String DATA_BASE_NAME = "mydb";
        private static final String TABLE_NAME = "usersData";
        private static final String COL_UID = "_id";
        private static final String COL_USERNAME = "usersname";
        private static final String COL_USERPHONE = "usersPhone";
        private static final String CREATE_TABLE_USERS = "CREATE TABLE "+ TABLE_NAME +" ("+ COL_UID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+ COL_USERNAME +" TEXT, "+ COL_USERPHONE + " TEXT );";

        public DataBaseHelper(@Nullable Context context) {
            super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
           db.execSQL(CREATE_TABLE_USERS);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}


