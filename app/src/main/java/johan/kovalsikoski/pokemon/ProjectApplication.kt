package johan.kovalsikoski.pokemon

import android.app.Application
import johan.kovalsikoski.data.di.dataModules
import johan.kovalsikoski.presentation.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ProjectApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
//            androidLogger()
            androidContext(this@ProjectApplication)
            modules(dataModules +
                viewModelModules)
        }
    }

}