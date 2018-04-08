package com.realestate.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.models.Wishlist;

public interface WishRepository extends JpaRepository<Wishlist, Integer>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO `wishlist`  VALUES (NULL, :id_client, :address , :type, :max_surface, :min_surface , :max_price, :min_price, :max_floor, :min_floor, '0' , '0')", nativeQuery= true)
	public int add_wish(@Param("id_client") int id_client, 
						 @Param("address") String address, 
						 @Param("type") String type,
						 @Param("max_surface") double max_surface,
						 @Param("min_surface") double min_surface,
						 @Param("max_price") double max_price,
						 @Param("min_price") double min_price,
						 @Param("max_floor") int max_floor,
						 @Param("min_floor") int min_floor);
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE wishlist SET found = '1', id_found = :id_found WHERE id = :id", nativeQuery= true)
	public int found_wish(@Param("id") int id, @Param("id_found") int id_found);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "DELETE FROM wishlist WHERE id = :id", nativeQuery= true)
	public int remove_wish(@Param("id") int id);

	@Query(value = "SELECT * FROM wishlist WHERE id_client = :id_client ", nativeQuery= true)
	public List<Wishlist> get_all_wished_by_client(@Param("id_client") int id_client);

	@Query(value="SELECT found FROM wishlist WHERE id = :id ", nativeQuery= true)
	public int is_found_wish(@Param("id")int id);
	
}
