package br.com.jckrknaul.SupermarketList.repository;

import br.com.jckrknaul.SupermarketList.model.SupermarketList;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SupermarketlistRepository extends PagingAndSortingRepository<SupermarketList, Long>{
    SupermarketList findById(long id);

}
