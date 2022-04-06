package art.pum.webart102client

import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest

class GetPageSourceVM(lifecycleOwner: LifecycleOwner, context: Context) : ViewModel() {
    private val TAG = "GetPageSourceVM"
    private val ctx = context
    private val lifecycleOwner = lifecycleOwner

    private var _page : MutableLiveData<String> = MutableLiveData()
    val page
        get() = _page

    init {
        Log.i(TAG, "Created...")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "Cleared...")
    }


    fun getStrone() {
        val d1 = Data.Builder()
        d1.putString("URL", "https://ktel.wat.edu.pl/")
        var s : String = ""
        val pageWorker: WorkRequest =
            OneTimeWorkRequestBuilder<GetPage>()
                .setInputData(d1.build())
                .build()
        val workManager: WorkManager = WorkManager.getInstance(ctx)
        workManager.enqueue(pageWorker)

        workManager.getWorkInfoByIdLiveData(pageWorker.id)
            .observe(lifecycleOwner, Observer {
                if (it != null && it.state.isFinished) {
                    s = it.outputData.getString("RESULT")!!
                    Log.i(TAG,s)
                    _page.value = s
                }
            })
    }
}

class GetSourcePageVMFactory(private val lifecycleOwner: LifecycleOwner, private val context: Context?) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GetPageSourceVM::class.java)) {
            return context?.let { GetPageSourceVM(lifecycleOwner, it) } as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}