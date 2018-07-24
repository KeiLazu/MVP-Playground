package com.gastropodinteractive.mvp_playground.utils.rx;

import io.reactivex.Scheduler;

/**
 * Created by Kei Lazu on 7/25/2018
 * check https://github.com/KeiLazu for more
 */
public interface ISchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}
