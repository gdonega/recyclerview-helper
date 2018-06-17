package gdonega.io.recyclerviewhelper.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<Object> extends RecyclerView.ViewHolder implements BaseViewHolderInterface<Object> {

    private View cardView;


    public BaseViewHolder(View itemView) {
        super(itemView);
        this.cardView = itemView;
        manipulateCardView(itemView);
    }

    public View getCardView() {
        return cardView;
    }
}