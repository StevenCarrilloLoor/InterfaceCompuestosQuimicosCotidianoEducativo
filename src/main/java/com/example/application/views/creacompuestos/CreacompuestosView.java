package com.example.application.views.creacompuestos;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Crea compuestos")
@Route(value = "hello-world", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class CreacompuestosView extends HorizontalLayout {

    private TextField nickname;
    private Button iniciarJuego;
    private Button verificarButton;
    private Button limpiarButton;
    private Button siguienteButton;
    private TextField contadorHidrogeno;
    private TextField contadorOxigeno;
    private TextField contadorCarbono;
    private TextField puntaje;
    private TextField puntajeTotal;

    private int contadorHidrogenoValue;
    private int contadorOxigenoValue;
    private int contadorCarbonoValue;
    private int puntajeValue;
    private int puntajeTotalValue;

    private String compuestoActual;

    public CreacompuestosView() {
        nickname = new TextField("Nickname");
        iniciarJuego = new Button("Iniciar Juego");
        verificarButton = new Button("Verificar");
        limpiarButton = new Button("Limpiar");
        siguienteButton = new Button("Siguiente");

        contadorHidrogeno = new TextField("Contador de Hidrógeno");
        contadorHidrogeno.setReadOnly(true);
        contadorOxigeno = new TextField("Contador de Oxígeno");
        contadorOxigeno.setReadOnly(true);
        contadorCarbono = new TextField("Contador de Carbono");
        contadorCarbono.setReadOnly(true);
        puntaje = new TextField("Puntuación");
        puntaje.setReadOnly(true);
        puntajeTotal = new TextField("Puntuación Total");
        puntajeTotal.setReadOnly(true);

        iniciarJuego.addClickListener(e -> {
            iniciarJuego();
        });

        verificarButton.addClickListener(e -> {
            verificarRespuesta();
        });

        limpiarButton.addClickListener(e -> {
            limpiarCampos();
        });

        siguienteButton.addClickListener(e -> {
            siguiente();
        });

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, nickname, iniciarJuego, verificarButton, limpiarButton, siguienteButton);

        add(nickname, iniciarJuego);
    }

    private void iniciarJuego() {
        contadorHidrogenoValue = 0;
        contadorOxigenoValue = 0;
        contadorCarbonoValue = 0;
        puntajeValue = 0;
        puntajeTotalValue = 0;

        compuestoActual = "Agua";

        removeAll();

        // Mostrar la pregunta actual
        H1 preguntaLabel = new H1("Crea la fórmula del agua");
        add(preguntaLabel);

        add(new Button("Hidrógeno", e -> incrementarAtomo("Hidrógeno")),
                new Button("Oxígeno", e -> incrementarAtomo("Oxígeno")));
        add(contadorHidrogeno, contadorOxigeno);
        add(verificarButton, limpiarButton, siguienteButton);
        add(puntaje, puntajeTotal);

        actualizarContadores();
    }

    private void incrementarAtomo(String elemento) {
        if (elemento.equals("Hidrógeno")) {
            contadorHidrogenoValue++;
        } else if (elemento.equals("Oxígeno")) {
            contadorOxigenoValue++;
        } else if (elemento.equals("Carbono")) {
            contadorCarbonoValue++;
        }

        actualizarContadores();
    }

    private void verificarRespuesta() {
        int cantidadHidrogeno = contadorHidrogenoValue;
        int cantidadOxigeno = contadorOxigenoValue;
        int cantidadCarbono = contadorCarbonoValue;

        boolean respuestaCorrecta = false;

        if (compuestoActual.equals("Agua")) {
            if (cantidadHidrogeno == 2 && cantidadOxigeno == 1) {
                // Respuesta correcta
                mostrarInformacionAgua();
                Notification.show("Respuesta correcta");
                respuestaCorrecta = true;
            } else {
                Notification.show("Respuesta incorrecta");
            }
        } else if (compuestoActual.equals("Metano")) {
            if (cantidadHidrogeno == 4 && cantidadOxigeno == 0 && cantidadCarbono == 1) {
                // Respuesta correcta
                mostrarInformacionMetano();
                Notification.show("Respuesta correcta");
                respuestaCorrecta = true;
            } else {
                Notification.show("Respuesta incorrecta");
            }
        } else if (compuestoActual.equals("Oxígeno")) {
            if (cantidadHidrogeno == 0 && cantidadOxigeno == 2 && cantidadCarbono == 0) {
                // Respuesta correcta
                mostrarInformacionOxigeno();
                Notification.show("Respuesta correcta");
                respuestaCorrecta = true;
            } else {
                Notification.show("Respuesta incorrecta");
            }
        } else if (compuestoActual.equals("Ozono")) {
            if (cantidadHidrogeno == 0 && cantidadOxigeno == 3 && cantidadCarbono == 0) {
                // Respuesta correcta
                mostrarInformacionOzono();
                Notification.show("Respuesta correcta");
                respuestaCorrecta = true;
            } else {
                Notification.show("Respuesta incorrecta");
            }
        } else if (compuestoActual.equals("Dióxido de carbono")) {
            if (cantidadHidrogeno == 0 && cantidadOxigeno == 2 && cantidadCarbono == 1) {
                // Respuesta correcta
                mostrarInformacionDioxidoCarbono();
                Notification.show("Respuesta correcta");
                respuestaCorrecta = true;
            } else {
                Notification.show("Respuesta incorrecta");
            }
        } else if (compuestoActual.equals("Bicarbonato")) {
            if (cantidadHidrogeno == 1 && cantidadOxigeno == 3 && cantidadCarbono == 1) {
                // Respuesta correcta
                mostrarInformacionBicarbonato();
                Notification.show("Respuesta correcta");
                respuestaCorrecta = true;
            } else {
                Notification.show("Respuesta incorrecta");
            }
        }

        if (respuestaCorrecta) {
            puntajeValue += 10;
        } else {
            puntajeValue -= 5;
        }

        puntajeTotalValue += puntajeValue;

        puntaje.setValue(String.valueOf(puntajeValue));
        puntajeTotal.setValue(String.valueOf(puntajeTotalValue));
    }

    private void mostrarInformacionAgua() {
        removeAll();

        Paragraph info = new Paragraph("Nomenclatura sistemática: monóxido de dihidrógeno\n" +
                "\n" +
                "Nomenclatura stock: óxido de hidrógeno\n" +
                "\n" +
                "Tipo de compuesto: anhídrido (no metal + oxígeno)\n" +
                "Se trata de una sustancia líquida en condiciones normales de temperatura y presión. El agua es considerada como el disolvente universal, por su gran potencial como disolvente. El agua pura tiene conductividad eléctrica baja. Su densidad es muy estable y no sufre grandes cambios en los cambios de presión y temperatura.\n" +
                "No es un elemento combustible debido a que es un producto residual de la combustión del hidrógeno.");
        H1 titulo = new H1(" Agua H2O");

        add(info, titulo);
        add(siguienteButton);
    }

    private void mostrarInformacionMetano() {
        removeAll();

        Paragraph info = new Paragraph("El metano es un gas incoloro e inflamable que es el principal componente del gas natural. Está compuesto por un átomo de carbono (C) y cuatro átomos de hidrógeno (H). El metano se produce tanto de manera natural (por ejemplo, en los procesos de descomposición orgánica) como por actividades humanas (como la producción de combustibles fósiles y la cría de ganado). Es un gas de efecto invernadero y contribuye al calentamiento global.");
        H1 titulo = new H1("CH4");

        add(info, titulo);
        add(siguienteButton);
    }

    private void mostrarInformacionOxigeno() {
        removeAll();

        Paragraph info = new Paragraph("El oxígeno es un gas presente en la atmósfera terrestre y es vital para la respiración de la mayoría de los seres vivos. Está compuesto por dos átomos de oxígeno (O) y se produce principalmente a través de la fotosíntesis realizada por plantas y algas. El oxígeno es necesario para la combustión, la respiración celular y otros procesos metabólicos.");
        H1 titulo = new H1("O2");

        add(info, titulo);
        add(siguienteButton);
    }

    private void mostrarInformacionOzono() {
        removeAll();

        Paragraph info = new Paragraph("El ozono es un gas que se encuentra en la atmósfera superior de la Tierra y tiene un olor distintivo. Está compuesto por tres átomos de oxígeno (O) y se forma cuando las moléculas de oxígeno (O2) se rompen bajo la influencia de la radiación ultravioleta. El ozono es importante en la atmósfera, ya que absorbe gran parte de la radiación ultravioleta del sol, protegiendo así a los organismos vivos en la Tierra.");
        H1 titulo = new H1("O3");

        add(info, titulo);
        add(siguienteButton);
    }

    private void mostrarInformacionDioxidoCarbono() {
        removeAll();

        Paragraph info = new Paragraph("El dióxido de carbono es un gas incoloro y denso que se encuentra en la atmósfera de la Tierra. Está compuesto por un átomo de carbono (C) y dos átomos de oxígeno (O). El dióxido de carbono es un subproducto de la respiración y la combustión, y es un componente importante en el ciclo del carbono. También es conocido por su contribución al efecto invernadero y al cambio climático.");
        H1 titulo = new H1("CO2");

        add(info, titulo);
        add(siguienteButton);
    }

    private void mostrarInformacionBicarbonato() {
        removeAll();

        Paragraph info = new Paragraph("El bicarbonato es un ion presente en varias sustancias y compuestos. Está compuesto por un átomo de carbono (C), un átomo de hidrógeno (H) y tres átomos de oxígeno (O). El bicarbonato se encuentra comúnmente en forma de bicarbonato de sodio (NaHCO3), que es una sal que se utiliza en la cocina, la limpieza y también en procesos médicos. El bicarbonato de sodio es conocido por sus propiedades alcalinas y se utiliza para neutralizar ácidos y como agente leudante en la cocina. También se encuentra presente en el sistema de amortiguación del cuerpo humano, ayudando a mantener el equilibrio ácido-base en la sangre y otros líquidos corporales.");
        H1 titulo = new H1("HCO3-");

        add(info, titulo);
        add(siguienteButton);
    }

    private void limpiarCampos() {
        contadorHidrogenoValue = 0;
        contadorOxigenoValue = 0;
        contadorCarbonoValue = 0;
        puntajeValue = 0;

        actualizarContadores();
        Notification.show("Campos limpiados");
    }

    private void siguiente() {
        if (compuestoActual.equals("Agua")) {
            compuestoActual = "Metano";

            removeAll();

            H1 preguntaLabel = new H1("Crea la fórmula del metano");
            add(preguntaLabel);

            add(new Button("Hidrógeno", e -> incrementarAtomo("Hidrógeno")),
                    new Button("Oxígeno", e -> incrementarAtomo("Oxígeno")),
                    new Button("Carbono", e -> incrementarAtomo("Carbono")));
            add(contadorHidrogeno, contadorOxigeno, contadorCarbono);
            add(verificarButton, limpiarButton, siguienteButton);

            actualizarContadores();
        } else if (compuestoActual.equals("Metano")) {
            compuestoActual = "Oxígeno";

            removeAll();

            H1 preguntaLabel = new H1("Crea la fórmula del oxígeno");
            add(preguntaLabel);

            add(new Button("Hidrógeno", e -> incrementarAtomo("Hidrógeno")),
                    new Button("Oxígeno", e -> incrementarAtomo("Oxígeno")),
                    new Button("Carbono", e -> incrementarAtomo("Carbono")));
            add(contadorHidrogeno, contadorOxigeno, contadorCarbono);
            add(verificarButton, limpiarButton, siguienteButton);

            actualizarContadores();
        } else if (compuestoActual.equals("Oxígeno")) {
            compuestoActual = "Ozono";

            removeAll();

            H1 preguntaLabel = new H1("Crea la fórmula del ozono");
            add(preguntaLabel);

            add(new Button("Hidrógeno", e -> incrementarAtomo("Hidrógeno")),
                    new Button("Oxígeno", e -> incrementarAtomo("Oxígeno")),
                    new Button("Carbono", e -> incrementarAtomo("Carbono")));
            add(contadorHidrogeno, contadorOxigeno, contadorCarbono);
            add(verificarButton, limpiarButton, siguienteButton);

            actualizarContadores();
        } else if (compuestoActual.equals("Ozono")) {
            compuestoActual = "Dióxido de carbono";

            removeAll();

            H1 preguntaLabel = new H1("Crea la fórmula del dióxido de carbono");
            add(preguntaLabel);

            add(new Button("Hidrógeno", e -> incrementarAtomo("Hidrógeno")),
                    new Button("Oxígeno", e -> incrementarAtomo("Oxígeno")),
                    new Button("Carbono", e -> incrementarAtomo("Carbono")));
            add(contadorHidrogeno, contadorOxigeno, contadorCarbono);
            add(verificarButton, limpiarButton, siguienteButton);

            actualizarContadores();
        } else if (compuestoActual.equals("Dióxido de carbono")) {
            compuestoActual = "Bicarbonato";

            removeAll();

            H1 preguntaLabel = new H1("Crea la fórmula del bicarbonato");
            add(preguntaLabel);

            add(new Button("Hidrógeno", e -> incrementarAtomo("Hidrógeno")),
                    new Button("Oxígeno", e -> incrementarAtomo("Oxígeno")),
                    new Button("Carbono", e -> incrementarAtomo("Carbono")));
            add(contadorHidrogeno, contadorOxigeno, contadorCarbono);
            add(verificarButton, limpiarButton, siguienteButton);

            actualizarContadores();
        } else if (compuestoActual.equals("Bicarbonato")) {
            mostrarPuntuacionTotal();
        }
    }

    private void actualizarContadores() {
        contadorHidrogeno.setValue(String.valueOf(contadorHidrogenoValue));
        contadorOxigeno.setValue(String.valueOf(contadorOxigenoValue));
        contadorCarbono.setValue(String.valueOf(contadorCarbonoValue));
        puntaje.setValue(String.valueOf(puntajeValue));
    }

    private void mostrarPuntuacionTotal() {
        removeAll();

        H1 puntuacionTotalLabel = new H1("Puntuación Total");
        add(puntuacionTotalLabel);

        Paragraph puntuacion = new Paragraph("El jugador " + nickname.getValue() + " ha obtenido una puntuación total de " + puntajeTotalValue + " puntos.");
        add(puntuacion);
    }
}