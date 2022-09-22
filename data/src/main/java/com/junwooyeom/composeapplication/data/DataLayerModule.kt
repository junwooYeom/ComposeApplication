package com.junwooyeom.composeapplication.data

import com.junwooyeom.composeapplication.domain.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * {description}
 *
 * @author capri
 * @since 2022/09/22
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataLayerModule {

    @Binds
    @Singleton
    abstract fun bindsRepository(impl: MovieRepositoryImpl): MovieRepository

    @Binds
    @Singleton
    abstract fun bindsLocalDataSource(impl: MovieLocalDataSourceImpl): MovieLocalDataSource

    @Binds
    @Singleton
    abstract fun bindsRemoteDataSource(impl: MovieRemoteDataSourceImpl): MovieRemoteDataSource
}