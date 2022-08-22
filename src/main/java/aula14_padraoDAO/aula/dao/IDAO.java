package aula14_padraoDAO.aula.dao;

public interface IDAO <T> {
    //o T indica um tipo genérico

    public T salvar(T t);

    public T buscar(Integer id);
}
