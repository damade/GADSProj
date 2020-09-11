package com.example.gadsproj.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gadsproj.Adapters.HourAdapter
import com.example.gadsproj.Api.ApiClient
import com.example.gadsproj.Api.ApiInterface
import com.example.gadsproj.DataClass.HourResponse
import com.example.gadsproj.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentLeaders.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentLeaders : Fragment() {

    var recyclerView: RecyclerView? = null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_leaders, container, false)

        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.hour_recycler_view)

        val requestHour = ApiClient.buildService(ApiInterface::class.java)
        val callHour = requestHour.getHourLeaders()

        callHour.enqueue(object : Callback<HourResponse> {
            override fun onResponse(call: Call<HourResponse>, response: Response<HourResponse>) {
                if (response.isSuccessful) {
                    recyclerView?.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity)
                        adapter = HourAdapter(response.body()!!.results)
                    }
                }
            }

            override fun onFailure(call: Call<HourResponse>, t: Throwable) {
                Toast.makeText(activity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentLeaders.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
                /*fun newInstance(param1: String, param2: String) =
                     FragmentLeaders().apply {
                         arguments = Bundle().apply {
                             putString(ARG_PARAM1, param1)
                             putString(ARG_PARAM2, param2)
                         }
                     }*/
        fun newInstance() =
            FragmentLeaders()
    }
}

private fun <T> Call<T>.enqueue(any: Any) {

}
