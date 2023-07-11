module com.example.nicolasvicente_comp101130899assignment2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.nicolasvicente_comp101130899_ex3 to javafx.fxml;
    exports com.example.nicolasvicente_comp101130899_ex3;
}