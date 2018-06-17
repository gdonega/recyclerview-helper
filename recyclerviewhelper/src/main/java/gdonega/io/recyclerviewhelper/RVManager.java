package gdonega.io.recyclerviewhelper;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;

import java.util.List;

import gdonega.io.recyclerviewhelper.adapter.BaseAdapter;
import gdonega.io.recyclerviewhelper.adapter.RVAdapterSetter;
import gdonega.io.recyclerviewhelper.viewholder.BaseViewHolder;

/**
 * Created by Gustavo Donegá Queiroz(gdonega).
 */
public class RVManager<Obj> {

    private LayoutManager layoutManager;
    private Adapter adapter;
    private RecyclerView recyclerView;
    private Class<? extends BaseViewHolder> viewHolder;
    private RVAdapterSetter rvAdapterSet;
    private List<Obj> list;


    public RVManager() {
        rvAdapterSet = new RVAdapterSetter(this);
        adapter = new BaseAdapter(this);
    }

    public void build() {
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public RVAdapterSetter getRvAdapterSet() {
        return rvAdapterSet;
    }

    public RVManager setViewHolderClass(Class<? extends BaseViewHolder> viewHolder) {

        this.viewHolder = viewHolder;
        return this;
    }

    public Class<? extends BaseViewHolder> getViewHolder() {
        return viewHolder;
    }

    public RVManager setList(List<Obj> list) {
        this.list = list;
        return this;
    }

    public List<Obj> getList() {
        return list;
    }

    public RVManager setLayoutManager(LayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        return this;
    }

    public RVManager createBaseGridLayoutManager(Context context, int spanCountPortrait, int spanCountLandscape) {
        int orientacao = context.getResources().getConfiguration().orientation;
        if (orientacao == Configuration.ORIENTATION_PORTRAIT) {
            layoutManager = new GridLayoutManager(context, 2);
        } else {
            layoutManager = new GridLayoutManager(context, 2);
        }
        return this;
    }

    public RVManager setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        return this;
    }

    public void notificarQualquerMudanca() {
        getAdapter().notifyDataSetChanged();
    }

    public LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public Adapter getAdapter() {
        return adapter;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }


}
