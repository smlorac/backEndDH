package avaliacao_parcial.dao;

public interface IDao<T> {

    //metodo de cadastro
    public T salvar(T t);
}
