package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.databinding.FragmentRepositoryBinding
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.UserRepository
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.RepositoryPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.RepositoryView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.App
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.BackButtonListener

class RepositoryFragment : MvpAppCompatFragment(), RepositoryView, BackButtonListener {

    companion object {
        private const val REPO_ARG = "repo"

        fun newInstance(repository: UserRepository) = RepositoryFragment().apply {
            arguments = Bundle().apply {
                putParcelable(REPO_ARG, repository)
            }
        }
    }

    val presenter: RepositoryPresenter by moxyPresenter {
        val repository = arguments?.getParcelable<UserRepository>(REPO_ARG) as UserRepository
        RepositoryPresenter(repository, App.instance.router)
    }

    private var vb: FragmentRepositoryBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentRepositoryBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun fillFields(repo: UserRepository) {
        vb?.apply {
            tvRepoName.text = repo.name
            tvDescription.text = "Description: ${repo.description}"
            tvCreatedAt.text = "Created At: ${repo.createdAt}"
            tvUpdatedAt.text = "Updated At: ${repo.updatedAt}"
            tvPushedAt.text = "Pushed At: ${repo.pushedAt}"
            tvForksCount.text = "Forks: ${repo.forks}"
            tvLanguage.text = "Language: ${repo.language}"
            tvWatchers.text = "Watchers: ${repo.watchers}"
            tvOpenIssuesCount.text = "Open Issues Count: ${repo.openIssuesCount}"
        }
    }

    override fun backPressed() = presenter.backPressed()

}