package ttcn.dinhvinh.apicoinkotlink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://api.coingecko.com/"
class MainActivity : AppCompatActivity() {
    lateinit var myAdapter: MyAdapter
    lateinit var  linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Recycler_view.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        Recycler_view.layoutManager = linearLayoutManager

        getMyData()

    }
    private fun getMyData(){
        val retrofitBuilder = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(APIInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataItem>> {
            override fun onResponse(
                    call: Call<List<MyDataItem>>?,
                    response: Response<List<MyDataItem>>?
            ) {
                val responseBody = response?.body()!!
                myAdapter= MyAdapter(baseContext,responseBody)
                myAdapter.notifyDataSetChanged()
                Recycler_view.adapter = myAdapter

            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.d("MainActivity", "onFailuer: " + t.message)
            }

        })
    }
}
