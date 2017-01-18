package com.ross.feehan.commentsdvldemoapp.Shared;

import com.ross.feehan.commentsdvldemoapp.Features.GetComments.GetCommentsDataImpl;
import com.ross.feehan.commentsdvldemoapp.Shared.SharedPreferences.CommentsSharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

/**
 * Created by Ross Feehan on 13/11/2015.
 * Copyright Ross Feehan
 */

@Module(injects = {GetCommentsDataImpl.class})
public class DataDITestModule {

    private CommentsSharedPreferences mockCommentsSP;

    public DataDITestModule(){
        mockCommentsSP = mock(CommentsSharedPreferences.class);
    }

    @Provides @Singleton
    public CommentsSharedPreferences provideMockCommentsSharedPreferences(){
        return mockCommentsSP;
    }
}
