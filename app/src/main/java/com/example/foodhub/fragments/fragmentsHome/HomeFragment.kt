package com.example.foodhub.fragments.fragmentsHome

import android.app.ActionBar
import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodhub.activities.HomeActivity
import com.example.foodhub.adapter.HomeAdapter
import com.example.foodhub.api.RetrofitClient
import com.example.foodhub.databinding.FragmentHomeBinding
import com.example.foodhub.models.Product
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.CarouselType
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(), SearchView.OnQueryTextListener {
    private val TAG = HomeFragment::class.java.simpleName

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    var actionBar: ActionBar? = null
    private lateinit var progressDialog: ProgressDialog

    private lateinit var mainActivity: HomeActivity
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressDialog = ProgressDialog(context)
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        progressDialog.setCancelable(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        mainActivity = activity as HomeActivity
        linearLayoutManager = LinearLayoutManager(context)
        binding.containerMain.recyclerView.layoutManager = linearLayoutManager
        obtainListMenu()
        binding.containerMain.searchView.setOnQueryTextListener(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Caarrusel */

        var carousel = binding.carousel

        carousel.carouselType = CarouselType.BLOCK
        carousel.scaleOnScroll = true
        carousel.scalingFactor = 0.5f


// If you want auto slide, turn this feature on.
        carousel.autoPlay = true
        carousel.autoPlayDelay = 3000

        var list = mutableListOf<CarouselItem>()

        list.add(
            CarouselItem(
                imageUrl = "https://scontent.fmad6-1.fna.fbcdn.net/v/t1.0-9/157299652_1066419703852968_1310339105705357669_n.jpg?_nc_cat=110&ccb=3&_nc_sid=730e14&_nc_ohc=6DTf-3Hikl4AX8Z4S-q&_nc_ht=scontent.fmad6-1.fna&oh=191b16f5ad43bc9e94c9299531271632&oe=60683FFA",

                )
        )

        // Just image URL
        list.add(
            CarouselItem(
                imageUrl = "https://scontent.fmad6-1.fna.fbcdn.net/v/t1.0-9/157738438_1066420527186219_2805972213559985891_n.jpg?_nc_cat=104&ccb=3&_nc_sid=730e14&_nc_ohc=y0udIUGKIzIAX96DftF&_nc_ht=scontent.fmad6-1.fna&oh=415e4511dee178d5f5151784b46d49d1&oe=6065FADB"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://scontent.fmad6-1.fna.fbcdn.net/v/t1.0-9/157056981_1066421660519439_1368035686240487011_n.jpg?_nc_cat=102&ccb=3&_nc_sid=730e14&_nc_ohc=ATtA1q4kGqsAX-g1KJi&_nc_ht=scontent.fmad6-1.fna&oh=1eaeff25a88f28a4f0612cbd78b6d258&oe=6068D490"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://scontent.fmad6-1.fna.fbcdn.net/v/t1.0-9/157836900_1066423933852545_7165577836039767383_n.jpg?_nc_cat=104&ccb=3&_nc_sid=730e14&_nc_ohc=YUtMxsrU-XMAX-qCf1i&_nc_ht=scontent.fmad6-1.fna&oh=2a502c7c4aced32843d4a5e8a017e9cf&oe=60692DFD"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://scontent.fmad6-1.fna.fbcdn.net/v/t1.0-9/157030628_1066424690519136_1185516196094132224_n.jpg?_nc_cat=107&ccb=3&_nc_sid=730e14&_nc_ohc=YnHbnSJoCKYAX8S594J&_nc_ht=scontent.fmad6-1.fna&oh=c21169ee6cf8147554ff19c7c8c61abd&oe=60696406"
            )
        )

        carousel.start()

        carousel.addData(list)
    }

    private fun obtainListMenu() {
        RetrofitClient.instanceMenu.listMenu()
            .enqueue(object : Callback<List<Product>> {
                override fun onResponse(
                    call: Call<List<Product>>,
                    response: Response<List<Product>>
                ) {
                    initProgressLoad(false, "")
                    if (response != null) {
                        Log.i(TAG, "response no es nulo " + response.body())
                        if (response.isSuccessful) {
                            Log.i(
                                TAG,
                                "response no es nulo y la conexion fue exitosa " + response.body()
                                    .toString()
                            )
                            val dataList: List<Product>
                            dataList = response.body()!!;
                            if (dataList.size > 0) {
                                homeAdapter = HomeAdapter(mainActivity, dataList)
                                binding.containerMain.recyclerView.adapter = homeAdapter
                            }

                        } else {
                            Log.i(
                                TAG,
                                "response no es nulo y la conexion no fue exitosa " + response.errorBody()
                                    .toString()
                            )

                            Toast.makeText(
                                context,
                                "Verifique sus credenciales al parecer no son correctas",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    } else {
                        Log.i(TAG, "response es nulo" + response.body())
                        Toast.makeText(
                            context,
                            "Verifique sus credenciales al parecer no son correctas",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                    Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
                    Log.i(TAG, "t: " + t.message + "casue " + t.cause)
                    initProgressLoad(false, "")
                }


            })
    }

    private fun initProgressLoad(shown: Boolean, message: String) {
        if (shown) {
            if (progressDialog != null) {
                if (progressDialog.isShowing) {
                    progressDialog.setMessage(message)
                } else {
                    progressDialog.setMessage(message)
                    progressDialog.show()
                }
            } else {
                progressDialog = ProgressDialog(context)
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
                progressDialog.setCancelable(false)
                progressDialog.setMessage(message)
                progressDialog.show()
            }
        } else {
            if (progressDialog != null)
                if (progressDialog.isShowing)
                    progressDialog.dismiss()
        }
    }

    override fun onQueryTextSubmit(p0: String): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        if (homeAdapter == null)
            homeAdapter = HomeAdapter(mainActivity)
        homeAdapter.filter(newText)
        return false
    }
}
