package com.ross.feehan.commentsdvldemoapp.Features.DisplayComments;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.ross.feehan.commentsdvldemoapp.Features.DisplayComments.RecyclerViewItemTouchCallbackInterface;

/**
 * Created by Ross Feehan on 09/11/2015.
 * Copyright Ross Feehan
 * A class that registers the touch on a recycler view and notifies the adapter of that class
 * The touches that can be registered are drag and drop, swipe to dismiss
 */
public class RecyclerViewItemTouchCallback extends ItemTouchHelper.Callback{

    private RecyclerViewItemTouchCallbackInterface recyclerViewInterfaceCallback;
    static final float ALPHA_FULL = 1.0f;

    public RecyclerViewItemTouchCallback(RecyclerViewItemTouchCallbackInterface recyclerViewInterfaceCallback){
        this.recyclerViewInterfaceCallback = recyclerViewInterfaceCallback;
    }

    //ItemTouchHelper.Callback METHODS
    /*Enables enable drag and drop if true
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return false;
    }

    /*Enables swipe to dismiss if true
     */
    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    /*Method that sets up the movement flags for drag & drop and swipe to dismiss
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    /*Method to handle what will happen when the touch event for drag & drop is detected
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

        return true;
    }

    /*Method to handle what will happen when the touch event for swipe  is detected
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        recyclerViewInterfaceCallback.onItemDismiss(viewHolder.getAdapterPosition());
    }


}
