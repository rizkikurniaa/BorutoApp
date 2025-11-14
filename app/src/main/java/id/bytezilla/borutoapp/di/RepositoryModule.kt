package id.bytezilla.borutoapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.bytezilla.borutoapp.data.repository.DataStoreOperationsImpl
import id.bytezilla.borutoapp.domain.repository.DataStoreOperations
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

//    @Provides
//    @Singleton
//    fun provideUseCases(repository: Repository): UseCases {
//        return UseCases(
//            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
//            readOnBoardingUseCase = ReadOnBoardingUseCase(repository)
//        )
//    }

}