package com.example.application.views.listadecomponetnes;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.html.OrderedList;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.JustifyContent;
import com.vaadin.flow.theme.lumo.LumoUtility.ListStyleType;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.MaxWidth;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;

@PageTitle("Lista de componentes")
@Route(value = "image-list", layout = MainLayout.class)
public class ListadecomponetnesView extends Main implements HasComponents, HasStyle {

    private OrderedList imageContainer;

    //En esta parte del codigo se utiliza para agregar una label con la estructura de la etiqueta.
    public ListadecomponetnesView() {
        constructUI();

        imageContainer.add(new ListadecomponetnesViewCard("Agua",
                "https://cloudfront-us-east-1.images.arcpublishing.com/eluniverso/ZVZGYVPWSJFO3JNOAAIXM6HS5M.jpg",
                "Agua (H2O)",
                "El agua es una sustancia líquida transparente, inodora e insípida que es esencial para la vida. Está compuesta por dos átomos de hidrógeno (H) y un átomo de oxígeno (O). La molécula de agua tiene una forma angular, donde los dos átomos de hidrógeno están unidos al átomo de oxígeno mediante enlaces covalentes."));
        imageContainer.add(new ListadecomponetnesViewCard("OZONO",
                "https://media.istockphoto.com/id/482110960/es/foto/vista-de-la-tierra-desde-el-espacio.jpg?s=612x612&w=0&k=20&c=g5_AWAJG_XQkRRr0vwJukQwmW8C_ulNaE9906T3uNkw=",
                "Ozono (O3)",
                "El ozono es un gas que se encuentra en la atmósfera superior de la Tierra y tiene un olor distintivo. Está compuesto por tres átomos de oxígeno (O) y se forma cuando las moléculas de oxígeno (O2) se rompen bajo la influencia de la radiación ultravioleta. El ozono es importante en la atmósfera, ya que absorbe gran parte de la radiación ultravioleta del sol, protegiendo así a los organismos vivos en la Tierra."));
        imageContainer.add(new ListadecomponetnesViewCard("OXIGENO AAAAHHHHHGGGG",
                "https://saludconlupa.com/media/images/oxigeno-medicinal.width-1920.jpg",
                "Oxígeno (O2)",
                "El oxígeno es un gas presente en la atmósfera terrestre y es vital para la respiración de la mayoría de los seres vivos. Está compuesto por dos átomos de oxígeno (O) y se produce principalmente a través de la fotosíntesis realizada por plantas y algas. El oxígeno es necesario para la combustión, la respiración celular y otros procesos metabólicos."));
        imageContainer.add(new ListadecomponetnesViewCard("Dioxido de carbono",
                "https://cdn.computerhoy.com/sites/navi.axelspringer.es/public/media/image/2022/01/central-electrica-carbon-2581019.jpg?tf=3840x",
                "Dióxido de carbono (CO2)",
                "El dióxido de carbono es un gas incoloro y denso que se encuentra en la atmósfera de la Tierra. Está compuesto por un átomo de carbono (C) y dos átomos de oxígeno (O). El dióxido de carbono es un subproducto de la respiración y la combustión, y es un componente importante en el ciclo del carbono. También es conocido por su contribución al efecto invernadero y al cambio climático."));
        imageContainer.add(new ListadecomponetnesViewCard("Metano",
                "https://okdiario.com/img/2019/06/10/-que-es-el-gas-metano-y-como-se-produce_-655x368.jpg",
                "Metano (CH4)",
                "El metano es un gas incoloro e inflamable que es el principal componente del gas natural. Está compuesto por un átomo de carbono (C) y cuatro átomos de hidrógeno (H). El metano se produce tanto de manera natural (por ejemplo, en los procesos de descomposición orgánica) como por actividades humanas (como la producción de combustibles fósiles y la cría de ganado). Es un gas de efecto invernadero y contribuye al calentamiento global."));
        imageContainer.add(new ListadecomponetnesViewCard("SAL",
                "https://www.webconsultas.com/sites/default/files/styles/wch_image_schema/public/media/2022/05/04/sal_oculta_alimentos_p.jpg",
                "NaCl (sal)",
                "El cloruro de sodio, comúnmente conocido como sal, es un compuesto iónico cristalino. Está compuesto por un átomo de sodio (Na) y un átomo de cloro (Cl). La sal es ampliamente utilizada como condimento en la cocina y tiene un sabor característico. También desempeña un papel importante en el equilibrio de líquidos del cuerpo humano y en otros procesos biológicos."));
        imageContainer.add(new ListadecomponetnesViewCard("Bicarbonato (HCO3)",
                "https://www.koprimo.com.mx/wp-content/uploads/2022/12/Bicarbonato-de-sodio-industrial-Koprimo-01.png",
                "Bicarbonato (HCO3)",
                "El bicarbonato es un ion presente en varias sustancias y compuestos. Está compuesto por un átomo de carbono (C), un átomo de hidrógeno (H) y tres átomos de oxígeno (O). El bicarbonato se encuentra comúnmente en forma de bicarbonato de sodio (NaHCO3), que es una sal que se utiliza en la cocina, la limpieza y también en procesos médicos. El bicarbonato de sodio es conocido por sus propiedades alcalinas y se utiliza para neutralizar ácidos y como agente leudante en la cocina. También se encuentra presente en el sistema de amortiguación del cuerpo humano, ayudando a mantener el equilibrio ácido-base en la sangre y otros líquidos corporales."));

    }

    private void constructUI() {
        addClassNames("listadecomponetnes-view");
        addClassNames(MaxWidth.SCREEN_LARGE, Margin.Horizontal.AUTO, Padding.Bottom.LARGE, Padding.Horizontal.LARGE);

        HorizontalLayout container = new HorizontalLayout();
        container.addClassNames(AlignItems.CENTER, JustifyContent.BETWEEN);

        VerticalLayout headerContainer = new VerticalLayout();
        H2 header = new H2("Lista de Compuestos Químicos y Sustancias Comunes");
        header.addClassNames(Margin.Bottom.NONE, Margin.Top.XLARGE, FontSize.XXXLARGE);
        Paragraph description = new Paragraph("A continuación se presenta una recopilación de compuestos químicos y sustancias ampliamente conocidos y utilizados en diversos ámbitos, que abarcan desde la naturaleza hasta el ámbito industrial y cotidiano. Estos compuestos y sustancias son de gran importancia en múltiples aplicaciones");
        description.addClassNames(Margin.Bottom.XLARGE, Margin.Top.NONE, TextColor.SECONDARY);
        headerContainer.add(header, description);

        Select<String> sortBy = new Select<>();
        sortBy.setLabel("coso no implementado");
        sortBy.setItems("No funcional", "No funcional", "Posiblemnete elimine esto mas adelante");
        sortBy.setValue("No tocar");

        imageContainer = new OrderedList();
        imageContainer.addClassNames(Gap.MEDIUM, Display.GRID, ListStyleType.NONE, Margin.NONE, Padding.NONE);

        container.add(headerContainer, sortBy);
        add(container, imageContainer);
    }
}
