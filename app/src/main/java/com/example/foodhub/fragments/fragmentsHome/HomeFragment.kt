package com.example.foodhub.fragments.fragmentsHome


import android.app.ActionBar
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.foodhub.R
import com.example.foodhub.activities.HomeActivity
import com.example.foodhub.activities.MainActivity
import com.example.foodhub.databinding.FragmentHomeBinding
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.CarouselType


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    var actionBar: ActionBar? = null

    lateinit var mainActivity: MainActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        return view

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


}