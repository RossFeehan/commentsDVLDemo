package com.ross.feehan.commentsdvldemoapp.Data.DataImplementations;

import android.os.Handler;

import com.ross.feehan.commentsdvldemoapp.Data.DataInterfaces.DeleteCommentInterface;
import com.ross.feehan.commentsdvldemoapp.Data.SharedPreferences.CommentsSharedPreferences;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.DeleteCommentLogicInterface;

/**
 * Created by Ross Feehan on 09/11/2015.
 * Copyright Ross Feehan
 */
public class DeleteCommentImpl implements DeleteCommentInterface {

    private CommentsSharedPreferences commentSP;

    //Constructor
    public DeleteCommentImpl(CommentsSharedPreferences commentSP){
        this.commentSP = commentSP;
    }

    /*Method that handles deleting a comment from shared preferences
     *@Params int commentPosition - The position of the comment to be deleted
     * @Params DeleteCommentLogicInterface deleteCommentListener - The class to notify when the comment has
     * been deleted
     */
    @Override
    public void deleteComment(int commentPosition, DeleteCommentLogicInterface deleteCommentListener) {
        boolean deleted = commentSP.deleteComment(commentPosition);
        deleteCommentListener.commentDeleted(deleted);
    }
}
