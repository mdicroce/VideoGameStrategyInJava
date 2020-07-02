package GuardadoYCarga;

public class ExceptionNoHayArchivosGuardados extends Exception{
	public ExceptionNoHayArchivosGuardados(String mensaje) {
		super(mensaje);
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage()+" Se creara una Nueva Partida";
	}
}
