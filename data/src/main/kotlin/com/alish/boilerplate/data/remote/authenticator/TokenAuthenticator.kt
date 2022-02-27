package com.alish.boilerplate.data.remote.authenticator

import androidx.lifecycle.MutableLiveData
import com.alish.boilerplate.data.remote.apiservices.AuthenticatorApiService
import com.alish.boilerplate.data.remote.dtos.tokens.RefreshToken
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val service: AuthenticatorApiService,
    private val tokenErrorListener: MutableLiveData<String>
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        synchronized(this) {
            val refreshToken = service.refreshToken(RefreshToken("<refresh_token>")).execute()

            return when {
                refreshToken.isSuccessful -> {
                    // save token to preferences

                    response
                        .request
                        .newBuilder()
                        .header("Authorization", "Bearer <new_access_token>")
                        .build()
                }
                refreshToken.code() == 403 -> {
                    tokenErrorListener.postValue("Error")
                    null
                }
                else -> {
                    null
                }
            }
        }
    }
}