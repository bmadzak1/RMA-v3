package ba.unsa.etf.rma.VJ_17897;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.widget.SimpleCursorAdapter;

public class MuzicarLoaderCB implements LoaderManager.LoaderCallbacks<Cursor> {

    public final static int LOADER1_ID = 1;
    Context cont;
    SimpleCursorAdapter scAdapter;
    Uri mUri = Uri.parse("content://rma.provider.muzicari/elements");
    String[] PROJECTION = new String[]{
            MuzicarDBOOpenHelper.MUZICAR_ID,
            MuzicarDBOOpenHelper.MUZICAR_IME,
            MuzicarDBOOpenHelper.MUZICAR_ZANR
    };

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int i, @Nullable Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor cursor) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {

    }
}
