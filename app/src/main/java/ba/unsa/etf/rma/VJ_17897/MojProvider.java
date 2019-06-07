package ba.unsa.etf.rma.VJ_17897;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class MojProvider extends ContentProvider {
    private static final int ALLROWS = 1;
    private static final int ONEROW = 2;
    private static final UriMatcher uM;

    static{
        uM = new UriMatcher(UriMatcher.NO_MATCH);
        uM.addURI("rma.provider.muzicari","elements", ALLROWS);
        uM.addURI("rma.provider.muzicari","elements/#", ONEROW);
    }

    MuzicarDBOOpenHelper mHelper;

    @Override
    public boolean onCreate(){
        mHelper = new MuzicarDBOOpenHelper(getContext(), MuzicarDBOOpenHelper.DATABASE_NAME, null, MuzicarDBOOpenHelper.DATABASE_VERSION);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArg, @Nullable String sortOrder){
        SQLiteDatabase baza;
        try{
            baza = mHelper.getWritableDatabase();
        }catch (SQLException e){
            baza = mHelper.getReadableDatabase();
        }
        String groupby = null;
        String having = null;
        SQLiteQueryBuilder squery = new SQLiteQueryBuilder();

        switch (uM.match(uri)){
            case ONEROW:
                String IDReda = uri.getPathSegments().get(1);
                squery.appendWhere(MuzicarDBOOpenHelper.MUZICAR_ID+"="+IDReda);
                default:break;
        }
        squery.setTables(MuzicarDBOOpenHelper.DATABASE_TABLE);
        Cursor cursor = squery.query(baza, projection, selection, selectionArg, groupby, having, sortOrder);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri){
        switch (uM.match(uri)){
            case ALLROWS:
                return "vnd.android.cursor.dir/vnd.rma.elemental";
            case ONEROW:
                return "vnd.android.cursor.item/vnd.rma.elemental";
            default:
                throw new IllegalArgumentException("Unsupported uri: "+uri.toString());
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues){
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings){
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings){
        return 0;
    }
}
