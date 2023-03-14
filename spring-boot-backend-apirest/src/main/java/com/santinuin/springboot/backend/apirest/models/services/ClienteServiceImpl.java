package com.santinuin.springboot.backend.apirest.models.services;

import com.santinuin.springboot.backend.apirest.models.dao.IClienteDao;
import com.santinuin.springboot.backend.apirest.models.dao.IFacturaDao;
import com.santinuin.springboot.backend.apirest.models.dao.IProductosDao;
import com.santinuin.springboot.backend.apirest.models.entity.Cliente;
import com.santinuin.springboot.backend.apirest.models.entity.Factura;
import com.santinuin.springboot.backend.apirest.models.entity.Producto;
import com.santinuin.springboot.backend.apirest.models.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    private final IClienteDao clienteDao;

    private final IFacturaDao facturaDao;

    private final IProductosDao productosDao;

    public ClienteServiceImpl(IClienteDao clienteDao, IFacturaDao facturaDao, IProductosDao productosDao) {
        this.clienteDao = clienteDao;
        this.facturaDao = facturaDao;
        this.productosDao = productosDao;
    }


    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> findAllRegiones() {
       return clienteDao.findAllRegiones();
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findFacturaById(Long id) {
        return facturaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Factura saveFactura(Factura factura) {
        return facturaDao.save(factura);
    }

    @Override
    @Transactional
    public void deleteFacturaById(Long id) {
        facturaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findProductoByNombre(String term) {
        return productosDao.findByNombreStartingWithIgnoreCase(term);
    }


}
