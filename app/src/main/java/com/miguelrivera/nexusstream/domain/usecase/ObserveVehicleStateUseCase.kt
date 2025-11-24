package com.miguelrivera.nexusstream.domain.usecase

import com.miguelrivera.nexusstream.domain.model.VehicleState
import com.miguelrivera.nexusstream.domain.repository.VehicleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * A Use Case that encapsulates the business logic of observing the current vehicle state.
 *
 * It is responsible for bridging the Presentation (ViewModel) and the Repository,
 * demonstrating Single Responsibility (S of SOLID).
 */
class ObserveVehicleStateUseCase @Inject constructor(
    private val repository: VehicleRepository
) {
    /**
     * Executes the business logic: retrieving the continuous stream of vehicle data.
     * @return A Flow of VehicleState objects, emitting updates as the vehicle telemetry changes.
     */
    operator fun invoke(): Flow<VehicleState> {
        return repository.getVehicleStateStream()
    }
}