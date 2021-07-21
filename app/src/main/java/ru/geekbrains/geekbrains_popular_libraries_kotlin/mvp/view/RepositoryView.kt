package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.UserRepository

@StateStrategyType(AddToEndSingleStrategy::class)
interface RepositoryView : MvpView {
    fun fillFields(repo: UserRepository)
}
