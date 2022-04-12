package com.binar.networkingsample

import MainAdapter
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.binar.networkingsample.data.model.GetAllCarResponseItem
import com.binar.networkingsample.data.network.CarsApi
import com.binar.networkingsample.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        val view = binding.root
        return (view)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchAllData()
    }

    private fun fetchAllData() {
        CarsApi.instance.AllCar()
            .enqueue(object : retrofit2.Callback<List<GetAllCarResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllCarResponseItem>>,
                    response: Response<List<GetAllCarResponseItem>>
                ) {
                    val body = response.body()
                    val code = response.code()
                    if (code == 200) {
                        showList(body)
                    }
                }

                override fun onFailure(call: Call<List<GetAllCarResponseItem>>, t: Throwable) {
                    Log.d("halo","gagal")
                }

            })
    }

    private fun showList(data: List<GetAllCarResponseItem>?) {
        val adapter = MainAdapter(object : MainAdapter.OnClickListener {
            override fun onClickItem(data: GetAllCarResponseItem) {

            }
        })

        adapter.submitData(data)
        binding.userRecyclerView.adapter = adapter
    }
}