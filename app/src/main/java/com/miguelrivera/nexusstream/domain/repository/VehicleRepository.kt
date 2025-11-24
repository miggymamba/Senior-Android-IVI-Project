package com.miguelrivera.nexusstream.domain.repository

import com.miguelrivera.nexusstream.domain.model.VehicleState
import kotlinx.coroutines.flow.Flow

/**
 * P2: Domain Layer Interface (Contract)
 *
 * This defines the contract for accessing vehicle data. The Domain Layer (P2)
 * only cares that it gets a continuous stream (Flow) of VehicleState objects;
 * it does not care if the data comes from a local cache, a network socket,
 * or a fake simulator.
 *
 * The Data Layer (P3) is responsible for implementing this interface.
 */
interface VehicleRepository {
    /**
     * Provides a continuous, reactive stream of the current vehicle state.
     *
     * @return A Kotlin Flow emitting VehicleState objects.
     */
    fun getVehicleStateStream(): Flow<VehicleState>
}