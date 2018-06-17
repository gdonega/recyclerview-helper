package gdonega.io.recyclerviewhelper.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import gdonega.io.recyclerviewhelper.RVManager;
import gdonega.io.recyclerviewhelper.viewholder.BaseViewHolder;

/**
 * Created by Gustavo Donegá Queiroz(gdonega).
 */
public class BaseAdapter extends RecyclerView.Adapter {
    private RVManager manager;

    public BaseAdapter(RVManager manager) {
        this.manager = manager;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RVAdapterSetter adapterSet = manager.getRvAdapterSet();

        Context context = adapterSet.getContext();
        if (context == null)
            context = parent.getContext();

        Integer id = adapterSet.getCardXmlId();

        ViewGroup root = adapterSet.getRoot();
        if (root == null)
            root = parent;

        Boolean attachToRoot = adapterSet.getAttachToRoot();
        if (attachToRoot == null)
            attachToRoot = false;

        View view = LayoutInflater.from(context).inflate(id, root, attachToRoot);

        BaseViewHolder baseViewHolder = null;
        Class<? extends BaseViewHolder> viewHolderClass = manager.getViewHolder();
        try {
            viewHolderClass = (Class<? extends BaseViewHolder>) Class.forName(manager.getViewHolder().toString().split(" ")[1]);
            Constructor<?> ctor = viewHolderClass.getConstructor(View.class);
            baseViewHolder = (BaseViewHolder) ctor.newInstance(view);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            Log.e("ok", "No such");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return baseViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BaseViewHolder viewHolder = (BaseViewHolder) holder;
        viewHolder.setOnHolder(manager.getList().get(position));
    }

    @Override
    public int getItemCount() {
        if (manager.getList() != null)
            return manager.getList().size();

        return 0;
    }
}
