package com.ross.feehan.commentsdvldemoapp.Logic.LogicImplementations;

import com.ross.feehan.commentsdvldemoapp.Data.DataInterfaces.GetCommentsInterface;
import com.ross.feehan.commentsdvldemoapp.Data.Objects.Comment;
import com.ross.feehan.commentsdvldemoapp.Logic.LogicInterfaces.GetCommentsLogicInterface;
import com.ross.feehan.commentsdvldemoapp.View.ViewInterfaces.DisplayCommentsViewInterface;

import java.util.List;

/**
 * Created by Ross Feehan on 04/11/2015.
 * Copyright Ross Feehan
 */
public class GetCommentsLogicImpl implements GetCommentsLogicInterface{

    private GetCommentsInterface getComments;
    private DisplayCommentsViewInterface displayCommentsView;

    //CONSTRUCTOR
    public GetCommentsLogicImpl(GetCommentsInterface getComments){
        this.getComments = getComments;
    }

    //GETCOMMENTSLOGICINTERFACE METHODS

    /*Method that calls the data module to get the comments but also handles the logic for the view
     * such as telling the view to display a loading progress
     * @Params DisplayCommentsViewInterface displayCommentsView - The view that is listening to this class to be notified
     */
    @Override
    public void getComments(DisplayCommentsViewInterface displayCommentsView) {

        this.displayCommentsView = displayCommentsView;

        this.displayCommentsView.displayLoadingProgress();
        getComments.getComments(this);
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
            displayCommentsView.noCommentsYet();
        }

        //if there are comments pass them back to the view
        else{
            displayCommentsView.displayComments(comments);
        }

        displayCommentsView.hideLoadingProgress();
    }

    /*Method to notify in case of fetching the comments went wrong
     *This class will send the message on further to the listener view class
     */
    @Override
    public void getCommentsFailed() {
        displayCommentsView.getCommentsFailed();
    }
}
