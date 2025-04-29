package mx.unam.fca.a02estadosactivity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ActivityUno : AppCompatActivity() {
    private lateinit var txvEstados:TextView
    private val ACTIVIDAD_UNO:String = "Actividad 1"
    protected var sbMsg:StringBuilder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uno)

        txvEstados = findViewById(R.id.txvEstados)
        sbMsg.append(txvEstados.text.toString())
        sbMsg.append("\n$ACTIVIDAD_UNO")
        sbMsg.append("\nSe ejecutó onCreate")
        txvEstados.text = sbMsg;
        /*
        Llamado cuando la actividad se crea, es donde, debe
        de ir la mayoria de las inicializaciones
        setContentView(int) para inflar la UI usando findViewById
        */

        var siguiente = findViewById<Button>(R.id.btnSiguiente)
        siguiente.setOnClickListener {
            val intento: Intent = Intent(this@ActivityUno,
                ActivityDos::class.java)
            startActivity(intento)
        }


    }

    override fun onStart() {
        super.onStart()
        sbMsg.append("\nSe ejecutó onStart")
        txvEstados.text = sbMsg;
        /*
        Se invoca después de onCreate o de onRestart
        cuando se detiene la actividad, si es algo nuevo
        lo que se muestra sigue onResume
        */
    }

    override fun onResume() {
        super.onResume()
        sbMsg.append("\nSe ejecutó onResume")
        txvEstados.text = sbMsg;
        /*
        Cuando ingresa a onResume el usuario interactua con la
        app manteniendo el estado hasta que sucede algo.
        * */
    }

    override fun onPause() {
        super.onPause()
        sbMsg.append("\nSe ejecutó onPause")
        txvEstados.text = sbMsg;
        /*
        Se ejecuta cuando el usuario deja la actividad
        p.e.: Cuando se pasa a otra actividad.
        * */
    }

    override fun onStop() {
        super.onStop()
        sbMsg.append("\nSe ejecutó onStop")
        txvEstados.text = sbMsg;
        Toast.makeText(this, "Se ejecutó onStop()",
            Toast.LENGTH_SHORT).show()
        /*
        Se llama a onStop cuando la actividad ha terminado
        de ejecutarse y esta a punto de finalizar.
        Aquí es donde se deben de liberar todos los recursos
        que ya no son necesarios.
        * */
    }

    override fun onDestroy() {
        super.onDestroy()
        sbMsg.append("\nSe ejecutó onDestroy")
        txvEstados.text = sbMsg;
        Toast.makeText(this, "Se ejecutó onDestroy()",
            Toast.LENGTH_SHORT).show()
        /*
        onDestroy se ejecuta cuando se sale de la app
        y se usa para liberar todos los recursos ocupados
        o subprocesos.
        * */
    }

}
