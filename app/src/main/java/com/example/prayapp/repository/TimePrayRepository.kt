



import com.example.prayapp.data.PrayData
import com.example.prayapp.network.Client
import com.example.prayapp.ui.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


object TimePrayRepository {


    fun getInfoPray(city: String)=
        flow<Status<PrayData>>{
            emit(Status.Loading)
            emit(Client.initRequest(city))
        }.flowOn(Dispatchers.IO)
    }



