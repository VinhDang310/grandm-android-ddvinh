package ttcn.dinhvinh.apicoinkotlink


import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {

    @GET("api/v3/coins/markets?vs_currency=usd")
    fun getData(): Call<List<MyDataItem>>
}