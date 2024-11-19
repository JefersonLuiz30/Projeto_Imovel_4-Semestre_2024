package app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.dao.ImovelDao;
import app.model.Imovel;

@Service
public class ImoveisService {
    private ImovelDao imovelDao = new ImovelDao();

    public String salvar(Imovel imovel) {
        return this.imovelDao.salvar(imovel);

    }

    public List<Imovel> listar() {
        return this.imovelDao.listar();
    }

    public List<Imovel> procurar(String rua, String numero) {
        return this.imovelDao.procurar(rua, numero);
    }

    public Imovel getPorCodigo(int codigo) {
        return this.imovelDao.getPorCodigo(codigo);
    }

    public String excluir(int codigo) {
        return this.imovelDao.excluir(codigo);
    }

}
