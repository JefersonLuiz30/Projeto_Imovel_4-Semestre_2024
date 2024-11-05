package app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.dao.ImovelDao;
import app.model.Imovel;

@Service
public class ImovelService {
    private ImovelDao imovelDao = new ImovelDao();

    public String salvar(Imovel imovel) {
        return this.imovelDao.salvar(imovel);

    }

    public List<Imovel> listar() {
        return this.imovelDao.listar();
    }

    public List<Imovel> procurar(String rua) {
        return this.imovelDao.procurar(rua);
    }

<<<<<<< HEAD
    public Imovel getPorCodigo(int codigo) {
        return this.imovelDao.getPorCodigo(codigo);
    }
=======
    public List<Imovel> procurarNum(String numero) {
        return this.imovelDao.procurarNum(numero);
    }

>>>>>>> df73ff32d7dd716ca7167be92663febc51939c49
}
