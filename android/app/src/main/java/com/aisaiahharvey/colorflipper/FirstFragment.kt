package com.aisaiahharvey.colorflipper

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.aisaiahharvey.colorflipper.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

private var _binding: FragmentFirstBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      _binding = FragmentFirstBinding.inflate(inflater, container, false)
      return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            var color = Rgb(randomRgb())
            view.setBackgroundColor(Color.rgb(color.red, color.green, color.blue))
            Rgb.destroyStruct(color.ptr)
        }
    }

    /**
     * A native method that is implemented by the 'libcolor_flipper' native library,
     * which is packaged with this application.
     */
    external fun randomRgb(): Long

    companion object {
        // Used to load the 'color_flipper' library on application startup.
        init {
            System.loadLibrary("color_flipper")
        }
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}