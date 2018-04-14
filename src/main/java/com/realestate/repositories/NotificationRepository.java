package com.realestate.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.models.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>{

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO notification VALUES ( NULL, :id_appointement, :client_notif, :agent_notif, CURRENT_TIMESTAMP, '0', '0')", nativeQuery= true)
	public int add_notification(@Param("id_appointement")int id_appointement, @Param("client_notif")String client_notif,  @Param("agent_notif")String agent_notif);

	@Query(value = "SELECT * FROM `notification` WHERE id_appointement in ( SELECT id FROM appointement WHERE appointement.id_client=:id_client) ORDER BY time DESC", nativeQuery= true)
	public List<Notification> get_notifications_by_client_id(@Param("id_client") int id_client);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO notification VALUES ( NULL, :id_appointement, :client_notif, :agent_notif, CURRENT_TIMESTAMP, '1', '0')", nativeQuery= true)
	public int add_client_confirm_notification(@Param("id_appointement")int id_appointement, @Param("client_notif")String client_notif,  @Param("agent_notif")String agent_notif);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO notification VALUES ( NULL, :id_appointement, :client_notif, :agent_notif, CURRENT_TIMESTAMP, '0', '0')", nativeQuery= true)
	public int add_client_cancel_notification(@Param("id_appointement")int id_appointement, @Param("client_notif")String client_notif,  @Param("agent_notif")String agent_notif);

}
