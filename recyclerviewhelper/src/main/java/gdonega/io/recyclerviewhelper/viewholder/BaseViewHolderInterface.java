package gdonega.io.recyclerviewhelper.viewholder;

import android.view.View;

public interface BaseViewHolderInterface<Obj>{
    void manipulateCardView(View view);
    void setOnHolder(final Obj obj);
}