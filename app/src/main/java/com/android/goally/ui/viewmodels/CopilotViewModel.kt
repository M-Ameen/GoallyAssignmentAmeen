package com.android.goally.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.goally.data.model.api.response.copilot.Copilot
import com.android.goally.data.repo.CopilotRepository
import com.android.goally.util.LogUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CopilotViewModel @Inject constructor(
    private val copilotRepository: CopilotRepository
) : ViewModel() {
    private val _copilot = MutableLiveData<Copilot>()
    val copilot: LiveData<Copilot> get() = _copilot

    fun fetchCopilots(name: String) {
        viewModelScope.launch {
            try {
                val token = copilotRepository.fetchToken(name)
                Log.d("CopilotViewModel", "token: $token")
                val copilots =
                    copilotRepository.fetchCopilots(token.token.toString())
                Log.d("CopilotViewModel", "fetchCopilots: $copilots")
                _copilot.postValue(copilots)

            } catch (e: Exception) {
                LogUtil.e("Error fetching copilots: ${e.message}")
            }
        }
    }
}
