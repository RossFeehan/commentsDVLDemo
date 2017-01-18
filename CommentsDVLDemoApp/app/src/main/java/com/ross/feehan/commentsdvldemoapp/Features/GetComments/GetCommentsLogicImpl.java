package com.ross.feehan.commentsdvldemoapp.Features.GetComments;

import com.ross.feehan.commentsdvldemoapp.DataTypes.Comment;
import com.ross.feehan.commentsdvldemoapp.Features.DisplayComments.DisplayCommentsViewInterface;

import java.util.List;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */
public class GetCommentsLogicImpl implements GetCommentsLogicInterface{

    private GetCommentsDataInterface getCommentsData;
    private DisplayCommentsViewInterface view;

    //CONSTRUCTOR
    public GetCommentsLogicImpl(GetCommentsDataInterface getComments, DisplayCommentsViewInterface view){
        this.getCommentsData = getComments;
        this.view = view;
    }

    //GETCOMMENTSLOGICINTERFACE METHODS
    /*Method that calls the data module to get the comments but also handles the logic for the view
     * such as telling the view to display a loading progress
     * @Params DisplayCommentsViewInterface view - The view that is listening to this class to be notified
     */
    @Override
    public void getComments() {
        this.view.displayLoadingProgress();
        getCommentsData.getComments(this);
    }

    /*Method that receives the comments from the data module
     *Also handles passing the data back to the view listener
     * and telling the listener to hide the loading bar on the view
     * @Params List<Comment> comments - The list of comments
     */
    @Override
    public void receiveComments(List<Comment> comments) {

        //if there are no comments call the noCommentsYet method on the view listener
        if(comments.size() == 0){
            view.noCommentsYet();
        }

        //if there are comments pass them back to the view
        else{
            view.displayComments(comments);
        }

        view.hideLoadingProgress();
    }

    /*Method to notify in case of fetching the comments went wrong
     *This class will send the message on further to the listener view class
     */
    @Override
    public void getCommentsFailed() {
        view.getCommentsFailed();
    }
}
