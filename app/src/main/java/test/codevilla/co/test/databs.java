package test.codevilla.co.test;


        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Akeel's PC on 12/28/2016.
 */
public class databs extends SQLiteOpenHelper {
    public static final String id="ID";
    public static final String username="username";
    public static final String password="password";
    public static final String database_name="ntudatabase";
    public static final String Table_name="student";
    public  static final int DB_version=1;

    private static final String create_query =
            "CREATE TABLE " + Table_name + " (" +
                    id + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    username + " TEXT, " +
                    password + " TEXT);";

    public databs(Context context) {
        super(context, database_name, null, DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        insertdata(sqLiteDatabase);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table_name);
        onCreate(sqLiteDatabase);
    }


    public Cursor getinformation(){
        SQLiteDatabase sq=this.getReadableDatabase();
        Cursor cr=sq.rawQuery("select * from "+Table_name,null);
        return cr;
    }


    public void insertdata(SQLiteDatabase sq){
        sq.execSQL(create_query);
        sq.execSQL("INSERT INTO " +Table_name+ "(username,password) VALUES ('aqeel', 'aqeel')");
        sq.execSQL("INSERT INTO " +Table_name+ "(username,password) VALUES ('mohsin', 'mohsin')");
        sq.execSQL("INSERT INTO " +Table_name+ "(username,password) VALUES ('waqar', 'waqar')");

    }
}
