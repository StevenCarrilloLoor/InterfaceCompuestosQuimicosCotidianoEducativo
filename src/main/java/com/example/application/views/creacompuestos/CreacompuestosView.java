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
    private TextField contadorHidrogeno;
    private TextField contadorOxigeno;

    private int contadorHidrogenoValue;
    private int contadorOxigenoValue;

    private String compuestoActual;

    public CreacompuestosView() {
        nickname = new TextField("Nickname");
        iniciarJuego = new Button("Iniciar Juego");
        verificarButton = new Button("Verificar");
        limpiarButton = new Button("Limpiar");

        contadorHidrogeno = new TextField("Contador de Hidrógeno");
        contadorHidrogeno.setReadOnly(true);
        contadorOxigeno = new TextField("Contador de Oxígeno");
        contadorOxigeno.setReadOnly(true);

        iniciarJuego.addClickListener(e -> {
            iniciarJuego();
        });

        verificarButton.addClickListener(e -> {
            verificarRespuesta();
        });

        limpiarButton.addClickListener(e -> {
            limpiarCampos();
        });

        setMargin(true);
        setVerticalComponentAlignment(Alignment.END, nickname, iniciarJuego, verificarButton, limpiarButton);

        add(nickname, iniciarJuego);
    }

    private void iniciarJuego() {
        contadorHidrogenoValue = 0;
        contadorOxigenoValue = 0;

        compuestoActual = "Agua";

        removeAll();

        // Mostrar la pregunta actual
        H1 preguntaLabel = new H1("Crea la fórmula del agua");
        add(preguntaLabel);

        add(new Button("Hidrógeno", e -> incrementarAtomo("Hidrógeno")),
                new Button("Oxígeno", e -> incrementarAtomo("Oxígeno")));
        add(contadorHidrogeno, contadorOxigeno);
        add(verificarButton, limpiarButton);

        actualizarContadores();
    }

    private void incrementarAtomo(String elemento) {
        if (elemento.equals("Hidrógeno")) {
            contadorHidrogenoValue++;
        } else if (elemento.equals("Oxígeno")) {
            contadorOxigenoValue++;
        }

        actualizarContadores();
    }

    private void verificarRespuesta() {
        int cantidadHidrogeno = contadorHidrogenoValue;
        int cantidadOxigeno = contadorOxigenoValue;

        if (compuestoActual.equals("Agua")) {
            if (cantidadHidrogeno == 2 && cantidadOxigeno == 1) {
                // Respuesta correcta
                mostrarInformacionAgua();
                Notification.show("Respuesta correcta");
            } else {
                Notification.show("Respuesta incorrecta");
            }
        } else if (compuestoActual.equals("Ozono")) {
            if (cantidadHidrogeno == 0 && cantidadOxigeno == 3) {
                // Respuesta correcta
                mostrarInformacionOzono();
                Notification.show("Respuesta correcta");
            } else {
                Notification.show("Respuesta incorrecta");
            }
        } else if (compuestoActual.equals("Dióxido de carbono")) {
            if (cantidadHidrogeno == 0 && cantidadOxigeno == 2) {
                // Respuesta correcta
                mostrarInformacionDioxidoCarbono();
                Notification.show("Respuesta correcta");
            } else {
                Notification.show("Respuesta incorrecta");
            }
        } else if (compuestoActual.equals("Monóxido de carbono")) {
            if (cantidadHidrogeno == 0 && cantidadOxigeno == 1) {
                // Respuesta correcta
                mostrarInformacionMonoxidoCarbono();
                Notification.show("Respuesta correcta");
            } else {
                Notification.show("Respuesta incorrecta");
            }
        } else if (compuestoActual.equals("Metano")) {
            if (cantidadHidrogeno == 4 && cantidadOxigeno == 0) {
                // Respuesta correcta
                mostrarInformacionMetano();
                Notification.show("Respuesta correcta");
            } else {
                Notification.show("Respuesta incorrecta");
            }
        } else if (compuestoActual.equals("Cloruro de sodio")) {
            if (cantidadHidrogeno == 0 && cantidadOxigeno == 0) {
                // Respuesta correcta
                mostrarInformacionCloruroSodio();
                Notification.show("Respuesta correcta");
            } else {
                Notification.show("Respuesta incorrecta");
            }
        }

        // Resto de las verificaciones para los demás compuestos
    }

    private void mostrarInformacionAgua() {
        removeAll();

        Paragraph info = new Paragraph ("Nomenclatura sistemática: monóxido de dihidrógeno\n" +
                "\n" +
                "Nomenclatura stock: óxido de hidrógeno\n" +
                "\n" +
                "Tipo de compuesto: anhídrido (no metal + oxígeno)"+"\n"+"Se trata de una sustancia líquida en condiciones normales de temperatura y presión. El agua es considerada como el disolvente universal, por su gran potencial como disolvente. El agua pura tiene conductividad eléctrica baja. Su densidad es muy estable y no sufre grandes cambios en los cambios de presión y temperatura.\n" +
                "No es un elemento combustible debido a que es un producto residual de la combustión del hidrógeno.");
        H1 titulo = new H1(" Agua H2O");

        add(info, titulo);
    }

    private void mostrarInformacionOzono() {
        removeAll();

        Paragraph info = new Paragraph("Información sobre el Ozono");
        H1 titulo = new H1("O3");

        add(info, titulo);
    }

    private void mostrarInformacionDioxidoCarbono() {
        removeAll();

        Paragraph info = new Paragraph("Información sobre el Dióxido de carbono");
        H1 titulo = new H1("CO2");

        add(info, titulo);
    }

    private void mostrarInformacionMonoxidoCarbono() {
        removeAll();

        Paragraph info = new Paragraph("Información sobre el Monóxido de carbono");
        H1 titulo = new H1("CO");

        add(info, titulo);
    }

    private void mostrarInformacionMetano() {
        removeAll();

        Paragraph info = new Paragraph("Información sobre el Metano");
        H1 titulo = new H1("CH4");

        add(info, titulo);
    }

    private void mostrarInformacionCloruroSodio() {
        removeAll();

        Paragraph info = new Paragraph("Información sobre el Cloruro de sodio");
        H1 titulo = new H1("NaCl");

        add(info, titulo);
    }

    private void limpiarCampos() {
        contadorHidrogenoValue = 0;
        contadorOxigenoValue = 0;

        actualizarContadores();
        Notification.show("Campos limpiados");
    }

    private void actualizarContadores() {
        contadorHidrogeno.setValue(String.valueOf(contadorHidrogenoValue));
        contadorOxigeno.setValue(String.valueOf(contadorOxigenoValue));
    }

}
