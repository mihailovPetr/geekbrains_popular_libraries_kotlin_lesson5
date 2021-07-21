package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.UserRepository
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.RepositoryView

class RepositoryPresenter(private val repository: UserRepository, private val router: Router) :
    MvpPresenter<RepositoryView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.fillFields(repository)
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}
