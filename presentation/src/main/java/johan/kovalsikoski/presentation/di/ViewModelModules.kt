package johan.kovalsikoski.presentation.di

import johan.kovalsikoski.presentation.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val mainActivityViewModel = module {
    viewModel { MainViewModel(get()) }
}

val viewModelModules = mainActivityViewModel