package ttcn.dinhvinh.apicoinkotlink

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cardview.view.*

class MyAdapter(val context: Context, val userList : List<MyDataItem>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

        var image:ImageView
        var symbol: TextView
        var name: TextView
        var current_price: TextView
        var market_cap_rank: TextView
        var last_updated: TextView

        init {
            image=itemView.image
            symbol=itemView.symbol
            name = itemView.name
            current_price=itemView.current_price
            market_cap_rank= itemView.market_cap_rank
            last_updated=itemView.last_updated


        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.cardview,parent,false)
        return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = userList[position].name.toString()
        holder.symbol.text = userList[position].symbol.toString()
        holder.last_updated.text = userList[position].last_updated.toString()
        holder.market_cap_rank.text = userList[position].market_cap_rank.toString()
        holder.current_price.text = userList[position].current_price.toString()
        Picasso.get().load(userList[position].image).into(holder.image)



    }

    override fun getItemCount(): Int {
        return  userList.size
    }
}
