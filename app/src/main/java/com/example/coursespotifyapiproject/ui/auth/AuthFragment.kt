package com.example.coursespotifyapiproject.ui.auth

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.coursespotifyapiproject.R
import com.example.spotifysigninexample.SpotifyConstants
import kotlinx.android.synthetic.main.auth_fragment.view.*


class AuthFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.auth_fragment, container, false)

        view.spotify_login_btn.setOnClickListener {

            val stateRandomGenerated = (0..1000).random()
            SpotifyConstants.STATE = stateRandomGenerated.toString()

            val url = "https://accounts.spotify.com/authorize" +
                    "?client_id=" + SpotifyConstants.CLIENT_ID +
                    "&response_type=" + SpotifyConstants.RESPONSE_TYPE +
                    "&redirect_uri=" + SpotifyConstants.REDIRECT_URI +
                    "&state=" + SpotifyConstants.STATE +
                    "&scope=" +SpotifyConstants.SCOPES

            val act = Intent(Intent.ACTION_VIEW, Uri.parse(url))

            startActivity(act)

        }

        return view
    }
}



