package com.anotherworld.swordsandmagic

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var v : View
    lateinit var start: FloatingActionButton
    lateinit var state: TextView
    lateinit var money: TextView
    lateinit var nickname_in_start: TextView
    var second: Int = 60
    var countD: CountDownTimer? = null
    val getterANDSetter: GetterANDSetter = GetterANDSetter()

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
        v = inflater.inflate(R.layout.fragment_second, container, false)
        start = v.findViewById(R.id.room_one_button)
        state = v.findViewById(R.id.state)
        money = v.findViewById(R.id.money)
        nickname_in_start = v.findViewById(R.id.nickname_in_start)
        start.setOnClickListener(this)
//        money.text = getterANDSetter.getMoney().toString()
//        nickname_in_start.text = getterANDSetter.getName()
        money.text = "0.0"
        nickname_in_start.text = "any"
        money_timer()
        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(v: View?) {
        getterANDSetter.setTemp(1)
    }
    fun money_timer(){
        lifecycleScope.launch {
            countD = object : CountDownTimer((second * 1000).toLong(), 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    second--
                    nickname_in_start.text = getterANDSetter.getName()
                    money.text = getterANDSetter.getMoney().toString()
                }

                override fun onFinish() {
                    getterANDSetter.setMoney((getterANDSetter.getMoney()+1.0))
                    money.text = getterANDSetter.getMoney().toString()
                    if (countD != null) {
                        second = 1
                        countD!!.start()
                    }
                }
            }
            if (countD != null) {
                second = 1
                countD!!.start()
            }
        }
    }
}