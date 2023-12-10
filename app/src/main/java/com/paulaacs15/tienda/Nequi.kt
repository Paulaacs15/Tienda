package com.paulaacs15.tienda

class Nequi {
}
//Login
fun Login():Int{
    var contra:Int=0
    var returno:Int=0
    var contador: Int = 3
    var op=1
    while (op<=3){
        while (contador >= 0) {
            println("Ingrese el numero de celular")
            var number:Long= readLine()!!.toLong()
            var parseo=number.toString()!!
            var cantidad=parseo.length
            if (cantidad<10){
                println("El numero de celular son menores al rango requerido")
                returno=1
                contador=contador-1
                println("¿Quieres volver a intentarlo? 1. si 3.no")
                op= readLine()!!.toInt()
                op=op+1
            }
            else {
                println("Ingrese el su clave de nequi de 4 digitos")
                contra = readLine()!!.toInt()
                var parseo2 = number.toString()!!
                var cantidad2 = parseo.length
                if (cantidad2 < 4) {
                    println("La clave es menores al rango requerido")
                    println("¿Desea volver a intentarlo?")
                    contador=contador-1
                    println("¿Quieres volver a intentarlo? 1. si 3.no")
                    op= readLine()!!.toInt()
                    op=op+1
                    returno=1
                } else {
                    if (number == 3508010097 && contra == 2209) {
                        println("Bienvenido")
                        returno=2
                        contador=contador-4
                        op=op+5
                    }
                    else {
                        println("¡Upps! Parece que tus datos de acceso no son correctos, Tienes tres intentos más")
                        contador = contador - 1
                        println("¿Quieres volver a intentarlo? 1. si 3.no")
                        op= readLine()!!.toInt()
                        op= op+1
                    }
                }
            }
        }
    }

    return returno
}
fun sacar(saldo: Long):Long{
    var op:Int=1
    var saldito:Long=saldo
    while(op==1){
        println("Ingrese 1 para punto fisico, y 2 pára cajero automatico")
        var op1:Int= readLine()!!.toInt()
        if (op1==1 || op1==2){
            if (saldito<2000){
                println("No te alcanza")
            }
            else{
                println("Ingrese el valor a sacar")
                var sacar:Long=readLine()!!.toLong()
                if (sacar>saldito){
                    println("No puedes sacar un valor mayor a tu saldo")
                }
                else{
                    var confirmacion:Int=(1..999999).random()
                    println("Tu codigo es: $confirmacion")
                    println("Ingresa el codigo de confirmacion que te llego")
                    var confirmacion2:Int= readLine()!!.toInt()
                    if(confirmacion==confirmacion2){
                        saldito=saldo-sacar
                        println("Retiro exitoso tu saldo es $saldito")
                    }
                    else{
                        println("El codigo de confirmacion es incorrecto")
                    }
                }
            }
        }
        println("¿Desea volver a sacar dinero? 1. si 2. no")
        op=readLine()!!.toInt()
    }
    return saldito
}
fun recarga(saldo:Long):Long{
    var saldito:Long=saldo
    println("Ingrese el valor de recarga")
    var recarga:Long= readLine()!!.toLong()
    println("¿Seguro que quieres realizar la recarga, 1. si y 2. no?")
    var op:Int= readLine()!!.toInt()
    if (op==1){
        println("Recarga realizada tu saldo es: $saldito")
        saldito=saldo+recarga
    }
    else{
        println("Recarga cancelada")
    }
    return saldito
}
fun envia(saldo: Long):Long{
    var saldito:Long=saldo
    println("Digite el numero de telefono al cual desea enviar dinero")
    var number:Long= readLine()!!.toLong()
    println("Digite el valor a enviar")
    var enviovalue:Long= readLine()!!.toLong()
    if (saldito>enviovalue){
        println("Envio  tu saldo es: $saldito")
        saldito=saldito-enviovalue
    }
    else{
        println("No te alcanza para enviar ese valor")
    }
    return saldito
}

fun recargaCell(saldo:Long):Long{
    var saldito:Long=saldo
    print("Elige 1. para minutos o 2. para paquetes")
    var opRecarga:Int= readLine()!!.toInt()
    if (opRecarga==1){
        println("Ingrese el numero de telefono")
        var numbertell:Long= readLine()!!.toLong()
        println("Digite el valor de recarga")
        var valueRecarga:Long= readLine()!!.toLong()
        if (saldito>valueRecarga){
            saldito=saldito-valueRecarga
            println("Recarga de minutos realizados")
        }
        else{
            println("El valor de tu recarga es mayor al de tu saldo, No te alcanza")
        }
    }
    else if(opRecarga==2){
        println("Ingrese el numero de telefono")
        var numbertell:Long= readLine()!!.toLong()
        println("Elige el operador, 1. Claro, 2 Wom o 3.Movistar")
        var operador:Int= readLine()!!.toInt()
        if (operador==1){
            println("Elige el paquete, 1.")
        }
        else if(operador==2){

        }
        else if (operador==3){

        }
        else{
            println("No existe esa opcion de operador, reintente")
        }
    }
    else{
        println("La opcion escogida no esta entre las brindadas")
    }
    return saldito
}
fun nequi(){
    var retorno:Int=Login()
    if (retorno==2){
        var p:Int=1
        var saldo:Long=4500
        while (p==1){
            println("Seleccione 1. Recarga, 2. Sacar 3. Envia y 4. Salir")
            var retorno:Long=0
            var opGlobal:Int= readLine()!!.toInt()
            if (opGlobal==1){
                retorno=recarga(saldo)
                saldo=retorno
            }
            else if (opGlobal==2){
                retorno=sacar(saldo)
                saldo=retorno
            }
            else if (opGlobal==3){
                retorno=envia(saldo)
                saldo=retorno
            }
            else if (opGlobal==4){
                println("Saliendo de la aplicacion")
                break
            }
            println("¿Quiere seguir acciendo acciones?1. si 2. no")
            p= readLine()!!.toInt()
        }
    }
    else{
        println("No puedes ingresar, por que se te acabaron los intentos, o los dgiitos de clave y numero de telefono son menores al rango")
    }
}
fun main() {
    nequi()
}