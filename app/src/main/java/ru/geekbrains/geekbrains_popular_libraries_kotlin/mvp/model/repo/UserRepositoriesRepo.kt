package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.api.IDataSource
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.UserRepository

class UserRepositoriesRepo(private val api: IDataSource) : IUserRepositoriesRepo {

    override fun getRepositories(url: String): Single<List<UserRepository>> =
        api.getUserRepositories(url).subscribeOn(Schedulers.io())
}