package com.medieverone.domain.usecase

import androidx.lifecycle.LiveData
import com.medieverone.domain.entities.PlanetEntity

interface PlanetUseCase {

    suspend fun getPlanets(): LiveData<PlanetEntity>

    suspend fun getPlanet(id: String): LiveData<PlanetEntity>
}