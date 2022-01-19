package Observer;

public interface Subject {
	public void adicionaObservador(Observer obj);

	public void removeObservador(Observer obj);

	public void notificaObservador(int valor);

	public void notificaLastFichaObservador(int valor);
}
