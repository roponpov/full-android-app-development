package kh.roponpov.fullandroidappdevelopment.features.runtime_permission.models

import android.Manifest
import kh.roponpov.fullandroidappdevelopment.R

class RuntimePermissionModel(
    val id: Int,
    val groupPermissionTitle: String,
    val permissions: List<PermissionModel>,
) {

    companion object {
        val runtimePermissions = listOf(

            // Location Permissions
            RuntimePermissionModel(
                id = 1,
                groupPermissionTitle = "Location",
                permissions = listOf(
                    PermissionModel(
                        title = "Fine Location",
                        description = "Access your precise location using GPS and location services.",
                        permission = Manifest.permission.ACCESS_FINE_LOCATION,
                        iconRes = R.drawable.ic_location_searching,
                    ),
                    PermissionModel(
                        title = "Coarse Location",
                        description = "Access your approximate location based on network and Wi-Fi information.",
                        permission = Manifest.permission.ACCESS_COARSE_LOCATION,
                        iconRes = R.drawable.ic_add_location,
                    ),
                    PermissionModel(
                        title = "Background Location",
                        description = "Allow the app to access your location even when the app is not in use.",
                        permission = Manifest.permission.ACCESS_BACKGROUND_LOCATION,
                        iconRes = R.drawable.ic_globe_location,
                    ),
                )
            ),

            // Media Permissions
            RuntimePermissionModel(
                id = 2,
                groupPermissionTitle = "Media",
                permissions = listOf(
                    PermissionModel(
                        title = "Photos & Videos",
                        description = "Access and manage photos and videos stored on your device.",
                        permission = Manifest.permission.READ_MEDIA_IMAGES,
                        iconRes = R.drawable.ic_photo,
                    ),
                    PermissionModel(
                        title = "Music & Audio",
                        description = "Access and manage audio, music, and sound files stored on your device.",
                        permission = Manifest.permission.READ_MEDIA_AUDIO,
                        iconRes = R.drawable.ic_library_music,
                    ),
                )
            ),

            // Communication Permissions
            RuntimePermissionModel(
                id = 3,
                groupPermissionTitle = "Communication",
                permissions = listOf(
                    PermissionModel(
                        title = "Contacts",
                        description = "Access, create, and update contacts stored on your device.",
                        permission = Manifest.permission.READ_CONTACTS,
                        iconRes = R.drawable.ic_contacts,
                    ),
                    PermissionModel(
                        title = "Phone",
                        description = "Access phone state and retrieve device phone information.",
                        permission = Manifest.permission.READ_PHONE_STATE,
                        iconRes = R.drawable.ic_contact_phone,
                    ),
                    PermissionModel(
                        title = "Call Logs",
                        description = "Read and manage your device call history.",
                        permission = Manifest.permission.READ_CALL_LOG,
                        iconRes = R.drawable.ic_call_log,
                    ),
                    PermissionModel(
                        title = "SMS",
                        description = "Read SMS and MMS messages on your device.",
                        permission = Manifest.permission.READ_SMS,
                        iconRes = R.drawable.ic_sms,
                    ),
                )
            ),

            // Camera & Audio Permissions
            RuntimePermissionModel(
                id = 4,
                groupPermissionTitle = "Camera & Audio",
                permissions = listOf(
                    PermissionModel(
                        title = "Camera",
                        description = "Take photos, record videos, and scan QR codes.",
                        permission = Manifest.permission.CAMERA,
                        iconRes = R.drawable.ic_photo_camera,
                    ),
                    PermissionModel(
                        title = "Microphone",
                        description = "Record audio and voice input using your microphone.",
                        permission = Manifest.permission.RECORD_AUDIO,
                        iconRes = R.drawable.ic_microphone,
                    ),
                )
            ),

            // Health & Fitness Permissions
            RuntimePermissionModel(
                id = 5,
                groupPermissionTitle = "Health & Fitness",
                permissions = listOf(
                    PermissionModel(
                        title = "Body Sensors",
                        description = "Access body sensor data such as heart rate.",
                        permission = Manifest.permission.BODY_SENSORS,
                        iconRes = R.drawable.ic_monitor_heart,
                    ),
                    PermissionModel(
                        title = "Body Sensors Background",
                        description = "Access body sensor data while app runs in background.",
                        permission = Manifest.permission.BODY_SENSORS_BACKGROUND,
                        iconRes = R.drawable.ic_monitor_heart,
                    ),
                    PermissionModel(
                        title = "Physical Activity",
                        description = "Track walking, running, cycling, and step counting.",
                        permission = Manifest.permission.ACTIVITY_RECOGNITION,
                        iconRes = R.drawable.ic_physical,
                    ),
                )
            ),

            // Connectivity Permissions
            RuntimePermissionModel(
                id = 6,
                groupPermissionTitle = "Connectivity",
                permissions = listOf(
                    PermissionModel(
                        title = "Nearby Wi-Fi Devices",
                        description = "Discover and connect to nearby Wi-Fi devices.",
                        permission = Manifest.permission.NEARBY_WIFI_DEVICES,
                        iconRes = R.drawable.ic_nearby_wifi,
                    ),
                    PermissionModel(
                        title = "Bluetooth Connect",
                        description = "Connect and communicate with Bluetooth devices.",
                        permission = Manifest.permission.BLUETOOTH_CONNECT,
                        iconRes = R.drawable.ic_nearby_bluetooth,
                    ),
                    PermissionModel(
                        title = "Bluetooth Scan",
                        description = "Scan nearby Bluetooth devices.",
                        permission = Manifest.permission.BLUETOOTH_SCAN,
                        iconRes = R.drawable.ic_nearby_bluetooth,
                    ),
                )
            ),

            // Notification Permissions
            RuntimePermissionModel(
                id = 7,
                groupPermissionTitle = "Notifications",
                permissions = listOf(
                    PermissionModel(
                        title = "Notifications",
                        description = "Send and manage notifications on your device.",
                        permission = Manifest.permission.POST_NOTIFICATIONS,
                        iconRes = R.drawable.ic_notification,
                    ),
                )
            ),

            // Calendar Permissions
            RuntimePermissionModel(
                id = 8,
                groupPermissionTitle = "Calendar",
                permissions = listOf(
                    PermissionModel(
                        title = "Calendar",
                        description = "Read and manage calendar events.",
                        permission = Manifest.permission.READ_CALENDAR,
                        iconRes = R.drawable.ic_calendar_today,
                    ),
                )
            ),
        )
    }
}