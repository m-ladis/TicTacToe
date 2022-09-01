package hr.stroeer.tictactoe

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import hr.stroeer.tictactoe.databinding.FragmentGameFieldBinding

class GameFieldFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentGameFieldBinding? = null
    private val binding get() = _binding!!

    private var playerType: TicTac = TicTac.TIC

    private enum class TicTac {
        TIC, TAC
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGameFieldBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.a0.setOnClickListener(this)
        binding.a1.setOnClickListener(this)
        binding.a2.setOnClickListener(this)
        binding.b0.setOnClickListener(this)
        binding.b1.setOnClickListener(this)
        binding.b2.setOnClickListener(this)
        binding.c0.setOnClickListener(this)
        binding.c1.setOnClickListener(this)
        binding.c2.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.a0 -> {
                binding.a0.setImageDrawable(getPlayerIcon())
            }
            binding.a1 -> {
                binding.a1.setImageDrawable(getPlayerIcon())
            }
            binding.a2 -> {
                binding.a2.setImageDrawable(getPlayerIcon())
            }
            binding.b0 -> {
                binding.b0.setImageDrawable(getPlayerIcon())
            }
            binding.b1 -> {
                binding.b1.setImageDrawable(getPlayerIcon())
            }
            binding.b2 -> {
                binding.b2.setImageDrawable(getPlayerIcon())
            }
            binding.c0 -> {
                binding.c0.setImageDrawable(getPlayerIcon())
            }
            binding.c1 -> {
                binding.c1.setImageDrawable(getPlayerIcon())
            }
            binding.c2 -> {
                binding.c2.setImageDrawable(getPlayerIcon())
            }
        }
        if (playerType == TicTac.TIC) {
            playerType = TicTac.TAC
        } else {
            playerType = TicTac.TIC
        }
    }

    private fun getPlayerIcon(): Drawable? {
        return when (playerType) {
            TicTac.TIC -> {
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_android)
            }
            else -> {
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_baseline_toe)
            }
        }
    }
}