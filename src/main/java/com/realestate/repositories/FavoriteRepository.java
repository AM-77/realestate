package com.realestate.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.models.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer>{
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO favorite VALUES ( NULL, :id_lodgement, :id_client, CURRENT_TIMESTAMP)", nativeQuery= true)
	public int add_favorite(@Param("id_lodgement")int id_lodgement, @Param("id_client")int id_client);

	@Query(value="SELECT * FROM favorite WHERE id_client= :id_client", nativeQuery=true)
    public List<Favorite> get_favorites_by_client(@Param("id_client")int id_client);
	
	@Query(value="SELECT * FROM favorite WHERE id_client= :id_client AND id_lodgement= :id_lodgement", nativeQuery=true)
    public Favorite existe_favorites_by_client_and_lodgement(@Param("id_client")int id_client, @Param("id_lodgement")int id_lodgement);

	@Query(value="SELECT * FROM favorite WHERE id_client= :id_client AND id= :id_fav", nativeQuery=true)
    public Favorite existe_favorites_by_client_and_favorite(@Param("id_client")int id_client, @Param("id_fav")int id_fav);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "DELETE FROM favorite WHERE id=:id_fav ", nativeQuery= true)
	public int remove_favorite(@Param("id_fav")int id_fav);
}
