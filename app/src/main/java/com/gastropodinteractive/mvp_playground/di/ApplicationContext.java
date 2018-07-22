package com.gastropodinteractive.mvp_playground.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Kei Lazu on 7/16/2018
 * check https://github.com/KeiLazu for more
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationContext {
}
