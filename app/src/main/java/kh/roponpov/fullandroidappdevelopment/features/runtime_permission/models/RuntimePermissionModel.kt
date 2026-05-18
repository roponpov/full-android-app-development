package kh.roponpov.fullandroidappdevelopment.features.runtime_permission.models

import kh.roponpov.fullandroidappdevelopment.R

class RuntimePermissionModel(
    val title: String,
    val description: String,
    val iconRes: Int,
) {
    companion object {
        val runtimePermissions = listOf<RuntimePermissionModel>(
            RuntimePermissionModel(
                title = "Body Sensors",
                description = "Access body sensor data such as heart rate, blood oxygen, and other health-related information.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Body Sensors Background",
                description = "Allow access to body sensor data while the app is running in the background.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Calendar",
                description = "Read, create, edit, and delete calendar events from your device.",
                iconRes = R.drawable.ic_calendar_today,
            ),
            RuntimePermissionModel(
                title = "Call Logs",
                description = "Read and manage your device call history, including incoming and outgoing calls.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Camera",
                description = "Take photos, record videos, and scan QR or barcode using your device camera.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Contacts",
                description = "Access, create, and update contacts stored on your device.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Fine Location",
                description = "Access your precise location using GPS and location services.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Coarse Location",
                description = "Access your approximate location based on network and Wi-Fi information.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Background Location",
                description = "Allow the app to access your location even when the app is not in use.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Microphone",
                description = "Record audio and voice input using your device microphone.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Nearby Wi-Fi Devices",
                description = "Discover, connect, and communicate with nearby Wi-Fi enabled devices.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Nearby Bluetooth Devices",
                description = "Scan, connect, and communicate with nearby Bluetooth devices.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Notifications",
                description = "Send and manage push notifications and alerts on your device.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Phone",
                description = "Access phone state, manage calls, and retrieve device-related phone information.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Physical Activity",
                description = "Track physical activities such as walking, running, cycling, and step counting.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "SMS",
                description = "Read, send, receive, and manage SMS or MMS messages on your device.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Storage",
                description = "Read and manage files, documents, and media stored on your device.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Photos & Videos",
                description = "Access and manage photos and videos stored on your device.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Music & Audio",
                description = "Access and manage audio, music, and sound files stored on your device.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Manage External Storage",
                description = "Allow broad access to manage all files and folders on external storage.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Record Screen",
                description = "Capture and record your device screen activity and visual content.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Exact Alarm",
                description = "Schedule exact alarms and time-sensitive notifications on the device.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Install Unknown Apps",
                description = "Allow installation of applications from sources outside the Play Store.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
            RuntimePermissionModel(
                title = "Picture in Picture",
                description = "Display app content in a floating window while using other apps.",
                iconRes = R.drawable.ic_monitor_heart,
            ),
        )
    }
}