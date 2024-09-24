
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf

class PersonasViewModel : ViewModel() {
    var listaPersonas = mutableStateListOf<Triple<String, String, String>>()
        private set

    fun agregarPersona(nombre: String, apellido: String, edad: String) {
        listaPersonas.add(Triple(nombre, apellido, edad))
    }
}
