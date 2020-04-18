package devesh.ephrine.pinboard.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = {"id", "timestamp"}, unique = true)})
public class Note {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "id")
    public String ID;

    @ColumnInfo(name = "note_content")
    public String NOTE_content;

    @ColumnInfo(name = "title")
    public String TITLE;

    @ColumnInfo(name = "timestamp")
    public String TIME_STAMP;

    @ColumnInfo(name = "color")
    public String COLOR;

    @ColumnInfo(name = "label")
    public String LABEL;

    @ColumnInfo(name = "last_modified")
    public String LAST_MODIFIED;

    @ColumnInfo(name = "ispinned")
    public boolean IS_PINNED;

   @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    public byte[] THUMB_IMAGE;

  /* public Note(String ID,String NOTE_content,String TITLE,
           String TIME_STAMP, String COLOR, String LABEL,
               String LAST_MODIFIED, boolean IS_PINNED){
       this.ID=ID;
       this.NOTE_content=NOTE_content;
       this.TITLE=TITLE;
       this.TIME_STAMP=TIME_STAMP;
       this.COLOR=COLOR;
       this.LABEL=LABEL;
       this.LAST_MODIFIED=LAST_MODIFIED;
       this.IS_PINNED=IS_PINNED;

    }
    */
}
