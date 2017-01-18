package com.ross.feehan.commentsdvldemoapp.Features.DeleteComments;

import com.ross.feehan.commentsdvldemoapp.Shared.SharedPreferences.CommentsSharedPreferences;

/**
 * Created by Ross Feehan on 09/11/2015.
 * Copyright Ross Feehan
 */
public class DeleteCommentDataImpl implements DeleteCommentDataInterface {

    private CommentsSharedPreferences commentSP;

    //Constructor
    public DeleteCommentDataImpl(CommentsSharedPreferences commentSP){
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
