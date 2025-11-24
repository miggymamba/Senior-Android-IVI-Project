package com.miguelrivera.nexusstream.domain.model

/**
 * Represents the current, real-time status of the vehicle.
 * This is the core entity shared across all layers (Domain, Data, Presentation).
 *
 * @property speedKph The current speed in kilometers per hour.
 * @property rpm The current engine rotations per minute.
 * @property fuelLevelPercent The remaining fuel percentage (0-100).
 * @property pilotAssistStatus The current state of the automated driving system.
 */
data class VehicleState(
    val speedKph: Int,
    val rpm: Int,
    val fuelLevelPercent: Int,
    val pilotAssistStatus: PilotAssistStatus
)

/**
 * Enumeration for the state of the vehicle's automated driving system.
 * This enum ensures consistent state representation throughout the application.
 */
enum class PilotAssistStatus {
    ACTIVE,
    DISENGAGED,
    DRIVER_ATTENTION_REQUIRED
}