package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Event;
import com.example.demo.Entity.Registration;
import com.example.demo.Entity.User;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long>{

//     //	List<Registration> findByEventId(Long eventId);
//
//	    @Query("SELECT r.id AS id, r.user.id AS userId, r.event.id AS eventId, r.status AS status FROM Registration r WHERE r.id = :id")
//	    RegistrationProjection findProjectionById(@Param("id") Long id);
//
//	    @Query("SELECT r.id AS id, r.user.id AS userId, r.event.id AS eventId, r.status AS status FROM Registration r")
//	    List<RegistrationProjection> findAllProjections();
//
//		boolean existsByUserAndEvent(User user, Event event);

	    Optional<Registration> findByUserAndEvent(User user, Event event);


}
