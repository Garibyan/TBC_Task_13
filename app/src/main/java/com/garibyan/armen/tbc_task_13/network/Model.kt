package com.garibyan.armen.tbc_task_13.network

import com.squareup.moshi.Json

data class Model(
    val id: String,
    val projectId: String,
    val equipmentId: String,
    val status: String,
    val requestedBy: String,
    val acceptedBy: Any? = null,
    val author: String,
    val category: String,
    val locations: Location,
    val filters: List<Filters>,
    val type: String,
    val organization: String,
    val address: String,
    val startDate: String,
    val endDate: String,
    val description: Any? = null,
    val prolongDates: List<Any>,
    val releaseDates: List<Any>,
    val isDummy: Boolean,
    val hasDriver: Boolean,
    val overwriteDate: Any? = null,
    val metaInfo: Any? = null,
    val warehouseId: Any? = null,
    val rentalDescription: Any? = null,
    val internalTransportations: InternalTransportations,
    val startDateMilliseconds: Long,
    val endDateMilliseconds: Long,
    val equipment: Equipment,
) {
    data class Equipment(
        val id: String,
        val title: String,
        val invNumber: String,
        val categoryId: String,
        val modelId: String,
        val brandId: String,
        val year: Int,
        val specifications: List<Specification>,
        val weight: Int,
        @Json(name = "additional_specifications")
        val additionalSpecifications: Any? = null,
        val structureId: String,
        val organizationId: String,
        val beaconType: String? = null,
        val beaconId: String,
        val beaconVendor: String,
        @Json(name = "RFID")
        val rfid: String,
        val dailyPrice: Any? = null,
        val inactive: Any? = null,
        val tag: Tag,
        val telematicBox: Any? = null,
        val createdAt: Any,
        @Json(name = "special_number")
        val specialNumber: Any? = null,
        @Json(name = "last_check")
        val lastCheck: String,
        @Json(name = "next_check")
        val nextCheck: String,
        @Json(name = "responsible_person")
        val responsiblePerson: Any? = null,
        @Json(name = "test_type")
        val testType: Any? = null,
        @Json(name = "unique_equipment_id")
        val uniqueEquipmentId: String,
        @Json(name = "bgl_number")
        val bglNumber: String,
        @Json(name = "serial_number")
        val serialNumber: Any? = null,
        val inventory: Any? = null,
        val warehouseId: String,
        val trackingTag: Any? = null,
        @Json(name = "navaris_criteria")
        val navarisCriteria: Any? = null,
        @Json(name = "dont_send_to_as400")
        val dontSendToAs400: Boolean,
        val model: Model,
        val brand: Brand,
        val category: Category,
        val structure: Structure,
        val wareHouse: Any? = null,
        val equipmentMedia: List<EquipmentMedia>,
        val telematics: List<Telematics>,
        val isMoving: Boolean
    ) {
        data class Specification(
            val key: String,
            val value: Any
        )

        data class Telematics(
            val timestamp: Long,
            val eventType: String,
            val projectId: String,
            val equipmentId: String,
            val locationName: String,
            val location: equipmentLocation,
            val costCenter: String,
            val lastLatitude: Double,
            val lastLongitude: Double,
            val lastLatLonPrecise: Boolean,
            val lastAddressByLatLon: String
        )

        data class EquipmentMedia(
            val id: String,
            val name: String,
            val files: List<Files>,
            val type: String,
            val modelId: String,
            val main: Boolean,
            val modelType: String,
            val createdAt: String
        )

        data class Files(
            val size: String,
            val path: String
        )

        data class Structure(
            val id: String,
            val name: String,
            val type: String,
            val color: String
        )

        data class Category(
            val id: String,
            val name: String,
            @Json(name = "name_de")
            val nameDe: String,
            val createdAt: String,
            val media: List<Any>
        )

        data class Tag(
            val date: String,
            val authorName: String,
            val media: List<Any>,
        )

        data class Model(
            val id: String,
            val name: String,
            val createdAt: String,
            val brand: Brand,
        )

        data class Brand(
            val id: String,
            val name: String,
            val createdAt: String,
        )
    }

    data class InternalTransportations(
        val id: String,
        val projectRequestId: String,
        val pickUpDate: String,
        val deliveryDate: Any? = null,
        val status: String,
        val startDateOption: Any? = null,
        val endDateOption: Any? = null,
        val pickUpLocation: Location,
        val deliveryLocation: Location,
        val provider: String,
        val pickUpLocationAddress: String,
        val deliveryLocationAddress: String,
        val pGroup: String,
        val isOrganizedWithoutSam: Any? = null,
        val templatePGroup: String,
        val pickUpDateMilliseconds: Long,
        val deliveryDateMilliseconds: Long,
        val startDateOptionMilliseconds: Any? = null,
        val endDateOptionMilliseconds: Any? = null
    )

    data class equipmentLocation(
        val type: String,
        val coordinates: List<List<List<List<Double>>>>
    )

    data class Location(
        val type: String,
        val coordinates: List<Double>
    )

    data class Filters(
        val name: String,
        val value: Value
    )

    data class Value(
        val max: Int,
        val min: Int
    )
}
