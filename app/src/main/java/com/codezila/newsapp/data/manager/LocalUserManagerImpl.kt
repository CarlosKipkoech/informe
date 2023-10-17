package com.codezila.newsapp.data.manager

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.edit
import com.codezila.newsapp.domain.manager.LocalUserManager
import com.codezila.newsapp.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import com.codezila.newsapp.util.Constants
import kotlinx.coroutines.flow.map


class LocalUserManagerImpl(
    private val context: Context
): LocalUserManager {  //----> Implement data store preferences
    override suspend fun saveAppEntry() {
       context.datastore.edit { settings ->
           settings[PreferenceKeys.APP_ENTRY] = true

        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return  context.datastore.data.map { preferences->
            preferences[PreferenceKeys.APP_ENTRY] ?: false
        }
    }


}
//Initialize our datastore
private  val Context.datastore: DataStore <Preferences> by preferencesDataStore(name = USER_SETTINGS)

//This is where we store our key values (A schema-ish)
private  object PreferenceKeys{
val APP_ENTRY = booleanPreferencesKey(Constants.APP_ENTRY)
}