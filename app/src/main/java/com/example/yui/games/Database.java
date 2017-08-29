package com.example.yui.games;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

public class Database extends SQLiteOpenHelper{

    // The Android's default system path of your application database.
    //data/data/ and /databases remain the same always. The one that must be changed is com.example which represents
    //the MAIN package of your project
    private static String DB_PATH = "/data/data/com.example.yui.games/databases/";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "mydatabase";

    // Table Name
    private static final String TABLE_NAME = "Result";

    private static Database sInstance = null;
    private static SQLiteDatabase mDataBase;

    // Config File
    private static final String CONFIG_FILE = "Config.txt";


    public Database() {
        super(ApplicationContextProvider.getContext(), DATABASE_NAME, null, DATABASE_VERSION);

        try {
            createDataBase();
            openDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Singleton for DataBase
     * @return singleton instance
     */
    public static Database instance() {

        if (sInstance == null) {
            sInstance = new Database();
        }
        return sInstance;
    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * @throws java.io.IOException io exception
     */
    private void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if (dbExist) {
            // do nothing - database already exist
            Log.d("DATABASE","Database Exit Already.");

        } else {

            // Create Folder
            String newFolder = "/games";
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File myNewFolder = new File(extStorageDirectory + newFolder);
            myNewFolder.mkdir();

            // Create Folder
//            newFolder = "/FishRisk/Game";
//            extStorageDirectory = Environment.getExternalStorageDirectory().toString();
//            myNewFolder = new File(extStorageDirectory + newFolder);
//            myNewFolder.mkdir();

            // Create Folder
            newFolder = "/games/Report";
            extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            myNewFolder = new File(extStorageDirectory + newFolder);
            myNewFolder.mkdir();

            // Create Folder
            newFolder = "/games/Config";
            extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            myNewFolder = new File(extStorageDirectory + newFolder);
            myNewFolder.mkdir();

            //copyConfigFile();

            // By calling this method an empty database will be created into
            // the default system path
            // of your application so we are gonna be able to overwrite that
            // database with our database.
            this.getReadableDatabase();

            try {
                copyDataBase();
                copyConfigFile();
            } catch (IOException e) {

                throw new Error("Error copying database");
            }
        }
    }

    /**
     * Check if the database already exist to avoid re-copying the file each
     * time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean checkDataBase() {

        SQLiteDatabase checkDB = null;

        try {
            String myPath = DB_PATH + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null,
                    SQLiteDatabase.OPEN_READONLY);

        } catch (SQLiteException e) {

            // database doesn't exist yet.
            Log.d("DATABASE","Database doesn't exist yet.");
        }

        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null;
    }

    /**
     * Copies your database from your local assets-folder to the just created
     * empty database in the system folder, from where it can be accessed and
     * handled. This is done by transfering bytestream.
     * @throws java.io.IOException io exception
     */
    public void copyDataBase() throws IOException {

        // Open your local db as the input stream
        InputStream myInput = ApplicationContextProvider.getContext().getAssets().open(DATABASE_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH + DATABASE_NAME;

        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void copyConfigFile() throws IOException {

        // Open your local db as the input stream
        InputStream myInput = ApplicationContextProvider.getContext().getAssets().open(CONFIG_FILE);

        // Path to the just created empty db
        //String outFileName = DB_PATH + DATABASE_NAME;
        String outFileName = "/sdcard/games/Config/ConfigA.txt";


        // Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        // transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        // Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }



    private void openDataBase() throws SQLException {

        // Open the database
        String myPath = DB_PATH + DATABASE_NAME;
        mDataBase = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.OPEN_READWRITE);
    }

    /**
     * Select method
     * @param query select query
     * @return - Cursor with the results
     * @throws android.database.SQLException sql exception
     */
    public Cursor select(String query) throws SQLException {
        return mDataBase.rawQuery(query, null);
    }

    /**
     * Insert method
     * @param table  - name of the table
     * @param values values to insert
     * @throws android.database.SQLException sql exception
     */
    public void insert(String table, ContentValues values) throws SQLException {
        mDataBase.insert(table, null, values);
    }

    /**
     * Delete method
     * @param table - table name
     * @param where WHERE clause, if pass null, all the rows will be deleted
     * @throws android.database.SQLException sql exception
     */
    public void delete(String table, String where) throws SQLException {

        mDataBase.delete(table, where, null);
    }

    /**
     * Update method
     * @param table  - table name
     * @param values - values to update
     * @param where  - WHERE clause, if pass null, all rows will be updated
     */
    public void update(String table, ContentValues values, String where) {

        mDataBase.update(table, values, where, null);
    }

    /**
     * Let you make a raw query
     * @param command - the sql comand you want to run
     */
    public void sqlCommand(String command) {
        mDataBase.execSQL(command);
    }

    @Override
    public synchronized void close() {

        if (mDataBase != null)
            mDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

//		    db.execSQL("CREATE TABLE members " +
//			          "(MemberID INTEGER PRIMARY KEY," +
//			          " Name TEXT(100)," +
//			          " Tel TEXT(100));");

        //Log.d("CREATE TABLE","Create Table Successfully.");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public List<sMembers> SelectId(String Id) {
        try {
            List<sMembers> MemberList = new ArrayList<sMembers>();

            SQLiteDatabase db;
            db = this.getReadableDatabase(); 	// Read Data

            String strSQL = "SELECT  * FROM " + TABLE_NAME + " WHERE PlayerID = '"+Id+"'";
            Cursor cursor = db.rawQuery(strSQL, null);

            if(cursor != null){
                if (cursor.moveToFirst()) {
                    do {
                        sMembers cMember = new sMembers();
                        cMember.sPlayerID(cursor.getString(0));
                        cMember.sSession(cursor.getString(1));
                        cMember.sDate(cursor.getString(2));
                        cMember.sTime(cursor.getString(3));
                        cMember.sGame(cursor.getString(4));
                        cMember.sCrop(cursor.getString(5));

                        cMember.sDensity(cursor.getString(6));
                        cMember.sFlood(cursor.getString(7));

                        cMember.sPaid(cursor.getString(8));
                        cMember.sQuestion(cursor.getString(9));
                        cMember.sGameID(cursor.getString(10));

                        MemberList.add(cMember);
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();db.close();
            return MemberList;
        } catch (Exception e) { return null;}
    }

    // Select Data
    public String[] SelectData(String strID) {
        try {
            String arrData[] = null;

            SQLiteDatabase db;
            db = this.getReadableDatabase(); 			// Read Data

            Cursor cursor = db.query(TABLE_NAME, new String[] { "*" }, "PlayerID=?",
                    new String[] { String.valueOf(strID) }, null, null, null, null);

            if(cursor != null){

                if (cursor.moveToFirst()) {
                    arrData = new String[cursor.getColumnCount()];

                    arrData[0] = cursor.getString(0);
                    arrData[1] = cursor.getString(1);
                    arrData[2] = cursor.getString(2);
                    arrData[3] = cursor.getString(3);
                    arrData[4] = cursor.getString(4);
                    arrData[5] = cursor.getString(5);
                }
            }
            cursor.close();
            db.close();
            return arrData;

        } catch (Exception e) {
            return null;
        }

    } //SelectData



    // Select All Data
    public class sMembers {
        String _PlayerID,_Session,_Date,_Time,_Game,_Crop, _Density, _Flood, _Paid,_Question,_GameID;

        // Set Value
        public void sPlayerID(String vPlayerID){
            this._PlayerID = vPlayerID;
        }

        public void sSession(String vSession){
            this._Session = vSession;
        }

        public void sDate(String vDate){
            this._Date = vDate;
        }

        public void sTime(String vTime){
            this._Time = vTime;
        }

        public void sGame(String vGame){
            this._Game = vGame;
        }

        public void sCrop(String vCrop){
            this._Crop = vCrop;
        }

        public void sDensity(String vDensity){
            this._Density = vDensity;
        }

        public void sFlood(String vFlood){
            this._Flood = vFlood;
        }

        public void sPaid(String vPaid){
            this._Paid = vPaid;
        }

        public void sQuestion(String vQuestion){
            this._Question = vQuestion;
        }

        public void sGameID(String vGameID){
            this._GameID = vGameID;
        }

        // Get Value
        public String gPlayerID(){return _PlayerID;}

        public String gSession(){return _Session;}

        public String gDate(){return _Date;}

        public String gTime(){return _Time;}

        public String gGame(){return _Game;}

        public String gCrop(){return _Crop;}

        public String gDensity(){return _Density;}

        public String gFlood(){return _Flood;}

        public String gPaid(){return _Paid;}

        public String gQestion(){return _Question;}

        public String gGameID(){return _GameID;}
    }

    public List<sMembers> SelectAllData() {

        try {
            List<sMembers> MemberList = new ArrayList<sMembers>();

            SQLiteDatabase db;
            db = this.getReadableDatabase(); // Read Data

            String strSQL = "SELECT  * FROM " + "Result ORDER BY _Id  DESC";
            Cursor cursor = db.rawQuery(strSQL, null);

            if(cursor != null){
                if (cursor.moveToFirst()) {
                    do {
                        sMembers cMember = new sMembers();
                        cMember.sPlayerID(cursor.getString(0));
                        cMember.sSession(cursor.getString(1));
                        cMember.sDate(cursor.getString(2));
                        cMember.sTime(cursor.getString(3));
                        cMember.sGame(cursor.getString(4));
                        cMember.sCrop(cursor.getString(5));

                        cMember.sDensity(cursor.getString(6));
                        cMember.sFlood(cursor.getString(7));

                        cMember.sPaid(cursor.getString(8));
                        cMember.sQuestion(cursor.getString(9));
                        cMember.sGameID(cursor.getString(10));

                        MemberList.add(cMember);
                    } while (cursor.moveToNext());
                }
            }
            cursor.close();
            db.close();
            return MemberList;

        } catch (Exception e) { return null;}

    }


    // Insert Data
    public long InsertData(String strID, String strSession,String strDate, String strTime,
                           String strGame, String strCrop,String strDensity,String strFlood,
                           String strPaid,String strQuestion,String strGameID) {

        try {
            SQLiteDatabase db;
            db = this.getWritableDatabase(); 		// Write Data

            ContentValues Val = new ContentValues();
            Val.put("PlayerID", strID);
            Val.put("Session", strSession);

            Val.put("Date", strDate);
            Val.put("Time", strTime);

            Val.put("GameTotal", strGame);
            Val.put("CropTotal", strCrop);

            Val.put("Density", strDensity);
            Val.put("Flood", strFlood);

            Val.put("PayOff", strPaid);
            Val.put("Question", strQuestion);

            Val.put("GameID", strGameID);


            long rows = db.insert(TABLE_NAME, null, Val);
            db.close();
            return rows; 							// return rows inserted.

        } catch (Exception e) {return -1;}
    }



}
