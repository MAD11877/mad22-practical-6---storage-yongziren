package sg.edu.np.mad.madpractical;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    public DBHandler(Context c) {
        super(c,"P03.db",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE User (Name TEXT, Description TEXT, Id  INT, Followed TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVerion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS User");
        onCreate(db);
    }
    public void insertUser(User u) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO User VALUES(\""+u.Name+"\", \""+u.Description+"\", \""+u.Id+"\", \""+u.Followed+"\")");
        db.close();
    }
    public ArrayList<User> getUsers(){
        ArrayList<User> userlist = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USER",null);
        while (cursor.moveToNext())
        {
            User u = new User();
            u.Name = cursor.getString(0);
            u.Description = cursor.getString(1);
            u.Id = cursor.getInt(2);
            u.Followed = cursor.getString(3) == "true";
            userlist.add(u);
        }
        db.close();
        return userlist;
    }
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE User SET Followed = \""+ user.Followed +"\" " +  "WHERE Id = \""+ user.Id +"\"");
        db.close();
    }
}
