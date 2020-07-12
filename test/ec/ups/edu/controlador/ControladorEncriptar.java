package ec.ups.edu.controlador;

import java.util.HashMap;
import java.util.Map;

public class ControladorEncriptar {

    Map<Character, Character> map = new HashMap<>();

    public void cargarLetras() {
        map.put('a', '*');
        map.put('b', '$');
        map.put('c', '?');
        map.put('d', '%');
        map.put('e', '#');
        map.put('f', '!');
        map.put('g', '¡');
        map.put('h', '¿');
        map.put('i', '}');
        map.put('j', '{');
        map.put('k', '[');
        map.put('l', ']');
        map.put('m', '|');
        map.put('n', '°');
        map.put('ñ', '=');
        map.put('o', '+');
        map.put('p', '-');
        map.put('q', ';');
        map.put('r', ',');
        map.put('s', '>');
        map.put('t', '<');
        map.put('u', 'A');
        map.put('v', 'B');
        map.put('w', 'C');
        map.put('x', 'f');
        map.put('y', 'x');
        map.put('z', 'p');
        map.put(' ', 'd');
        map.put('A', '&');
        map.put('B', '0');
        map.put('C', '1');
        map.put('D', '2');
        map.put('E', '3');
        map.put('F', '4');
        map.put('G', '5');
        map.put('H', '6');
        map.put('I', '7');
        map.put('J', '8');
        map.put('K', '9');
        map.put('L', 'ñ');
        map.put('M', 'y');
        map.put('N', 'Y');
        map.put('Ñ', '♠');
        map.put('O', 'z');
        map.put('P', 'Z');
        map.put('Q', 'X');
        map.put('R', 'W');
        map.put('S', 'w');
        map.put('T', 'v');
        map.put('U', 'b');
        map.put('V', 'Ñ');
        map.put('W', 'g');
        map.put('X', 'G');
        map.put('Y', 'i');
        map.put('Z', 'F');

    }

    public void cargarNumeros() {
        map.put('1', 'p');
        map.put('2', '♦');
        map.put('3', 'm');
        map.put('4', 'E');
        map.put('5', 'k');
        map.put('6', '@');
        map.put('7', '☻');
        map.put('8', '↑');
        map.put('9', '↨');
        map.put('0', 'a');
    }

    public String encriptar(String cadena) {
        String encript = "";
        cargarLetras();
        cargarNumeros();
        for (int i = 0; i < cadena.length(); i++) {
            for (Map.Entry<Character, Character> entry : map.entrySet()) {
                char c = cadena.charAt(i);
                if (c == entry.getKey()) {
                    encript += entry.getValue();
                }

            }
        }
        return encript;

    }

}
