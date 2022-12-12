package co.com.aranda.ps3.store.crosscuting.domain.enums;

public enum GlobalMessages {
    STATE("Estado"),
    CONTENT("Content"),
    MESSAGES("Mensaje"),
    NOT_FOUND_GAME("No se encontro el juego con el id: "),
    NOT_FOUND_REQUEST_GAME("No se encontro la solicitud con el id: "),
    PROCESS_SUCCESSFULL("Proceso Exitoso"),
    CREATING_GAME("Creando Juego"),
    FAILED_CREATING_REQUEST_GAME("Failed to create request"),
    ERROR_CREATING_GAME("No se pudo crear el juego"),
    ERROR_UPDATING_GAME("No se pudo actualizar el juego  con id: "),
    UPDATING_REQUEST_GAME("Actualizando Solicitud"),
    UPDATING_GAME("Actualizando Juego"),
    COULD_NOT_UPDATE_REQUEST_GAME("No se pudo actualizar la solicitud con id: ")


    ;

    private String label;

    GlobalMessages(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
