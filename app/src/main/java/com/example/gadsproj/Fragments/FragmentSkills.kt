package com.example.gadsproj.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gadsproj.Adapters.SkilliqAdapter
import com.example.gadsproj.Api.ApiClient
import com.example.gadsproj.Api.ApiInterface
import com.example.gadsproj.DataClass.SkillIqResponse
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
 * Use the [FragmentSkills.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentSkills : Fragment() {



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

        val view = inflater.inflate(R.layout.fragment_skills, container, false)

        var recyclerView: RecyclerView? = null

        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.skill_recycler_view)

        val request = ApiClient.buildService(ApiInterface::class.java)
        val call = request.getSkillLeaders()


        call.enqueue(object : Callback<SkillIqResponse> {
            override fun onResponse(
                call: Call<SkillIqResponse>,
                response: Response<SkillIqResponse>
            ) {
                if (response.isSuccessful) {
                    recyclerView?.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(activity)
                        adapter = response.body()!!.results?.let { SkilliqAdapter(it) }
                    }
                }
            }

            override fun onFailure(call: Call<SkillIqResponse>, t: Throwable) {
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
         * @return A new instance of fragment FragmentSkills.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
                /*fun newInstance(param1: String, param2: String) =
                    FragmentSkills().apply {
                        arguments = Bundle().apply {
                            putString(ARG_PARAM1, param1)
                            putString(ARG_PARAM2, param2)
                        }
                    }*/
        fun newInstance() =
            FragmentSkills()
    }
}
