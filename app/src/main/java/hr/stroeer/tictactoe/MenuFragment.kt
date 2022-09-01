package hr.stroeer.tictactoe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import hr.stroeer.tictactoe.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.hostGameButton.setOnClickListener {
            showHostDialog()
        }
        binding.joinGameButton.setOnClickListener {
            showJoinDialog()
        }
        binding.offlineModeButton.setOnClickListener {
            navigateToGameFieldScreen()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showHostDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(R.layout.join_host_game_dialog)

        val dialog = builder.create()
        dialog.show()

        dialog.findViewById<Button>(R.id.ok_button)?.setOnClickListener {
            hostGame(
                dialog.findViewById<EditText>(R.id.room_id_edit_text)?.text.toString()
            )
            navigateToGameFieldScreen()
            dialog.dismiss()
        }
    }

    private fun showJoinDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(R.layout.join_host_game_dialog)

        val dialog = builder.create()
        dialog.show()

        dialog.findViewById<Button>(R.id.ok_button)?.setOnClickListener {
            joinGame(
                dialog.findViewById<EditText>(R.id.room_id_edit_text)?.text.toString()
            )
            navigateToGameFieldScreen()
            dialog.dismiss()
        }
    }

    private fun hostGame(roomName: String) {

    }

    private fun joinGame(roomName: String) {

    }

    private fun navigateToGameFieldScreen() {
        findNavController().navigate(R.id.action_menuFragment_to_gameFieldFragment)
    }
}