package com.getgoally.learnerapp.di

import com.android.goally.data.db.AppDatabase
import com.android.goally.data.db.dao.GeneralDao
import com.android.goally.data.network.rest.api.CopilotApi
import com.android.goally.data.network.rest.api.GeneralApi
import com.android.goally.data.repo.CopilotRepository
import com.android.goally.data.repo.GeneralRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideGeneralRepo(
        authenticationApi: GeneralApi, authenticationDao: GeneralDao
    ): GeneralRepo {
        return GeneralRepo(
            authenticationApi,
            authenticationDao
        )
    }

    @Provides
    @Singleton
    fun provideCopilotRepository(
        copilotApi: CopilotApi,
    ): CopilotRepository {
        return CopilotRepository(copilotApi)
    }

    /*@Singleton
    @Provides
    fun provideRoutineDao(appDatabase: AppDatabase): RoutineDao {
        return appDatabase.getRoutineDao() // Provides RoutineDao from the AppDatabase
    }*/

}
