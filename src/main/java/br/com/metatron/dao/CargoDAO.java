package br.com.metatron.dao;

import br.com.metatron.api.model.Cargo;
import java.util.List;

/**
 *
 * @author diego
 */
public interface CargoDAO {
    Cargo find(Long id) throws Exception;

    List<Cargo> findAll() throws Exception;
    
    List<Cargo> findAllByNome(String nomeCargo) throws Exception;
}
