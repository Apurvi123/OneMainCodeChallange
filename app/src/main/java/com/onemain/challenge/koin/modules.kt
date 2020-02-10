package com.onemain.challenge.koin

import com.onemain.challenge.data.DadJokeRetrofitService
import com.onemain.challenge.viewmodel.MainViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val modules = module {
    factory { DadJokeInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideDadJokeApi(get()) }
    single { provideRetrofit(get()) }

    viewModel {
        MainViewModel(
            dadJokeRetrofitService = get()
        )
    }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl("https://icanhazdadjoke.com/").client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create()).build()
}

fun provideOkHttpClient(dadJokeInterceptor: DadJokeInterceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(dadJokeInterceptor).build()
}

fun provideDadJokeApi(retrofit: Retrofit): DadJokeRetrofitService =
    retrofit.create(DadJokeRetrofitService::class.java)

class DadJokeInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request().newBuilder()
                .header("Accept", "application/json")
                .build()
        )
    }
}
