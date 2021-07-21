package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo

import io.reactivex.rxjava3.core.Single
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.UserRepository

interface IUserRepositoriesRepo {
    fun getRepositories(url: String): Single<List<UserRepository>>
}