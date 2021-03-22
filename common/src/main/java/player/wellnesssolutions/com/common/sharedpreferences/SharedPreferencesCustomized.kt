package player.wellnesssolutions.com.common.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import java.util.*
import kotlin.collections.HashSet

class SharedPreferencesCustomized constructor(context: Context, name: String) {
    private var preferences: SharedPreferences = context.applicationContext.getSharedPreferences(name, Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor

    init {
        editor = preferences.edit()
        editor.apply()
    }

    fun putString(key: String, value: String) = apply {
        editor.putString(key, value)
        save()
    }

    fun putStrings(key: String, value: Array<String>?) = apply {
       if (value.isNullOrEmpty()) return@apply
        val set = HashSet(listOf(*value))
        editor.putStringSet(key, set)
        save()
    }

    fun putInt(key: String, value: Int) = apply {
        editor.putInt(key, value)
        save()
    }

    fun putLong(key: String, value: Long) = apply {
        editor.putLong(key, value)
        save()
    }

    fun putFloat(key: String, value: Float) = apply {
        editor.putFloat(key, value)
        save()
    }

    fun putBoolean(key: String, value: Boolean) = apply {
        editor.putBoolean(key, value)
        save()
    }

    fun getString(key: String, defValue: String): String = preferences.getString(key, defValue)
            ?: defValue

    fun getStrings(key: String): Array<String>{
        val set = preferences.getStringSet(key, HashSet<String>()) as HashSet<String>
        val array = arrayOfNulls<String>(set.size)

       return set.toArray(array)
    }

    fun getInt(key: String, defValue: Int): Int = preferences.getInt(key, defValue)

    fun getLong(key: String, defValue: Long): Long = preferences.getLong(key, defValue)

    fun getFloat(key: String, defValue: Float): Float = preferences.getFloat(key, defValue)

    fun getBoolean(key: String, defValue: Boolean): Boolean = preferences.getBoolean(key, defValue)

    fun save() = apply { editor.apply() }

    fun delete(key: String) = apply {
        editor.remove(key)
        save()
    }

    fun clearAllCached() {
        editor.clear()
        save()
    }

    companion object {
        val DEF_NAME = "MoveMind"
        private var INSTANCE: SharedPreferencesCustomized? = null

        fun getInstance(context: Context): SharedPreferencesCustomized {
            if (INSTANCE == null) {
                INSTANCE = SharedPreferencesCustomized(context.applicationContext, DEF_NAME)
            }

            return INSTANCE!!
        }
    }
}
