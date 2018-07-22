package com.gastropodinteractive.mvp_playground.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Kei Lazu on 7/16/2018
 * check https://github.com/KeiLazu for more
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
