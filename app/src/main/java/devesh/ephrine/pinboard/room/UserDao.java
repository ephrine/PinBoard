package devesh.ephrine.pinboard.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
       @Query("SELECT * FROM Note ORDER BY timestamp ASC")
    List<Note> getAll();

//    @Query("SELECT * FROM Note")
 //   List<Note> getAll();


  //  @Query("SELECT * FROM Note WHERE uid IN (:notesid)")
//    List<Note> loadSelected(List<Note> notesid);

     @Query("SELECT * FROM Note WHERE uid IN (:noteUID)")
     List<Note> loadSelected( String noteUID );

   // @Query("SELECT * FROM Note WHERE phone IN (:phn)")
   // List<Note> loadAllByPhoneNo(String phn);

    /*  @Query("SELECT * FROM Note WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);
*/
    @Insert
    void insertAll(Note... sms);

    @Delete
    void delete(Note sms);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllr(Note sms);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllr2(List<Note> sms);

   // @Query("SELECT * FROM Note WHERE `to` OR `from` IN (:phn) ORDER BY time ASC")
   // List<Note> loadAllByPhoneNo2(String phn);

}