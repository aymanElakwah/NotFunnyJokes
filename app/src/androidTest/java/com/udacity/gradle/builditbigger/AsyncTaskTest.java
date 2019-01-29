package com.udacity.gradle.builditbigger;


import com.google.common.truth.Truth;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import androidx.test.filters.SmallTest;

@SmallTest
public class AsyncTaskTest implements ActionCompletedInterface {
    final CountDownLatch signal = new CountDownLatch(1);
    private String result = null;
    @Test
    public void verifyAsyncTaskResult() throws InterruptedException {
        new GetJokeTask(this).execute();
        signal.await(30, TimeUnit.SECONDS);
        Truth.assertThat(result).isNotEmpty();
    }

    @Override
    public void done(String string) {
        result = string;
        signal.countDown();
    }
}