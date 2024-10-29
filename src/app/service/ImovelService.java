package app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.dao.ImovelDao;
import app.model.Imovel;

@Service
public class ImovelService {
    private ImovelDao imovelDao= new ImovelDao();

    public String salvar(Imovel imovel){
        return this.imovelDao.salvar(imovel);

    }

    public List<Imovel> listar(){
        return this.imovelDao.listar();
    }
}
