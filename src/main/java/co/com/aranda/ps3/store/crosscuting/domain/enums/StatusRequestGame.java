package co.com.aranda.ps3.store.crosscuting.domain.enums;

public enum StatusRequestGame {
    CREATE("Creado"),
    PROCESSING("Procesando"),
    CLOSE("Cerrado"),
    FINISH("Finalizado");
    private String label;

    StatusRequestGame(String label) {
        this.label = label;
    }
}
