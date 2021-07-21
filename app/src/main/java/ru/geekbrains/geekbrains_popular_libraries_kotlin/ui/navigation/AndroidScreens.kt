package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubUser
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.UserRepository
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.navigation.IScreens
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment.RepositoryFragment
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment.UserFragment
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment.UsersFragment

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { UsersFragment.newInstance() }
    override fun user(githubUser: GithubUser) = FragmentScreen { UserFragment.newInstance(githubUser) }
    override fun repository(userRepository: UserRepository) = FragmentScreen { RepositoryFragment.newInstance(userRepository) }
}