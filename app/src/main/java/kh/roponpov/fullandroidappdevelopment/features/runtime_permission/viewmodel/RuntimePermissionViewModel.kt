package kh.roponpov.fullandroidappdevelopment.features.runtime_permission.viewmodel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RuntimePermissionViewModel : ViewModel() {
    var selectedIndexTab by mutableIntStateOf(0)
        private set

    fun changeTabIndex(index: Int) {
        selectedIndexTab = index
    }
}