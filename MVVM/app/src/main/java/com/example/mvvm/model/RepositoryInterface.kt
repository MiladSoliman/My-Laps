package com.example.mvvm.model

import com.example.mvvm.database.LocalSource
import com.example.mvvm.network.RemoteSource

interface RepositoryInterface : LocalSource , RemoteSource {
}