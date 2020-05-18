package sysjm3.bulbo.bulbo.repositories;

import org.springframework.stereotype.Repository;

/**
 *
 * @author Christoffer Hansen
 */
@Repository
public interface CardRepository extends CardRepositoryBasic,
                                        CardRepositoryCustom {
    
}
