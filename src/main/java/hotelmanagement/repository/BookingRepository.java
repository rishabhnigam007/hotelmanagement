package hotelmanagement.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hotelmanagement.entity.BookingEntity;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity ,Long>
{
	@Query(value = "select count(*) from booking b where b.bookid = :bookid",	nativeQuery = true)
	int isDeleteBooking(@Param("bookid") long bookid);

	@Transactional
	@Modifying
	@Query(value = "delete from booking b where b.bookid=:bookid",nativeQuery = true)
	void del(@Param("bookid") long bookid);
	
//	Booking save(Booking b);

	@Query(value = "select sum(no_ofrooms) from booking b where b.bookdate = ?1" ,nativeQuery = true)
	Integer isCount(Date bookDate);
	
}